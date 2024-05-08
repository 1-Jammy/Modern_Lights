package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.AndesiteFrame;
import com.jammy1.modernlights.custom.shapes.LuminousBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.modernLights.LuminousColors;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.defaultAndesiteFrameSetting;
import static com.jammy1.modernlights.util.DefaultBlockSettings.defaultLuminousBlockSetting;

public class LuminousBlocks {

    public static final Block ANDESITE_FRAME = Util.registerBlocks("andesite_frame", new AndesiteFrame(defaultAndesiteFrameSetting()));

    // Map to store mini_blocks of different colors
    public static final Map<LuminousColors, Block> LUMINOUS_BLOCKS = new HashMap<>();
    public static final Map<LuminousColors, Block> LUMINOUS_FULL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous blocks for each color
        for (LuminousColors color : LuminousColors.values()) {
            // Create basic luminous blocks and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block" : "luminous_block_" + color.name().toLowerCase();

            LUMINOUS_BLOCKS.put(color, createLuminousBlock(blockName, false, color));
        }

        for (LuminousColors color : LuminousColors.values()) {
            // Create full luminous blocks full and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block_full" : "luminous_block_" + color.name().toLowerCase() + "_full";

            LUMINOUS_FULL_BLOCKS.put(color, createLuminousBlock(blockName, true, color));
        }
    }

    // Method to create mini_blocks
    private static Block createLuminousBlock(String name, boolean isFull, LuminousColors color) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new LuminousBlock(defaultLuminousBlockSetting(color)));
    }

    public static Block getLuminousBLock(LuminousColors color) {
        return LUMINOUS_BLOCKS.get(color);
    }

    public static Block getLuminousBLockFull(LuminousColors color) {
        return LUMINOUS_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}
