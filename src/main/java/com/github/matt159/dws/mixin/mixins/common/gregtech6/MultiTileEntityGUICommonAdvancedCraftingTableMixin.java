package com.github.matt159.dws.mixin.mixins.common.gregtech6;

import com.github.matt159.dws.util.Constants;
import gregapi.tileentity.tools.MultiTileEntityAdvancedCraftingTable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

@Mixin(MultiTileEntityAdvancedCraftingTable.MultiTileEntityGUICommonAdvancedCraftingTable.class)
public abstract class MultiTileEntityGUICommonAdvancedCraftingTableMixin extends Container {
    @Redirect(method = "addSlots",
              at = @At(value = "INVOKE",
                       target = "Lgregapi/tileentity/tools/MultiTileEntityAdvancedCraftingTable$MultiTileEntityGUICommonAdvancedCraftingTable;addSlotToContainer(Lnet/minecraft/inventory/Slot;)Lnet/minecraft/inventory/Slot;",
                       remap = true),
              remap = false,
              require = 1)
    private Slot adjustSlotXOffset(MultiTileEntityAdvancedCraftingTable.MultiTileEntityGUICommonAdvancedCraftingTable instance, Slot slot) {
        if (slot == null) {
            return null;
        }

        slot.xDisplayPosition += Constants.GENERAL_X_OFFSET;

        return this.addSlotToContainer(slot);
    }
}
