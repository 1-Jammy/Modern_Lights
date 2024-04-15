package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.LuminousSlabBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousSlabs {

    public static final Map<modernLights.LuminousColor, Block> LUMINOUS_SLABS = new HashMap<>(); //Create all the color variants

    static {
        final Block LUMINOUS_SLAB = LuminousSlab("luminous_slab");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "luminous_slab_" + color.name().toLowerCase(); // Dynamically build block name
            LUMINOUS_SLABS.put(color, LuminousSlab(blockName)); // Create basic block
        }

        final Block LUMINOUS_SLAB_FULL = LuminousSlabFull("luminous_slab_full");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "luminous_slab_" + color.name().toLowerCase() + "_full"; // Dynamically build block name
            LUMINOUS_SLABS.put(color, LuminousSlabFull(blockName)); // Create full info block
        }
    }

    private static FabricBlockSettings DefaultSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f,LuminousSlabBlock.LIT, 15, false);
    }

    // Luminous Slab
    public static Block LuminousSlab(String name) {
        return Util.registerBlocks(name,
                new LuminousSlabBlock(DefaultSettings()));
    }

    // Luminous Slab Full
    public static Block LuminousSlabFull(String name) {
        return Util.registerBlocks(name, modernLights.fullInfo,
                new LuminousSlabBlock(DefaultSettings()));
    }

    public static void registerBlocks() {

    }
}
