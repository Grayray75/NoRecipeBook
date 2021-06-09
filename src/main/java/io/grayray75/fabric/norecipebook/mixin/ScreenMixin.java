package io.grayray75.fabric.norecipebook.mixin;

import io.grayray75.fabric.norecipebook.NoRecipeBook;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.Selectable;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public class ScreenMixin {

    @Inject(method = "addDrawableChild", at = @At("HEAD"), cancellable = true)
    protected <T extends Element & Drawable & Selectable> void addDrawableChild(T child, CallbackInfoReturnable<T> info) {
        if (!info.isCancelled() && NoRecipeBook.isRecipeButton((Screen) (Object) this, child)) {
            info.setReturnValue(child);
        }
    }
}
