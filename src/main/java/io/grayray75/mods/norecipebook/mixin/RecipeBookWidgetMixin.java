package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeBookWidget.class)
public abstract class RecipeBookWidgetMixin<T extends AbstractRecipeScreenHandler> {
    @Shadow
    @Final
    protected T craftingScreenHandler;
    @Unique
    private boolean initialized = false;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        this.initialized = true;
    }

    @Inject(method = "isOpen", at = @At("HEAD"), cancellable = true)
    private void isOpen(CallbackInfoReturnable<Boolean> info) {
        if (!initialized || this.craftingScreenHandler == null) {
            info.setReturnValue(false);
        }
    }
}
