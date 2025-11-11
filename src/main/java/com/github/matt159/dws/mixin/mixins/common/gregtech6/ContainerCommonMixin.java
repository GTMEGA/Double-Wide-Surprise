package com.github.matt159.dws.mixin.mixins.common.gregtech6;

import com.github.matt159.dws.interfaces.IDWSContainer;
import com.github.matt159.dws.util.Constants;
import gregapi.gui.ContainerCommon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

@Mixin(ContainerCommon.class)
public abstract class ContainerCommonMixin extends Container implements IDWSContainer {
    @Shadow
    protected abstract Slot addSlotToContainer(Slot aSlot);

    @ModifyConstant(method = "bindPlayerInventory",
                    constant = @Constant(intValue = 9),
                    remap = false,
                    require = 4)
    private int expandPlayerInventory(int constant) {
        return 18;
    }

    @Redirect(method = "addSlots",
              at = @At(value = "INVOKE",
                       target = "Lgregapi/gui/ContainerCommon;addSlotToContainer(Lnet/minecraft/inventory/Slot;)Lnet/minecraft/inventory/Slot;"),
              remap = false)
    private Slot adjustSlotXOffset(ContainerCommon instance, Slot slot) {
        slot.xDisplayPosition += Constants.GENERAL_X_OFFSET;

        return this.addSlotToContainer(slot);
    }

    @ModifyConstant(method = { "getAllSlotCount", "transferStackInSlot" },
                    constant = @Constant(intValue = 36),
                    remap = false,
                    require = 2)
    private int modifyPlayerSlotCount(int constant) {
        return 72;
    }
}
