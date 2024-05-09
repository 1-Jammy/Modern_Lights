package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.AndesiteFrame;
import com.jammy1.modernlights.custom.shapes.LuminousBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_ANDESITE_FRAME_SETTINGS;
import static com.jammy1.modernlights.util.DefaultBlockSettings.defaultLuminousBlockSettings;

public class LuminousBlocks {

    public static final Block ANDESITE_FRAME = Util.registerBlocks("andesite_frame", new AndesiteFrame(DEFAULT_ANDESITE_FRAME_SETTINGS));

    // Map to store mini_blocks of different colors
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_BLOCKS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_FULL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous blocks for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous blocks and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block" : "luminous_block_" + color.name().toLowerCase();

            LUMINOUS_BLOCKS.put(color, createLuminousBlock(blockName, false, color));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous blocks full and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block_full" : "luminous_block_" + color.name().toLowerCase() + "_full";

            LUMINOUS_FULL_BLOCKS.put(color, createLuminousBlock(blockName, true, color));
        }
    }

    // Method to create mini_blocks
    private static Block createLuminousBlock(String name, boolean isFull, modernLights.LuminousColors color) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new LuminousBlock(defaultLuminousBlockSettings(color)));
    }

    public static Block getLuminousBLock(modernLights.LuminousColors color) {
        return LUMINOUS_BLOCKS.get(color);
    }

    public static Block getLuminousBLockFull(modernLights.LuminousColors color) {
        return LUMINOUS_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}
