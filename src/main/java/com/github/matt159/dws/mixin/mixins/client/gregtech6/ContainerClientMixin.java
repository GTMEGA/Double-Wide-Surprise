package com.github.matt159.dws.mixin.mixins.client.gregtech6;

import com.github.matt159.dws.interfaces.IDWSGui;
import gregapi.gui.ContainerClient;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

@Mixin(ContainerClient.class)
public abstract class ContainerClientMixin extends GuiContainer implements IDWSGui {
    public ContainerClientMixin(Container inventorySlots) {
        super(inventorySlots);
    }
}
