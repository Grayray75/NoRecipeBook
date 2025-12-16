package io.grayray75.mods.norecipebook;

import io.grayray75.mods.norecipebook.mixin.ImageButtonAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RECIPE_BUTTON_TEXTURE_PATH = "recipe_book/button";

    public static <T extends GuiEventListener & Renderable & NarratableEntry> boolean isRecipeButton(Screen screen, T button) {
        if (screen instanceof AbstractContainerScreen && button instanceof ImageButton) {
            return ((ImageButtonAccessor) button).getSprites().get(true, false).getPath().equals(RECIPE_BUTTON_TEXTURE_PATH);
        }
        return false;
    }
}
