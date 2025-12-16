package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin {

    @Inject(method = "setScreen", at = @At("TAIL"))
    private void setScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (screen instanceof AbstractRecipeBookScreen<?> recipeBookScreen) {
            RecipeBookComponent<?> widget = ((RecipeBookScreenAccessor) recipeBookScreen).getRecipeBook();
            HandledScreenAccessor handledScreen = ((HandledScreenAccessor) screen);
            if (widget.isVisible()) {
                //widget.reset();
                widget.toggleVisibility();
                handledScreen.setX(widget.updateScreenPosition(screen.width, handledScreen.getBackgroundWidth()));
            }
        }
    }
}
