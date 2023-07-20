package io.grayray75.fabric.norecipebook.mixin;

import net.minecraft.class_3256;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(class_3256.class)
public interface TexturedButtonWidgetAccessor {
    @Accessor("field_15891")
    Identifier getTexture();
}
