package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.AndesiteFrame;
import com.jammy1.modernlights.custom.shapes.LuminousBlock;
import com.jammy1.modernlights.custom.shapes.LuminousVerticalSlabBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.HashMap;
import java.util.Map;

public class LuminousBlocks {
/*
    public static final Block ANDESITE_FRAME = Util.registerBlocks("andesite_frame", DefaultAndesiteFrameSettings());
    public static final Block LUMINOUS_BLOCK = LuminousBlock("luminous_block");
    private static final Map<modernLights.LuminousColors, Block> LUMINOUS_BLOCKS = new HashMap<>();

    static {
        // Initialize regular luminous blocks
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            String blockName = "luminous_block_" + color.name().toLowerCase();
            LUMINOUS_BLOCKS.put(color, LuminousBlock(blockName));
        }

        // Initialize full info luminous blocks
        final Block LUMINOUS_BLOCK_FULL = LuminousBlockFull("luminous_block_full");
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            String blockName = "luminous_block_" + color.name().toLowerCase() + "_full";
            LUMINOUS_BLOCKS.put(color, LuminousBlockFull(blockName));
        }
    }

    private static FabricBlockSettings DefaultSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousBlock.LIT, 15, false);
    }

    private static Block DefaultAndesiteFrameSettings() {
        return new AndesiteFrame(
                FabricBlockSettings
                        .create()
                        .pistonBehavior(PistonBehavior.NORMAL)
                        .sounds(BlockSoundGroup.METAL)
                        .strength(5.0F, 5.0F));
    }

    // Luminous Block
    private static Block LuminousBlock(String name) {
        return Util.registerBlocks(name, new LuminousBlock(DefaultSettings()));
    }

    // Luminous Block W/ Tooltip
    private static Block LuminousBlockFull(String name) {
        return Util.registerBlocks(name, modernLights.fullInfo, new LuminousBlock(DefaultSettings()));
    }

    // Access luminous blocks by color [just in case]
    public static Block getLuminousBlock(modernLights.LuminousColors color) {
        return LUMINOUS_BLOCKS.get(color);
    }

    */


    public static final Block ANDESITE_FRAME = Util.registerBlocks("andesite_frame", DefaultAndesiteFrameSettings());
    public static final Block VERTICAL_SLAB = Util.registerBlocks("vertical_slab", TEST());
    // Map to store mini_blocks of different colors
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_BLOCKS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> LUMINOUS_FULL_BLOCKS = new HashMap<>();
    // Default block settings
    private static final FabricBlockSettings DEFAULT_SETTINGS = Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousBlock.LIT, 15, false);

    static {
        // Initialize luminous blocks for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous blocks and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block" : "luminous_block_" + color.name().toLowerCase();

            LUMINOUS_BLOCKS.put(color, createLuminousBlock(blockName, false));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous blocks full and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "luminous_block_full" : "luminous_block_" + color.name().toLowerCase() + "_full";

            LUMINOUS_FULL_BLOCKS.put(color, createLuminousBlock(blockName, true));
        }
    }

    private static Block DefaultAndesiteFrameSettings() {
        return new AndesiteFrame(
                FabricBlockSettings
                        .create()
                        .pistonBehavior(PistonBehavior.NORMAL)
                        .sounds(BlockSoundGroup.METAL)
                        .strength(5.0F, 5.0F));
    }
    private static Block TEST() {
        return new LuminousVerticalSlabBlock(
                FabricBlockSettings
                        .create()
                        .pistonBehavior(PistonBehavior.NORMAL)
                        .sounds(BlockSoundGroup.METAL)
                        .nonOpaque()
                        .luminance((state) -> state.get(LuminousVerticalSlabBlock.LIT) ? 15 : 0)
                        .strength(5.0F, 5.0F));
    }

    // Method to create mini_blocks
    private static Block createLuminousBlock(String name, boolean isFull) {
        return Util.registerBlocks(name, isFull ? modernLights.fullInfo : null, new LuminousBlock(DEFAULT_SETTINGS));
    }

    public static Block getLuminousBLock(modernLights.LuminousColors color) {
        return LUMINOUS_BLOCKS.get(color);
    }

    public static Block getLuminousFullBLock(modernLights.LuminousColors color) {
        return LUMINOUS_FULL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}
