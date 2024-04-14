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

    /*  // Access luminous blocks by color [just in case]
    public static Block getLuminousBlock(modernLights.LuminousColor color) {
        return LUMINOUS_SLABS.get(color);
    }*/

    /*
    private static final String X = "full.info";
    private static final String A = "luminous_slab";


    public static final Block LUMINOUS_SLAB_ORANGE     = Make.LuminousSlab(A + "_orange");
    public static final Block LUMINOUS_SLAB_MAGENTA    = Make.LuminousSlab(A + "_magenta");
    public static final Block LUMINOUS_SLAB_LIGHT_BLUE = Make.LuminousSlab(A + "_light_blue");
    public static final Block LUMINOUS_SLAB_YELLOW     = Make.LuminousSlab(A + "_yellow");
    public static final Block LUMINOUS_SLAB_LIME       = Make.LuminousSlab(A + "_lime");
    public static final Block LUMINOUS_SLAB_PINK       = Make.LuminousSlab(A + "_pink");
    public static final Block LUMINOUS_SLAB_GRAY       = Make.LuminousSlab(A + "_gray");
    public static final Block LUMINOUS_SLAB_LIGHT_GRAY = Make.LuminousSlab(A + "_light_gray");
    public static final Block LUMINOUS_SLAB_CYAN       = Make.LuminousSlab(A + "_cyan");
    public static final Block LUMINOUS_SLAB_PURPLE     = Make.LuminousSlab(A + "_purple");
    public static final Block LUMINOUS_SLAB_BLUE       = Make.LuminousSlab(A + "_blue");
    public static final Block LUMINOUS_SLAB_BROWN      = Make.LuminousSlab(A + "_brown");
    public static final Block LUMINOUS_SLAB_GREEN      = Make.LuminousSlab(A + "_green");
    public static final Block LUMINOUS_SLAB_RED        = Make.LuminousSlab(A + "_red");
    public static final Block LUMINOUS_SLAB_BLACK      = Make.LuminousSlab(A + "_black");

    public static final Block LUMINOUS_SLAB_FULL            = Make.LuminousSlab(X, A + "_full");
    public static final Block LUMINOUS_SLAB_ORANGE_FULL     = Make.LuminousSlab(X, A + "_orange_full");
    public static final Block LUMINOUS_SLAB_MAGENTA_FULL    = Make.LuminousSlab(X, A + "_magenta_full");
    public static final Block LUMINOUS_SLAB_LIGHT_BLUE_FULL = Make.LuminousSlab(X, A + "_light_blue_full");
    public static final Block LUMINOUS_SLAB_YELLOW_FULL     = Make.LuminousSlab(X, A + "_yellow_full");
    public static final Block LUMINOUS_SLAB_LIME_FULL       = Make.LuminousSlab(X, A + "_lime_full");
    public static final Block LUMINOUS_SLAB_PINK_FULL       = Make.LuminousSlab(X, A + "_pink_full");
    public static final Block LUMINOUS_SLAB_GRAY_FULL       = Make.LuminousSlab(X, A + "_gray_full");
    public static final Block LUMINOUS_SLAB_LIGHT_GRAY_FULL = Make.LuminousSlab(X, A + "_light_gray_full");
    public static final Block LUMINOUS_SLAB_CYAN_FULL       = Make.LuminousSlab(X, A + "_cyan_full");
    public static final Block LUMINOUS_SLAB_PURPLE_FULL     = Make.LuminousSlab(X, A + "_purple_full");
    public static final Block LUMINOUS_SLAB_BLUE_FULL       = Make.LuminousSlab(X, A + "_blue_full");
    public static final Block LUMINOUS_SLAB_BROWN_FULL      = Make.LuminousSlab(X, A + "_brown_full");
    public static final Block LUMINOUS_SLAB_GREEN_FULL      = Make.LuminousSlab(X, A + "_green_full");
    public static final Block LUMINOUS_SLAB_RED_FULL        = Make.LuminousSlab(X, A + "_red_full");
    public static final Block LUMINOUS_SLAB_BLACK_FULL      = Make.LuminousSlab(X, A + "_black_full");
*/ //old code
    public static void registerBlocks() {

    }
}
