package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.client.gui.screen.RecipeBookScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeBookScreen.class)
public abstract class MixinRecipeBookScreen {
    private boolean initialized = false;

    @Inject(method = "<init>", at = @At("TAIL"))
    public void init(CallbackInfo ci) {
        this.initialized = true;
    }

    @Inject(method = "method_14590", at = @At("HEAD"), cancellable = true)
    public void isOpen(CallbackInfoReturnable<Boolean> info) {
        if (!initialized) {
            info.setReturnValue(false);
        }
    }
}
