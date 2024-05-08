package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.MiniBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_MINI_BLOCK_SETTING;

public class LuminousMiniBlocks {
    // Map to store mini_blocks of different colors
    public static final Map<modernLights.LuminousColors, Block> MINI_BLOCKS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> MINI_FULL_BLOCKS = new HashMap<>();

    // Default block settings


    static {
        // Initialize luminous slabs for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block" : "mini_luminous_block_" + color.name().toLowerCase();

            MINI_BLOCKS.put(color, createMiniBlock(blockName, false));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block_full" : "mini_luminous_block_" + color.name().toLowerCase() + "_full";

            MINI_FULL_BLOCKS.put(color, createMiniBlock(blockName, true));
        }
    }

    // Method to create mini_blocks
    private static Block createMiniBlock(String name, boolean isFull) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new MiniBlock(DEFAULT_MINI_BLOCK_SETTING));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getMiniBLock(modernLights.LuminousColors color) {
        return MINI_BLOCKS.get(color);
    }

    public static Block getMiniBlockFull(modernLights.LuminousColors color) {
        return MINI_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}
