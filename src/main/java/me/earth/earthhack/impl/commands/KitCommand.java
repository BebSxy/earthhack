/* package me.earth.earthhack.impl.commands;

import io.netty.buffer.Unpooled;
import me.earth.earthhack.api.util.interfaces.Globals;
import me.earth.earthhack.impl.commands.abstracts.AbstractStackCommand;
import me.earth.earthhack.impl.commands.packet.util.BufferUtil;
import me.earth.earthhack.impl.commands.util.CommandDescriptions;
import me.earth.earthhack.impl.util.text.TextColor;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class KitCommand extends AbstractStackCommand implements Globals
{
    private static final ItemStack KIT;

    static
    {
        ItemStack stack;
        PacketBuffer buffer = null;

        try
        {
            // Easiest way was just to dump the serialized kit
            buffer = new PacketBuffer(Unpooled.wrappedBuffer(
                    //<editor-fold defaultstate="collapsed" desc="Serialized Kit">
                    new byte[]
                            {
                                    0, -34, 1, 0, 0, 10, 0, 0, 10, 0, 14, 66, 108, 111, 99, 107, 69, 110, 116,
                                    105, 116, 121, 84, 97, 103, 9, 0, 5, 73, 116, 101, 109, 115, 10, 0, 0,
                                    0, 27, 1, 0, 4, 83, 108, 111, 116, 0, 8, 0, 2, 105, 100, 0, 24, 109, 105,
                                    110, 101, 99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110, 100,
                                    95, 104, 101, 108, 109, 101, 116, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10,
                                    0, 3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 5, 2, 0, 3,
                                    108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3, 108, 118, 108,
                                    0, 4, 2, 0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2,
                                    105, 100, 0, 70, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0,
                                    5, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2, 105, 100, 0, 6, 0, 3, 0, 10,
                                    82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0, 0, 31, 10, 0, 7, 100,
                                    105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109, 101, 0, 14, 51, 97,
                                    114, 116, 104, 39, 115, 32, 72, 51, 108, 109, 101, 116, 0, 0, 2, 0, 6,
                                    68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 1, 8, 0,
                                    2, 105, 100, 0, 28, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100,
                                    105, 97, 109, 111, 110, 100, 95, 99, 104, 101, 115, 116, 112, 108, 97,
                                    116, 101, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0, 3, 116, 97, 103, 9,
                                    0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 3, 2, 0, 3, 108, 118, 108, 0, 4,
                                    2, 0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105,
                                    100, 0, 34, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2, 105, 100, 0, 70,
                                    0, 3, 0, 10, 82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0, 0, 7,
                                    10, 0, 7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109, 101,
                                    0, 18, 51, 97, 114, 116, 104, 39, 115, 32, 67, 104, 51, 115, 116, 112,
                                    108, 52, 116, 101, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1,
                                    0, 4, 83, 108, 111, 116, 2, 8, 0, 2, 105, 100, 0, 26, 109, 105, 110, 101,
                                    99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110, 100, 95, 108, 101,
                                    103, 103, 105, 110, 103, 115, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0,
                                    3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 3, 2, 0, 3, 108,
                                    118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 3, 0, 2, 0, 3, 108, 118, 108, 0,
                                    3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2,
                                    105, 100, 0, 70, 0, 3, 0, 10, 82, 101, 112, 97, 105, 114, 67, 111, 115,
                                    116, 0, 0, 0, 7, 10, 0, 7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78,
                                    97, 109, 101, 0, 13, 51, 97, 114, 116, 104, 39, 115, 32, 80, 52, 110, 116,
                                    115, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108,
                                    111, 116, 3, 8, 0, 2, 105, 100, 0, 23, 109, 105, 110, 101, 99, 114, 97,
                                    102, 116, 58, 100, 105, 97, 109, 111, 110, 100, 95, 98, 111, 111, 116,
                                    115, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0, 3, 116, 97, 103, 9, 0,
                                    4, 101, 110, 99, 104, 10, 0, 0, 0, 5, 2, 0, 3, 108, 118, 108, 0, 4, 2,
                                    0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100,
                                    0, 34, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2, 105, 100, 0, 70, 0, 2,
                                    0, 3, 108, 118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 2, 0, 2, 0, 3, 108, 118,
                                    108, 0, 3, 2, 0, 2, 105, 100, 0, 8, 0, 3, 0, 10, 82, 101, 112, 97, 105,
                                    114, 67, 111, 115, 116, 0, 0, 0, 31, 10, 0, 7, 100, 105, 115, 112, 108,
                                    97, 121, 8, 0, 4, 78, 97, 109, 101, 0, 13, 51, 97, 114, 116, 104, 39, 115,
                                    32, 66, 48, 111, 116, 115, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0,
                                    0, 0, 1, 0, 4, 83, 108, 111, 116, 4, 8, 0, 2, 105, 100, 0, 25, 109, 105,
                                    110, 101, 99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110, 100,
                                    95, 112, 105, 99, 107, 97, 120, 101, 1, 0, 5, 67, 111, 117, 110, 116, 1,
                                    10, 0, 3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 4, 2,
                                    0, 3, 108, 118, 108, 0, 5, 2, 0, 2, 105, 100, 0, 32, 0, 2, 0, 3, 108, 118,
                                    108, 0, 3, 2, 0, 2, 105, 100, 0, 35, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2,
                                    0, 2, 105, 100, 0, 70, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100,
                                    0, 34, 0, 3, 0, 10, 82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0,
                                    0, 15, 10, 0, 7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109,
                                    101, 0, 17, 71, 101, 114, 109, 97, 110, 32, 69, 102, 102, 105, 99, 105,
                                    101, 110, 99, 121, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1,
                                    0, 4, 83, 108, 111, 116, 5, 8, 0, 2, 105, 100, 0, 23, 109, 105, 110, 101,
                                    99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110, 100, 95, 115, 119,
                                    111, 114, 100, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0, 3, 116, 97, 103,
                                    9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 4, 2, 0, 3, 108, 118, 108, 0,
                                    2, 2, 0, 2, 105, 100, 0, 20, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2,
                                    105, 100, 0, 70, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0,
                                    34, 0, 2, 0, 3, 108, 118, 108, 0, 5, 2, 0, 2, 105, 100, 0, 16, 0, 3, 0,
                                    10, 82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0, 0, 15, 10, 0,
                                    7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109, 101, 0, 10,
                                    51, 97, 114, 116, 104, 98, 108, 52, 100, 101, 0, 0, 2, 0, 6, 68, 97, 109,
                                    97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 6, 8, 0, 2, 105, 100,
                                    0, 22, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 103, 111, 108, 100,
                                    101, 110, 95, 97, 112, 112, 108, 101, 1, 0, 5, 67, 111, 117, 110, 116,
                                    64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 1, 0, 1, 0, 4, 83, 108, 111,
                                    116, 7, 8, 0, 2, 105, 100, 0, 22, 109, 105, 110, 101, 99, 114, 97, 102,
                                    116, 58, 103, 111, 108, 100, 101, 110, 95, 97, 112, 112, 108, 101, 1, 0,
                                    5, 67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 1,
                                    0, 1, 0, 4, 83, 108, 111, 116, 8, 8, 0, 2, 105, 100, 0, 21, 109, 105, 110,
                                    101, 99, 114, 97, 102, 116, 58, 101, 110, 100, 101, 114, 95, 99, 104, 101,
                                    115, 116, 1, 0, 5, 67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97,
                                    103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 9, 8, 0, 2, 105, 100, 0,
                                    24, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111,
                                    110, 100, 95, 104, 101, 108, 109, 101, 116, 1, 0, 5, 67, 111, 117, 110,
                                    116, 1, 10, 0, 3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0,
                                    5, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3,
                                    108, 118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108,
                                    0, 1, 2, 0, 2, 105, 100, 0, 70, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0,
                                    2, 105, 100, 0, 5, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2, 105, 100,
                                    0, 6, 0, 3, 0, 10, 82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0,
                                    0, 31, 10, 0, 7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109,
                                    101, 0, 14, 51, 97, 114, 116, 104, 39, 115, 32, 72, 51, 108, 109, 101,
                                    116, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108,
                                    111, 116, 10, 8, 0, 2, 105, 100, 0, 28, 109, 105, 110, 101, 99, 114, 97,
                                    102, 116, 58, 100, 105, 97, 109, 111, 110, 100, 95, 99, 104, 101, 115,
                                    116, 112, 108, 97, 116, 101, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0,
                                    3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 3, 2, 0, 3, 108,
                                    118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108, 0,
                                    3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2,
                                    105, 100, 0, 70, 0, 3, 0, 10, 82, 101, 112, 97, 105, 114, 67, 111, 115,
                                    116, 0, 0, 0, 7, 10, 0, 7, 100, 105, 115, 112, 108, 97, 121, 8, 0, 4, 78,
                                    97, 109, 101, 0, 18, 51, 97, 114, 116, 104, 39, 115, 32, 67, 104, 51, 115,
                                    116, 112, 108, 52, 116, 101, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101,
                                    0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 11, 8, 0, 2, 105, 100, 0, 26, 109,
                                    105, 110, 101, 99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110,
                                    100, 95, 108, 101, 103, 103, 105, 110, 103, 115, 1, 0, 5, 67, 111, 117,
                                    110, 116, 1, 10, 0, 3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0,
                                    0, 0, 3, 2, 0, 3, 108, 118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 3, 0, 2, 0,
                                    3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3, 108, 118,
                                    108, 0, 1, 2, 0, 2, 105, 100, 0, 70, 0, 3, 0, 10, 82, 101, 112, 97, 105,
                                    114, 67, 111, 115, 116, 0, 0, 0, 7, 10, 0, 7, 100, 105, 115, 112, 108,
                                    97, 121, 8, 0, 4, 78, 97, 109, 101, 0, 13, 51, 97, 114, 116, 104, 39, 115,
                                    32, 80, 52, 110, 116, 115, 0, 0, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0,
                                    0, 0, 1, 0, 4, 83, 108, 111, 116, 12, 8, 0, 2, 105, 100, 0, 23, 109, 105,
                                    110, 101, 99, 114, 97, 102, 116, 58, 100, 105, 97, 109, 111, 110, 100,
                                    95, 98, 111, 111, 116, 115, 1, 0, 5, 67, 111, 117, 110, 116, 1, 10, 0,
                                    3, 116, 97, 103, 9, 0, 4, 101, 110, 99, 104, 10, 0, 0, 0, 5, 2, 0, 3, 108,
                                    118, 108, 0, 4, 2, 0, 2, 105, 100, 0, 0, 0, 2, 0, 3, 108, 118, 108, 0,
                                    3, 2, 0, 2, 105, 100, 0, 34, 0, 2, 0, 3, 108, 118, 108, 0, 1, 2, 0, 2,
                                    105, 100, 0, 70, 0, 2, 0, 3, 108, 118, 108, 0, 4, 2, 0, 2, 105, 100, 0,
                                    2, 0, 2, 0, 3, 108, 118, 108, 0, 3, 2, 0, 2, 105, 100, 0, 8, 0, 3, 0, 10,
                                    82, 101, 112, 97, 105, 114, 67, 111, 115, 116, 0, 0, 0, 31, 10, 0, 7, 100,
                                    105, 115, 112, 108, 97, 121, 8, 0, 4, 78, 97, 109, 101, 0, 13, 51, 97,
                                    114, 116, 104, 39, 115, 32, 66, 48, 111, 116, 115, 0, 0, 2, 0, 6, 68, 97,
                                    109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 13, 8, 0, 2, 105,
                                    100, 0, 21, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 101, 110, 100,
                                    95, 99, 114, 121, 115, 116, 97, 108, 1, 0, 5, 67, 111, 117, 110, 116, 64,
                                    2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116,
                                    14, 8, 0, 2, 105, 100, 0, 21, 109, 105, 110, 101, 99, 114, 97, 102, 116,
                                    58, 101, 110, 100, 95, 99, 114, 121, 115, 116, 97, 108, 1, 0, 5, 67, 111,
                                    117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4,
                                    83, 108, 111, 116, 15, 8, 0, 2, 105, 100, 0, 21, 109, 105, 110, 101, 99,
                                    114, 97, 102, 116, 58, 101, 110, 100, 95, 99, 114, 121, 115, 116, 97, 108,
                                    1, 0, 5, 67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97, 103, 101,
                                    0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 16, 8, 0, 2, 105, 100, 0, 21, 109,
                                    105, 110, 101, 99, 114, 97, 102, 116, 58, 101, 110, 100, 95, 99, 114, 121,
                                    115, 116, 97, 108, 1, 0, 5, 67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97,
                                    109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 17, 8, 0, 2, 105,
                                    100, 0, 21, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 101, 110, 100,
                                    95, 99, 114, 121, 115, 116, 97, 108, 1, 0, 5, 67, 111, 117, 110, 116, 64,
                                    2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116,
                                    18, 8, 0, 2, 105, 100, 0, 26, 109, 105, 110, 101, 99, 114, 97, 102, 116,
                                    58, 116, 111, 116, 101, 109, 95, 111, 102, 95, 117, 110, 100, 121, 105,
                                    110, 103, 1, 0, 5, 67, 111, 117, 110, 116, 1, 2, 0, 6, 68, 97, 109, 97,
                                    103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 19, 8, 0, 2, 105, 100, 0,
                                    26, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 116, 111, 116, 101,
                                    109, 95, 111, 102, 95, 117, 110, 100, 121, 105, 110, 103, 1, 0, 5, 67,
                                    111, 117, 110, 116, 1, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1,
                                    0, 4, 83, 108, 111, 116, 20, 8, 0, 2, 105, 100, 0, 26, 109, 105, 110, 101,
                                    99, 114, 97, 102, 116, 58, 116, 111, 116, 101, 109, 95, 111, 102, 95, 117,
                                    110, 100, 121, 105, 110, 103, 1, 0, 5, 67, 111, 117, 110, 116, 1, 2, 0,
                                    6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 21,
                                    8, 0, 2, 105, 100, 0, 26, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58,
                                    116, 111, 116, 101, 109, 95, 111, 102, 95, 117, 110, 100, 121, 105, 110,
                                    103, 1, 0, 5, 67, 111, 117, 110, 116, 1, 2, 0, 6, 68, 97, 109, 97, 103,
                                    101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 22, 8, 0, 2, 105, 100, 0, 27,
                                    109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 101, 120, 112, 101, 114,
                                    105, 101, 110, 99, 101, 95, 98, 111, 116, 116, 108, 101, 1, 0, 5, 67, 111,
                                    117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4,
                                    83, 108, 111, 116, 23, 8, 0, 2, 105, 100, 0, 27, 109, 105, 110, 101, 99,
                                    114, 97, 102, 116, 58, 101, 120, 112, 101, 114, 105, 101, 110, 99, 101,
                                    95, 98, 111, 116, 116, 108, 101, 1, 0, 5, 67, 111, 117, 110, 116, 64, 2,
                                    0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 24,
                                    8, 0, 2, 105, 100, 0, 27, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58,
                                    101, 120, 112, 101, 114, 105, 101, 110, 99, 101, 95, 98, 111, 116, 116,
                                    108, 101, 1, 0, 5, 67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97,
                                    103, 101, 0, 0, 0, 1, 0, 4, 83, 108, 111, 116, 25, 8, 0, 2, 105, 100, 0,
                                    27, 109, 105, 110, 101, 99, 114, 97, 102, 116, 58, 101, 120, 112, 101,
                                    114, 105, 101, 110, 99, 101, 95, 98, 111, 116, 116, 108, 101, 1, 0, 5,
                                    67, 111, 117, 110, 116, 64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0,
                                    1, 0, 4, 83, 108, 111, 116, 26, 8, 0, 2, 105, 100, 0, 27, 109, 105, 110,
                                    101, 99, 114, 97, 102, 116, 58, 101, 120, 112, 101, 114, 105, 101, 110,
                                    99, 101, 95, 98, 111, 116, 116, 108, 101, 1, 0, 5, 67, 111, 117, 110, 116,
                                    64, 2, 0, 6, 68, 97, 109, 97, 103, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                                    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                            }
                    //</editor-fold> //
            ));

            stack = buffer.readItemStack();
        }
        catch (Exception e)
        {
            stack = new ItemStack(Blocks.RED_SHULKER_BOX);
            stack.setStackDisplayName(TextColor.RED + "ERROR");
            e.printStackTrace();
        }
        finally
        {
            if (buffer != null)
            {
                BufferUtil.releaseBuffer(buffer);
            }
        }

        KIT = stack;
    }

    public KitCommand()
    {
        super("kit", "kit");
        CommandDescriptions.register(this, "Gives you a kit.");
    }

    @Override
    protected ItemStack getStack(String[] args)
    {
        return KIT.copy();
    }

}
 */