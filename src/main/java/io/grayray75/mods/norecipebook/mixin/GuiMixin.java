package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public abstract class GuiMixin {

    @Inject(method = "setScreen", at = @At("TAIL"))
    private void setScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (screen instanceof AbstractRecipeBookScreen<?> recipeBookScreen) {
            RecipeBookComponent<?> recipeBook = ((AbstractRecipeBookScreenAccessor) recipeBookScreen).getRecipeBook();
            AbstractContainerScreenAccessor containerScreen = ((AbstractContainerScreenAccessor) screen);

            if (recipeBook.isVisible()) {
                recipeBook.toggleVisibility();
                containerScreen.setLeftPos(recipeBook.updateScreenPosition(screen.width, containerScreen.getImageWidth()));
            }
        }
    }
}
