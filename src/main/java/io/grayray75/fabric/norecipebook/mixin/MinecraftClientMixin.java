package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {

    @Inject(method = "openScreen", at = @At("TAIL"))
    public void openScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (screen instanceof RecipeBookProvider && screen instanceof HandledScreen) {
            RecipeBookWidget widget = ((RecipeBookProvider) screen).getRecipeBookWidget();
            HandledScreenMixin handledScreen = ((HandledScreenMixin) screen);
            if (widget.isOpen()) {
                widget.reset(false);
                widget.toggleOpen();
                handledScreen.setX(widget.findLeftEdge(false, screen.width, handledScreen.getBackgroundWidth()));
            }
        }
    }
}
