package me.earth.earthhack.impl.core.mixins.render;

import me.earth.earthhack.api.cache.ModuleCache;
import me.earth.earthhack.impl.modules.Caches;
import me.earth.earthhack.impl.modules.render.ambience.Ambience;
import net.minecraft.client.renderer.BufferBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.nio.IntBuffer;

@Mixin(BufferBuilder.class)
public abstract class MixinBufferBuilder
{
    private static final ModuleCache<Ambience> AMBIENCE = Caches.getModule(Ambience.class);

    @Redirect(
        method = "putColorMultiplier",
        at = @At(
            value = "INVOKE",
            remap = false,
            target = "java/nio/IntBuffer.put(II)Ljava/nio/IntBuffer;"))
    private IntBuffer putColorMultiplierHook(IntBuffer buffer, int index, int i)
    {
        // TODO: remove if needed
        /*if (AMBIENCE.isEnabled())
        {
            // TODO: gotta check if we need 2 swap!!!
            Color color = AMBIENCE.get().getColor();
            int[] bgr = MathUtil.toRGBAArray(i);
            int red = (bgr[2] + color.getRed()) / 2; // half-half mix of both colors
            int green = (bgr[1] + color.getGreen()) / 2;
            int blue = (bgr[0] + color.getBlue()) / 2;
            float[] hsb = Color.RGBtoHSB(red, green, blue, null);
            if (AMBIENCE.get().useSaturation())
            {
                hsb[1] = AMBIENCE.get().getSaturation();
                int rgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
                int[] bgr1 = MathUtil.toRGBAArray(rgb);
                red = bgr1[2];
                green = bgr1[1];
                blue = bgr1[0];
            }
            i = MathUtil.toRGBAReversed(red, green, blue);
        }*/

        // return buffer.put(index, new Color(255, 0, 0, 255).getRGB());
        return buffer.put(index, i);
    }

}