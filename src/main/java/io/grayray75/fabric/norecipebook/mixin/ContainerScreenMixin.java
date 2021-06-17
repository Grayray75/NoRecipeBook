package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ContainerScreen.class)
public interface ContainerScreenMixin {
    @Accessor("containerWidth")
    int getBackgroundWidth();

    @Accessor("x")
    void setX(int value);
}
