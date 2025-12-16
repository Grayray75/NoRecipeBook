package io.grayray75.mods.norecipebook.mixin;

import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.WidgetSprites;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ImageButton.class)
public interface TexturedButtonWidgetAccessor {
    @Accessor("sprites")
    WidgetSprites getTextures();
}
