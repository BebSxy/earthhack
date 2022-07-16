package me.earth.earthhack.impl.modules.render.skycolor;

import me.earth.earthhack.api.module.Module;
import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.api.setting.Setting;
import me.earth.earthhack.api.setting.settings.ColorSetting;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class SkyColor extends Module {
    public SkyColor() {
        super("SkyColor", Category.Render);
    }
    protected final Setting<Color> color = register(new ColorSetting("Color", new Color(178, 115, 255, 255)));

    public Color getColor()
    {
        return new Color(color.getValue().getRed(), color.getValue().getGreen(), color.getValue().getBlue(), color.getValue().getAlpha());
    }

    @SubscribeEvent
    public void onUpdate(EntityViewRenderEvent.FogColors event) {
        event.setRed(this.color.getValue().getRed() / 255.0f);
        event.setGreen(this.color.getValue().getGreen() / 255.0f);
        event.setBlue(this.color.getValue().getBlue() / 255.0f);
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}
