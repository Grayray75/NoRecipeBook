package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RecipeButtonTexturePath = "textures/gui/container/crafting_table.png";

    public static boolean isRecipeButton(ButtonWidget button) {
        if (button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetAccessor) button).getTexture().getPath().equals(RecipeButtonTexturePath);
        }
        return false;
    }
}
