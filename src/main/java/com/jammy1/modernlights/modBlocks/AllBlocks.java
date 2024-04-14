package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.AndesiteFrame;
import com.jammy1.modernlights.custom.shapes.LuminousBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.HashMap;
import java.util.Map;

public class AllBlocks {

/*        private static final String X = "full.info"; //can be changed in the lang file[provides tooltip for the block]
        private static final String A = "luminous_block";

  public static final Block ANDESITE_FRAME = Make.AndesiteFrame("andesite_frame");

        public static final Block LUMINOUS_BLOCK            = Make.LuminousBlock(A);
        public static final Block LUMINOUS_BLOCK_ORANGE     = Make.LuminousBlock(A + "_orange");
        public static final Block LUMINOUS_BLOCK_MAGENTA    = Make.LuminousBlock(A + "_magenta");
        public static final Block LUMINOUS_BLOCK_LIGHT_BLUE = Make.LuminousBlock(A + "_light_blue");
        public static final Block LUMINOUS_BLOCK_YELLOW     = Make.LuminousBlock(A + "_yellow");
        public static final Block LUMINOUS_BLOCK_LIME       = Make.LuminousBlock(A + "_lime");
        public static final Block LUMINOUS_BLOCK_PINK       = Make.LuminousBlock(A + "_pink");
        public static final Block LUMINOUS_BLOCK_GRAY       = Make.LuminousBlock(A + "_gray");
        public static final Block LUMINOUS_BLOCK_LIGHT_GRAY = Make.LuminousBlock(A + "_light_gray");
        public static final Block LUMINOUS_BLOCK_CYAN       = Make.LuminousBlock(A + "_cyan");
        public static final Block LUMINOUS_BLOCK_PURPLE     = Make.LuminousBlock(A + "_purple");
        public static final Block LUMINOUS_BLOCK_BLUE       = Make.LuminousBlock(A + "_blue");
        public static final Block LUMINOUS_BLOCK_BROWN      = Make.LuminousBlock(A + "_brown");
        public static final Block LUMINOUS_BLOCK_GREEN      = Make.LuminousBlock(A + "_green");
        public static final Block LUMINOUS_BLOCK_RED        = Make.LuminousBlock(A + "_red");
        public static final Block LUMINOUS_BLOCK_BLACK      = Make.LuminousBlock(A + "_black");

        public static final Block LUMINOUS_BLOCK_FULL            = Make.LuminousBlock(X, A + "_full");
        public static final Block LUMINOUS_BLOCK_ORANGE_FULL     = Make.LuminousBlock(X, A + "_orange_full");
        public static final Block LUMINOUS_BLOCK_MAGENTA_FULL    = Make.LuminousBlock(X, A + "_magenta_full");
        public static final Block LUMINOUS_BLOCK_LIGHT_BLUE_FULL = Make.LuminousBlock(X, A + "_light_blue_full");
        public static final Block LUMINOUS_BLOCK_YELLOW_FULL     = Make.LuminousBlock(X, A + "_yellow_full");
        public static final Block LUMINOUS_BLOCK_LIME_FULL       = Make.LuminousBlock(X, A + "_lime_full");
        public static final Block LUMINOUS_BLOCK_PINK_FULL       = Make.LuminousBlock(X, A + "_pink_full");
        public static final Block LUMINOUS_BLOCK_GRAY_FULL       = Make.LuminousBlock(X, A + "_gray_full");
        public static final Block LUMINOUS_BLOCK_LIGHT_GRAY_FULL = Make.LuminousBlock(X, A + "_light_gray_full");
        public static final Block LUMINOUS_BLOCK_CYAN_FULL       = Make.LuminousBlock(X, A + "_cyan_full");
        public static final Block LUMINOUS_BLOCK_PURPLE_FULL     = Make.LuminousBlock(X, A + "_purple_full");
        public static final Block LUMINOUS_BLOCK_BLUE_FULL       = Make.LuminousBlock(X, A + "_blue_full");
        public static final Block LUMINOUS_BLOCK_BROWN_FULL      = Make.LuminousBlock(X, A + "_brown_full");
        public static final Block LUMINOUS_BLOCK_GREEN_FULL      = Make.LuminousBlock(X, A + "_green_full");
        public static final Block LUMINOUS_BLOCK_RED_FULL        = Make.LuminousBlock(X, A + "_red_full");
        public static final Block LUMINOUS_BLOCK_BLACK_FULL      = Make.LuminousBlock(X, A + "_black_full");*/

    public static final Block ANDESITE_FRAME = Util.registerBlocks("andesite_frame", DefaultAndesiteFrameSettings());
    public static final Block LUMINOUS_BLOCK = LuminousBlock("luminous_block");
    private static final Map<modernLights.LuminousColor, Block> LUMINOUS_BLOCKS = new HashMap<>();

    static {
        // Initialize regular luminous blocks
        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "luminous_block_" + color.name().toLowerCase();
            LUMINOUS_BLOCKS.put(color, LuminousBlock(blockName));
        }

        // Initialize full info luminous blocks
        final Block LUMINOUS_BLOCK_FULL = LuminousBlockFull("luminous_block_full");
        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
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

    /*    // Access luminous blocks by color [just in case]
        public static Block getLuminousBlock(modernLights.LuminousColor color) {
            return LUMINOUS_BLOCKS.get(color);
        }
   */
    public static void registerBlocks() {

    }
}
