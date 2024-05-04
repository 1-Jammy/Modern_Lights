package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.LuminousSlabBlock;
import com.jammy1.modernlights.custom.shapes.LuminousVerticalSlabBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousVerticalSlabs {


    // Map to store vertical slabs of different colors
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_VERTICAL_SLABS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_VERTICAL_SLABS_FULL = new HashMap<>();

    // Default block settings
    private static final FabricBlockSettings DEFAULT_SETTINGS = Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousSlabBlock.LIT, 15, false);

    static {
        // Initialize luminous slabs for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_vertical_slab" : "luminous_vertical_slab_" + color.name().toLowerCase();

            LUMINOUS_VERTICAL_SLABS.put(color, createLuminousSlab(blockName, false));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_vertical_slab_full" : "luminous_vertical_slab_" + color.name().toLowerCase() + "_full";

            LUMINOUS_VERTICAL_SLABS_FULL.put(color, createLuminousSlab(blockName, true));
        }
    }

    // Method to create luminous slab block
    private static Block createLuminousSlab(String name, boolean isFull) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new LuminousVerticalSlabBlock(DEFAULT_SETTINGS));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getLuminousVerticalSlab(modernLights.LuminousColors color) {
        return LUMINOUS_VERTICAL_SLABS.get(color);
    }

    public static Block getLuminousVerticalSlabFull(modernLights.LuminousColors color) {
        return LUMINOUS_VERTICAL_SLABS_FULL.get(color);
    }

    public static void registerBlocks() {

    }
}

