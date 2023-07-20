package io.grayray75.fabric.norecipebook.mixin;

import io.grayray75.fabric.norecipebook.NoRecipeBook;
import net.minecraft.class_3288;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.RecipeBookScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient {

    @Inject(method = "setScreen", at = @At("TAIL"))
    public void openScreen(@Nullable Screen screen, CallbackInfo ci) {
        if (screen instanceof class_3288 && screen instanceof HandledScreen) {
            for (ButtonWidget bw : ((ScreenAccessor) screen).getButtons()) {
                if (NoRecipeBook.isRecipeButton(bw)) {
                    bw.visible = false;
                    bw.active = false;
                }
            }

            RecipeBookScreen widget = ((class_3288) screen).method_14638();
            ContainerScreenAccessor containerScreen = ((ContainerScreenAccessor) screen);
            if (widget.method_14590()) {
                widget.method_14587();
                containerScreen.setX(widget.method_14585(false, screen.width, containerScreen.getBackgroundWidth()));
            }
        }
    }
}
