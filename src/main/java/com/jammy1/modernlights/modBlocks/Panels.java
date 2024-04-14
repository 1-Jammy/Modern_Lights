package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.PanelBlock;
import com.jammy1.modernlights.custom.shapes.PanelSmallBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class Panels {

    public static final Map<modernLights.LuminousColor, Block> PANEL_BLOCKS = new HashMap<>(); //Create all the color variants

    static {
        final Block PANEL = Panel("panel");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "panel_" + color.name().toLowerCase(); // Dynamically build block name
            PANEL_BLOCKS.put(color, Panel(blockName)); // Create basic block
        }

        final Block PANEL_SMALL = PanelSmall("panel_small");

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "panel_small_" + color.name().toLowerCase(); // Dynamically build block name
            PANEL_BLOCKS.put(color, PanelSmall(blockName)); // Create basic block
        }
    }

    /*

    private static final String A = "panel";

    public static final Block PANEL               = Make.Panel(A);
    public static final Block PANEL_ORANGE        = Make.Panel(A + "_orange");
    public static final Block PANEL_MAGENTA       = Make.Panel(A + "_magenta");
    public static final Block PANEL_LIGHT_BLUE    = Make.Panel(A + "_light_blue");
    public static final Block PANEL_YELLOW        = Make.Panel(A + "_yellow");
    public static final Block PANEL_LIME          = Make.Panel(A + "_lime");
    public static final Block PANEL_PINK          = Make.Panel(A + "_pink");
    public static final Block PANEL_GRAY          = Make.Panel(A + "_gray");
    public static final Block PANEL_LIGHT_GRAY    = Make.Panel(A + "_light_gray");
    public static final Block PANEL_CYAN          = Make.Panel(A + "_cyan");
    public static final Block PANEL_PURPLE        = Make.Panel(A + "_purple");
    public static final Block PANEL_BLUE          = Make.Panel(A + "_blue");
    public static final Block PANEL_BROWN         = Make.Panel(A + "_brown");
    public static final Block PANEL_GREEN         = Make.Panel(A + "_green");
    public static final Block PANEL_RED           = Make.Panel(A + "_red");
    public static final Block PANEL_BLACK         = Make.Panel(A + "_black");

    public static final Block PANEL_SMALL               = Make.PanelSmall(A + "_small");
    public static final Block PANEL_SMALL_ORANGE        = Make.PanelSmall(A + "_small_orange");
    public static final Block PANEL_SMALL_MAGENTA       = Make.PanelSmall(A + "_small_magenta");
    public static final Block PANEL_SMALL_LIGHT_BLUE    = Make.PanelSmall(A + "_small_light_blue");
    public static final Block PANEL_SMALL_YELLOW        = Make.PanelSmall(A + "_small_yellow");
    public static final Block PANEL_SMALL_LIME          = Make.PanelSmall(A + "_small_lime");
    public static final Block PANEL_SMALL_PINK          = Make.PanelSmall(A + "_small_pink");
    public static final Block PANEL_SMALL_GRAY          = Make.PanelSmall(A + "_small_gray");
    public static final Block PANEL_SMALL_LIGHT_GRAY    = Make.PanelSmall(A + "_small_light_gray");
    public static final Block PANEL_SMALL_CYAN          = Make.PanelSmall(A + "_small_cyan");
    public static final Block PANEL_SMALL_PURPLE        = Make.PanelSmall(A + "_small_purple");
    public static final Block PANEL_SMALL_BLUE          = Make.PanelSmall(A + "_small_blue");
    public static final Block PANEL_SMALL_BROWN         = Make.PanelSmall(A + "_small_brown");
    public static final Block PANEL_SMALL_GREEN         = Make.PanelSmall(A + "_small_green");
    public static final Block PANEL_SMALL_RED           = Make.PanelSmall(A + "_small_red");
    public static final Block PANEL_SMALL_BLACK         = Make.PanelSmall(A + "_small_black");
    */ //old code
    private static FabricBlockSettings DefaultPanelSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 15, false);
    }

    private static FabricBlockSettings DefaultPanelSmallSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 11, false);
    }

    // Panel
    public static Block Panel(String name) {
        return Util.registerBlocks(name,
                new PanelBlock(DefaultPanelSettings()));
    }

    // Small Panel
    public static Block PanelSmall(String name) {
        return Util.registerBlocks(name,
                new PanelSmallBlock(DefaultPanelSmallSettings()));
    }
/*
        // Access luminous blocks by color [just in case]
        public static Block getLuminousBlock(modernLights.LuminousColor color) {
                return PANEL_BLOCKS.get(color);
        }*/


    public static void registerBlocks() {

    }
}
