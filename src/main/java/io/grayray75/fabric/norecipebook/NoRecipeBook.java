package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetMixin;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import org.apache.logging.log4j.LogManager;

@Environment(EnvType.CLIENT)
public class NoRecipeBook implements ClientModInitializer {
    static final String TexturePath = "textures/gui/container/crafting_table.png";

    public static boolean isRecipeButton(ButtonWidget button) {
        if (button instanceof TexturedButtonWidget) {
            return ((TexturedButtonWidgetMixin) button).getTexture().getPath().equals(TexturePath);
        }
        return false;
    }

    @Override
    public void onInitializeClient() {
        LogManager.getLogger().info("Initializing NoRecipeBook Mod");
    }
}
