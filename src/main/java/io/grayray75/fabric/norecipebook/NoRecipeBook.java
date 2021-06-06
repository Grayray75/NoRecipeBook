package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetMixin;
import me.shedaniel.cloth.api.client.events.v0.ClothClientHooks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.ActionResult;
import org.apache.logging.log4j.LogManager;

@Environment(EnvType.CLIENT)
public class NoRecipeBook implements ClientModInitializer {
    final String TexturePath = "textures/gui/recipe_button.png";

    @Override
    public void onInitializeClient() {
        LogManager.getLogger().info("Initializing NoRecipeBook Mod");

        ClothClientHooks.SCREEN_ADD_BUTTON.register((client, screen, button) -> {
            if (screen instanceof HandledScreen && button instanceof TexturedButtonWidget) {
                if (((TexturedButtonWidgetMixin) button).getTexture().getPath().equals(TexturePath)) {
                    return ActionResult.FAIL;
                }
            }
            return ActionResult.PASS;
        });
    }
}
