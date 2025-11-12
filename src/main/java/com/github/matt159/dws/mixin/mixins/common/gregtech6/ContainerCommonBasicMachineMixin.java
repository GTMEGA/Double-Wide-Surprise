package com.github.matt159.dws.mixin.mixins.common.gregtech6;

import com.github.matt159.dws.util.Constants;
import gregapi.gui.ContainerCommonBasicMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

@Mixin(ContainerCommonBasicMachine.class)
public abstract class ContainerCommonBasicMachineMixin extends Container {
    @Redirect(method = "addSlots",
              at = @At(value = "INVOKE",
                       target = "Lgregapi/gui/ContainerCommonBasicMachine;addSlotToContainer(Lnet/minecraft/inventory/Slot;)Lnet/minecraft/inventory/Slot;",
                       remap = true),
              remap = false,
              require = 1)
    private Slot adjustSlotXOffset(ContainerCommonBasicMachine instance, Slot slot) {
        if (slot == null) {
            return null;
        }

        slot.xDisplayPosition += Constants.GENERAL_X_OFFSET;

        return this.addSlotToContainer(slot);
    }
}
