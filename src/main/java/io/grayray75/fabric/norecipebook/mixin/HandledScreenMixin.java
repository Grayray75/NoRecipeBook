package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface HandledScreenMixin {
    @Accessor("backgroundWidth")
    int getBackgroundWidth();

    @Accessor("x")
    void setX(int value);
}