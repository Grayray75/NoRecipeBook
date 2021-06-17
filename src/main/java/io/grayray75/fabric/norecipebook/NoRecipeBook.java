package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetMixin;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import org.apache.logging.log4j.LogManager;

@Environment(EnvType.CLIENT)
public class NoRecipeBook implements ClientModInitializer {
    static final String TexturePath = "textures/gui/recipe_button.png";

    public static boolean isRecipeButton(Screen screen, AbstractButtonWidget button) {
        if (screen instanceof ContainerScreen && button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetMixin) button).getTexture().getPath().equals(TexturePath);
        }
        return false;
    }

    @Override
    public void onInitializeClient() {
        LogManager.getLogger().info("Initializing NoRecipeBook Mod");
    }
}
