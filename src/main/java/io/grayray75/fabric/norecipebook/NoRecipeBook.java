package io.grayray75.fabric.norecipebook;

import io.grayray75.fabric.norecipebook.mixin.TexturedButtonWidgetAccessor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_3256;
import net.minecraft.client.gui.widget.ButtonWidget;

@Environment(EnvType.CLIENT)
public class NoRecipeBook {
    private static final String RecipeButtonTexturePath1 = "textures/gui/container/crafting_table.png";
    private static final String RecipeButtonTexturePath2 = "textures/gui/container/inventory.png";

    public static boolean isRecipeButton(ButtonWidget button) {
        if (button instanceof class_3256) {
            return ((TexturedButtonWidgetAccessor) button).getTexture().getPath().equals(RecipeButtonTexturePath1) ||
                   ((TexturedButtonWidgetAccessor) button).getTexture().getPath().equals(RecipeButtonTexturePath2);
        }
        return false;
    }
}
