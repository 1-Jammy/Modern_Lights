package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.PanelBlock;
import com.jammy1.modernlights.custom.shapes.PanelSmallBlock;
import com.jammy1.modernlights.modernLights.LuminousColors;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousPanels {

    // Map to store panels and panel_small of different colors
    public static final Map<LuminousColors, Block> PANEL_BLOCKS = new HashMap<>();
    public static final Map<LuminousColors, Block> SMALL_PANEL_BLOCKS = new HashMap<>();
    private static final FabricBlockSettings DEFAULT_SMALL_PANEL_SETTINGS = Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelSmallBlock.LIT, 12, true, null);

    static {
        // Initialize luminous slabs for each color
        for (LuminousColors color : LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "panel" : "panel_" + color.name().toLowerCase();

            PANEL_BLOCKS.put(color, createPanel(blockName, false, color));
        }

        for (LuminousColors color : LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "panel_small" : "panel_small_" + color.name().toLowerCase();

            SMALL_PANEL_BLOCKS.put(color, createPanel(blockName, true, color));
        }
    }

    // Method to create panels
    private static Block createPanel(String name, boolean isSmall, LuminousColors color) {
        return Util.registerBlocks(name, isSmall ? new PanelSmallBlock(DEFAULT_SMALL_PANEL_SETTINGS) :
                new PanelBlock(Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 14, true, color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getPanelBLock(LuminousColors color) {
        return PANEL_BLOCKS.get(color);
    }

    public static Block getSmallPanelBLock(LuminousColors color) {
        return SMALL_PANEL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}

