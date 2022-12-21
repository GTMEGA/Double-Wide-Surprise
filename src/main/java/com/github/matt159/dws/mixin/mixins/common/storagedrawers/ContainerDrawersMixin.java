package com.github.matt159.dws.mixin.mixins.common.storagedrawers;

import com.jaquadro.minecraft.storagedrawers.inventory.ContainerDrawers;
import net.minecraft.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ContainerDrawers.class)
public abstract class ContainerDrawersMixin {
    @Shadow(remap = false)
    protected abstract int getStorageSlotX(int slot);

    @ModifyConstant(method = "<init>",
                    constant = @Constant(intValue = 9),
                    require = 4)
    private int modifyPlayerContainerSize(int constant) {
        return 18;
    }

    @Redirect(method = "<init>",
              at = @At(value = "INVOKE",
                       target = "Lcom/jaquadro/minecraft/storagedrawers/inventory/ContainerDrawers;getStorageSlotX(I)I"),
              remap = false,
              require = 1)
    private int redirectAddSlot(ContainerDrawers instance, int slot) {
        return getStorageSlotX(slot) + 81;
    }

    @ModifyConstant(method = "<init>",
                    constant = @Constant(intValue = 44),
                    require = 1)
    private int modifySlotXOffset(int constant) {
        return constant + 81;
    }
}
