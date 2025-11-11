package com.github.matt159.dws.mixin.mixins.client.gregtech6;

import com.github.matt159.dws.util.Constants;
import gregapi.gui.ContainerClient;
import gregapi.gui.ContainerClientBasicMachine;
import gregapi.gui.ContainerCommon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ContainerClientBasicMachine.class)
public abstract class ContainerClientBasicMachineMixin extends ContainerClient {
    public ContainerClientBasicMachineMixin(ContainerCommon aContainer, String aBackgroundPath) {
        super(aContainer, aBackgroundPath);
    }

    @Redirect(method = "drawGuiContainerBackgroundLayer2",
              slice = @Slice(from = @At(value = "FIELD",
                                        target = "Lgregapi/recipes/Recipe$RecipeMap;mProgressBarDirection:B",
                                        ordinal = 0),
                             to = @At("TAIL"),
                             id = "slice"),
              at = @At(value = "INVOKE",
                       target = "Lgregapi/gui/ContainerClientBasicMachine;drawTexturedModalRect(IIIIII)V",
                       slice = "slice"),
              remap = false,
              require = 8)
    private void adjustXOffsets(ContainerClientBasicMachine instance, int x, int y, int u, int v, int w, int h) {
        this.drawTexturedModalRect(x + Constants.GENERAL_X_OFFSET,
                                   y,
                                   u - 176 + Constants.GENERAL_DWS_GUI_WIDTH,
                                   v,
                                   w,
                                   h);
    }
}
