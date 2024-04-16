package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.MiniBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousMiniBlocks {
    public static final Map<modernLights.LuminousColor, Block> MINI_LUMINOUS_BLOCKS = new HashMap<>(); //Create all the color variants

    static {
        final Block MINI_LUMINOUS_BLOCK = MiniBlock("mini_luminous_block");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "mini_luminous_block_" + color.name().toLowerCase(); // Dynamically build block name
            MINI_LUMINOUS_BLOCKS.put(color, MiniBlock(blockName)); // Create basic block
        }

        final Block MINI_LUMINOUS_BLOCK_FULL = MiniBlockFull("mini_luminous_block_full");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "mini_luminous_block_" + color.name().toLowerCase() + "_full";
            MINI_LUMINOUS_BLOCKS.put(color, MiniBlockFull(blockName));
        }
    }

    private static AbstractBlock.Settings DefaultSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniBlock.LIT, 11, true);
    }

    // Mini Block
    public static Block MiniBlock(String name) {
        return Util.registerBlocks(name, new MiniBlock(DefaultSettings()));
    }

    // Mini Block Full
    public static Block MiniBlockFull(String name) {
        return Util.registerBlocks(name, modernLights.fullInfo, new MiniBlock(DefaultSettings()));
    }

    public static void registerBlocks() {

    }
}
