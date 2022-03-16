package com.github.matt159.putin.mixins.client.minecraft;

import com.github.matt159.putin.interfaces.IMinecraftGuiMixin;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Gui.class)
public class GuiMixin implements IMinecraftGuiMixin {
    @Shadow protected float zLevel;

    @Override
    public float getZLevel() {
        return zLevel;
    }
}
