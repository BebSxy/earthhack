package me.earth.earthhack.impl.core.mixins.render;

import me.earth.earthhack.api.cache.ModuleCache;
import me.earth.earthhack.impl.modules.Caches;
import me.earth.earthhack.impl.modules.render.ambience.Ambience;
import net.minecraft.block.BlockVine;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModelRenderer.class)
public abstract class MixinBlockModelRenderer {
    private static final ModuleCache<Ambience> AMBIENCE = Caches.getModule(Ambience.class);

    @Shadow
    public abstract boolean renderModelSmooth(IBlockAccess access,
                                              IBakedModel model,
                                              IBlockState state,
                                              BlockPos pos,
                                              BufferBuilder bufferBuilder,
                                              boolean checkSides,
                                              long rand);

    @Inject(
            method = "renderModel(Lnet/minecraft/world/IBlockAccess;" +
                    "Lnet/minecraft/client/renderer/block/model/IBakedModel;" +
                    "Lnet/minecraft/block/state/IBlockState;" +
                    "Lnet/minecraft/util/math/BlockPos;" +
                    "Lnet/minecraft/client/renderer/BufferBuilder;ZJ)Z",
            at = @At("HEAD"),
            cancellable = true)
    private void renderModelHook(IBlockAccess access,
                                 IBakedModel model,
                                 IBlockState state,
                                 BlockPos pos,
                                 BufferBuilder bufferBuilder,
                                 boolean checkSides,
                                 long rand,
                                 CallbackInfoReturnable<Boolean> info) {
        // TODO: remove if needed
        /*if (AMBIENCE.isEnabled())
        {
            info.setReturnValue(this.renderModelSmooth(
                    access,
                    model,
                    state,
                    pos,
                    bufferBuilder,
                    true,
                    rand));
            return;
        }*/

    }
}
