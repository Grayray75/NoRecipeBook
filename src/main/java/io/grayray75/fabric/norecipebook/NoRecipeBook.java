package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetMixin;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import org.apache.logging.log4j.LogManager;

@Environment(EnvType.CLIENT)
public class NoRecipeBook implements ClientModInitializer {
    static final String TexturePath = "textures/gui/recipe_button.png";

    public static <T extends Element & Drawable & Selectable> boolean isRecipeButton(Screen screen, T button) {
        if (screen instanceof HandledScreen && button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetMixin) button).getTexture().getPath().equals(TexturePath);
        }
        return false;
    }

    @Override
    public void onInitializeClient() {
        LogManager.getLogger().info("Initializing NoRecipeBook Mod");
    }
}
