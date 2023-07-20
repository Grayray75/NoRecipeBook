package io.grayray75.fabric.norecipebook.mixin;

import io.grayray75.fabric.norecipebook.NoRecipeBook;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public class MixinScreen {

    @Inject(method = "addButton", at = @At("HEAD"), cancellable = true)
    public void addButton(ButtonWidget widget, CallbackInfoReturnable<ButtonWidget> info) {
        if (!info.isCancelled() && NoRecipeBook.isRecipeButton((Screen) (Object) this, widget)) {
            info.setReturnValue(widget);
        }
    }
}
