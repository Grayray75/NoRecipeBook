package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.class_3259;
import net.minecraft.class_3262;
import net.minecraft.class_3264;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_3264.class)
public class ToastManagerMixin {

    @Inject(method = "method_14491", at = @At("HEAD"), cancellable = true)
    public void add(class_3262 toast, CallbackInfo ci) {
        if (toast instanceof class_3259) {
            ci.cancel();
        }
    }
}
