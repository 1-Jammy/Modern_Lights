package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.MiniBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.modernLights.LuminousColors;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_MINI_BLOCK_SETTINGS;

public class LuminousMiniBlocks {
    // Map to store mini_blocks of different colors
    public static final Map<LuminousColors, Block> MINI_BLOCKS = new HashMap<>();
    public static final Map<LuminousColors, Block> MINI_BLOCKS_FULL = new HashMap<>();


    static {
        // Initialize luminous slabs for each color
        for (LuminousColors color : LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block" : "mini_luminous_block_" + color.name().toLowerCase();

            MINI_BLOCKS.put(color, createMiniBlock(blockName, false));
        }

        for (LuminousColors color : LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_luminous_block_full" : "mini_luminous_block_" + color.name().toLowerCase() + "_full";

            MINI_BLOCKS_FULL.put(color, createMiniBlock(blockName, true));
        }
    }

    // Method to create mini_blocks
    private static Block createMiniBlock(String name, boolean isFull) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new MiniBlock(DEFAULT_MINI_BLOCK_SETTINGS));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getMiniBLock(LuminousColors color) {
        return MINI_BLOCKS.get(color);
    }

    public static Block getMiniBlockFull(LuminousColors color) {
        return MINI_BLOCKS_FULL.get(color);
    }

    public static void registerBlocks() {

    }
}
