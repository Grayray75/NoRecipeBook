package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.world.inventory.RecipeBookMenu;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeBookComponent.class)
public abstract class RecipeBookWidgetMixin<T extends RecipeBookMenu> {
    @Shadow
    @Final
    protected T menu;
    @Unique
    private boolean initialized = false;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        this.initialized = true;
    }

    @Inject(method = "isVisible", at = @At("HEAD"), cancellable = true)
    private void isOpen(CallbackInfoReturnable<Boolean> info) {
        if (!initialized || this.menu == null) {
            info.setReturnValue(false);
        }
    }
}
