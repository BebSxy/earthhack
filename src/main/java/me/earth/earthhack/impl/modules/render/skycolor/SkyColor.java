package me.earth.earthhack.impl.modules.render.skycolor;

import me.earth.earthhack.api.module.Module;
import me.earth.earthhack.api.module.util.Category;
import me.earth.earthhack.api.setting.Setting;
import me.earth.earthhack.api.setting.settings.ColorSetting;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class SkyColor extends Module {
    public SkyColor() {
        super("SkyColor", Category.Render);
    }
    protected final Setting<Color> color = register(new ColorSetting("Color", new Color(82, 2, 241, 255)));

    public Color getColor()
    {
        return new Color(color.getValue().getRed(), color.getValue().getGreen(), color.getValue().getBlue(), color.getValue().getAlpha());
    }

    @SubscribeEvent
    public void onEntityRender(final EntityViewRenderEvent.FogColors event) {
        event.setRed(getColor().getRed() / 255.0f);
        event.setGreen(getColor().getGreen() / 255.0f);
        event.setBlue(getColor().getBlue() / 255.0f);
    }
}
