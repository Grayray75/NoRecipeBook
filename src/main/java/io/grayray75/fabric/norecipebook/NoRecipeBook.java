package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RecipeButtonTexturePath = "textures/gui/recipe_button.png";

    public static boolean isRecipeButton(Screen screen, AbstractButtonWidget button) {
        if (screen instanceof ContainerScreen && button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetAccessor) button).getTexture().getPath().equals(RecipeButtonTexturePath);
        }
        return false;
    }
}
