package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractContainerScreen.class)
public interface HandledScreenAccessor {
    @Accessor("imageWidth")
    int getBackgroundWidth();

    @Accessor("leftPos")
    void setX(int value);
}
