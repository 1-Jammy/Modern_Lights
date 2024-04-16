package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.PanelBlock;
import com.jammy1.modernlights.custom.shapes.PanelSmallBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousPanels {

    public static final Map<modernLights.LuminousColor, Block> PANEL_BLOCKS = new HashMap<>(); //Create all the color variants

    static {
        final Block PANEL = Panel("panel"); // Create the basic block

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "panel_" + color.name().toLowerCase(); // Dynamically build block name
            PANEL_BLOCKS.put(color, Panel(blockName)); // Create block with respective color
        }

        final Block PANEL_SMALL = PanelSmall("panel_small"); // Create the basic block

        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "panel_small_" + color.name().toLowerCase(); // Dynamically build block name
            PANEL_BLOCKS.put(color, PanelSmall(blockName)); // Create block with respective color
        }
    }

    private static FabricBlockSettings DefaultPanelSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 15, false);
    }

    private static FabricBlockSettings DefaultPanelSmallSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 11, false);
    }

    // Panel
    public static Block Panel(String name) {
        return Util.registerBlocks(name, new PanelBlock(DefaultPanelSettings()));
    }

    // Small Panel
    public static Block PanelSmall(String name) {
        return Util.registerBlocks(name, new PanelSmallBlock(DefaultPanelSmallSettings()));
    }


    public static void registerBlocks() {

    }
}
