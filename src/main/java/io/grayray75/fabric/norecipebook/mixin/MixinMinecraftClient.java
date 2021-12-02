package io.grayray75.fabric.norecipebook.mixin;

import io.grayray75.fabric.norecipebook.NoRecipeBook;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient {

    @Inject(method = "openScreen", at = @At("TAIL"))
    public void openScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (screen instanceof RecipeBookProvider && screen instanceof ContainerScreen) {
            for (ButtonWidget bw : ((ScreenAccessor) screen).getButtons()) {
                if (NoRecipeBook.isRecipeButton(bw)) {
                    bw.visible = false;
                    bw.active = false;
                }
            }

            RecipeBookWidget widget = ((RecipeBookProvider) screen).getRecipeBookWidget();
            ContainerScreenAccessor containerScreen = ((ContainerScreenAccessor) screen);
            if (widget.isOpen()) {
                widget.toggleOpen();
                containerScreen.setX(widget.findLeftEdge(false, screen.width, containerScreen.getBackgroundWidth()));
            }
        }
    }
}
