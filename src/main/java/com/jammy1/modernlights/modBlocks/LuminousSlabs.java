package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.LuminousSlabBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.DefaultBlockSettings;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousSlabs {

    // Map to store luminous slabs of different colors
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_SLABS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_SLABS_FULL = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_slab" : "luminous_slab_" + color.name().toLowerCase();

            LUMINOUS_SLABS.put(color, createLuminousSlab(blockName, false, color));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_slab_full" : "luminous_slab_" + color.name().toLowerCase() + "_full";

            LUMINOUS_SLABS_FULL.put(color, createLuminousSlab(blockName, true, color));
        }
    }

    // Method to create luminous slab block
    private static Block createLuminousSlab(String name, boolean isFull, modernLights.LuminousColors color) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new LuminousSlabBlock(DefaultBlockSettings.defaultLuminousSlabSettings(color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getLuminousSlab(modernLights.LuminousColors color) {
        return LUMINOUS_SLABS.get(color);
    }

    public static Block getLuminousSlabFull(modernLights.LuminousColors color) {
        return LUMINOUS_SLABS_FULL.get(color);
    }

    public static void registerBlocks() {

    }
}

