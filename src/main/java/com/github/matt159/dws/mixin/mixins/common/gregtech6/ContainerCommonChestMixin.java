package com.github.matt159.dws.mixin.mixins.common.gregtech6;

import com.github.matt159.dws.util.Constants;
import gregapi.gui.ContainerCommonChest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

@Mixin(ContainerCommonChest.class)
public abstract class ContainerCommonChestMixin extends Container {
    @Redirect(method = "addSlots",
              at = @At(value = "INVOKE",
                       target = "Lgregapi/gui/ContainerCommonChest;addSlotToContainer(Lnet/minecraft/inventory/Slot;)Lnet/minecraft/inventory/Slot;"),
              require = 1)
    private Slot adjustSlotXOffset(ContainerCommonChest instance, Slot slot) {
        slot.xDisplayPosition += Constants.GENERAL_X_OFFSET;

        return this.addSlotToContainer(slot);
    }
}
