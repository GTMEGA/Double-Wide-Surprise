package com.github.matt159.dws.mixin.mixins.common.gregtech6;

import com.github.matt159.dws.util.Constants;
import gregapi.NEI_RecipeMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NEI_RecipeMap.GT_RectHandler.class)
public abstract class GT_RectHandlerMixin {
    @ModifyConstant(method = {"transferRect", "handleTooltip" },
                    constant = @Constant(intValue = 65),
                    remap = false,
                    require = 2)
    private int modifyTransferRectangleXPosition(int constant) {
        return constant + Constants.GENERAL_X_OFFSET;
    }
}
