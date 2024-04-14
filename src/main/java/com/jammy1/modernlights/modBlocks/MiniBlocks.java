package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.MiniBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class MiniBlocks {

    /*
                private static final String X = "full.info";
                private static final String A = "mini_luminous_block";


                 public static final Block MINI_LUMINOUS_BLOCK_ORANGE       = Make.MiniBlock(A + "_orange");
                 public static final Block MINI_LUMINOUS_BLOCK_MAGENTA      = Make.MiniBlock(A + "_magenta");
                 public static final Block MINI_LUMINOUS_BLOCK_LIGHT_BLUE   = Make.MiniBlock(A + "_light_blue");
                 public static final Block MINI_LUMINOUS_BLOCK_YELLOW       = Make.MiniBlock(A + "_yellow");
                 public static final Block MINI_LUMINOUS_BLOCK_LIME         = Make.MiniBlock(A + "_lime");
                 public static final Block MINI_LUMINOUS_BLOCK_PINK         = Make.MiniBlock(A + "_pink");
                 public static final Block MINI_LUMINOUS_BLOCK_GRAY         = Make.MiniBlock(A + "_gray");
                 public static final Block MINI_LUMINOUS_BLOCK_LIGHT_GRAY   = Make.MiniBlock(A + "_light_gray");
                 public static final Block MINI_LUMINOUS_BLOCK_CYAN         = Make.MiniBlock(A + "_cyan");
                 public static final Block MINI_LUMINOUS_BLOCK_PURPLE       = Make.MiniBlock(A + "_purple");
                 public static final Block MINI_LUMINOUS_BLOCK_BLUE         = Make.MiniBlock(A + "_blue");
                 public static final Block MINI_LUMINOUS_BLOCK_BROWN        = Make.MiniBlock(A + "_brown");
                 public static final Block MINI_LUMINOUS_BLOCK_GREEN        = Make.MiniBlock(A + "_green");
                 public static final Block MINI_LUMINOUS_BLOCK_RED          = Make.MiniBlock(A + "_red");
                 public static final Block MINI_LUMINOUS_BLOCK_BLACK        = Make.MiniBlock(A + "_black");


                 public static final Block MINI_LUMINOUS_BLOCK_ORANGE_FULL        = Make.MiniBlock(X, A + "_orange_full");
                 public static final Block MINI_LUMINOUS_BLOCK_MAGENTA_FULL       = Make.MiniBlock(X, A + "_magenta_full");
                 public static final Block MINI_LUMINOUS_BLOCK_LIGHT_BLUE_FULL    = Make.MiniBlock(X, A + "_light_blue_full");
                 public static final Block MINI_LUMINOUS_BLOCK_YELLOW_FULL        = Make.MiniBlock(X, A + "_yellow_full");
                 public static final Block MINI_LUMINOUS_BLOCK_LIME_FULL          = Make.MiniBlock(X, A + "_lime_full");
                 public static final Block MINI_LUMINOUS_BLOCK_PINK_FULL          = Make.MiniBlock(X, A + "_pink_full");
                 public static final Block MINI_LUMINOUS_BLOCK_GRAY_FULL          = Make.MiniBlock(X, A + "_gray_full");
                 public static final Block MINI_LUMINOUS_BLOCK_LIGHT_GRAY_FULL    = Make.MiniBlock(X, A + "_light_gray_full");
                 public static final Block MINI_LUMINOUS_BLOCK_CYAN_FULL          = Make.MiniBlock(X, A + "_cyan_full");
                 public static final Block MINI_LUMINOUS_BLOCK_PURPLE_FULL        = Make.MiniBlock(X, A + "_purple_full");
                 public static final Block MINI_LUMINOUS_BLOCK_BLUE_FULL          = Make.MiniBlock(X, A + "_blue_full");
                 public static final Block MINI_LUMINOUS_BLOCK_BROWN_FULL         = Make.MiniBlock(X, A + "_brown_full");
                 public static final Block MINI_LUMINOUS_BLOCK_GREEN_FULL         = Make.MiniBlock(X, A + "_green_full");
                 public static final Block MINI_LUMINOUS_BLOCK_RED_FULL           = Make.MiniBlock(X, A + "_red_full");
                 public static final Block MINI_LUMINOUS_BLOCK_BLACK_FULL         = Make.MiniBlock(X, A + "_black_full");*/


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

    /*        // Access luminous blocks by color [just in case]
        public static Block getLuminousBlock(modernLights.LuminousColor color) {
                return MINI_LUMINOUS_BLOCKS.get(color);
        }*/

    public static void registerBlocks() {

    }
}
