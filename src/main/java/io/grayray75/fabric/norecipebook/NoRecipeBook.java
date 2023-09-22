package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RECIPE_BUTTON_TEXTURE_PATH = "recipe_book/button";

    public static <T extends Element & Drawable & Selectable> boolean isRecipeButton(Screen screen, T button) {
        if (screen instanceof HandledScreen && button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetAccessor) button).getTextures().get(true, false).getPath().equals(RECIPE_BUTTON_TEXTURE_PATH);
        }
        return false;
    }
}
