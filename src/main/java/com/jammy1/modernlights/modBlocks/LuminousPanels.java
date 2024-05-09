package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.PanelBlock;
import com.jammy1.modernlights.custom.shapes.PanelSmallBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.DefaultBlockSettings;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_SMALL_PANEL_SETTINGS;

public class LuminousPanels {

    // Map to store panels and panel_small of different colors
    public static final Map<modernLights.LuminousColors, Block> PANEL_BLOCKS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> SMALL_PANEL_BLOCKS = new HashMap<>();

    static {
        // Initialize luminous slabs for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create basic luminous slab and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "panel" : "panel_" + color.name().toLowerCase();

            PANEL_BLOCKS.put(color, createPanel(blockName, false, color));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create full luminous slab and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "panel_small" : "panel_small_" + color.name().toLowerCase();

            SMALL_PANEL_BLOCKS.put(color, createPanel(blockName, true, color));
        }
    }

    // Method to create panels
    private static Block createPanel(String name, boolean isSmall, modernLights.LuminousColors color) {
        return Util.registerBlocks(name, isSmall ? new PanelSmallBlock(DEFAULT_SMALL_PANEL_SETTINGS) : new PanelBlock(DefaultBlockSettings.defaultPanelSettings(color)));
    }

    // Access Mini Luminous Blocks [just in case]
    public static Block getPanelBLock(modernLights.LuminousColors color) {
        return PANEL_BLOCKS.get(color);
    }

    public static Block getSmallPanelBLock(modernLights.LuminousColors color) {
        return SMALL_PANEL_BLOCKS.get(color);
    }

    public static void registerBlocks() {

    }
}

