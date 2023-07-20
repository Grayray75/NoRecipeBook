package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_3256;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RecipeButtonTexturePath = "textures/gui/recipe_button.png";

    public static boolean isRecipeButton(Screen screen, ButtonWidget button) {
        if (screen instanceof HandledScreen && button instanceof class_3256) {
            return ((TexturedButtonWidgetAccessor) button).getTexture().getPath().equals(RecipeButtonTexturePath);
        }
        return false;
    }
}
