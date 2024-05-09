package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.CeilingLightBlock;
import com.jammy1.modernlights.custom.shapes.MiniLightBlock;
import com.jammy1.modernlights.modernLights.LuminousColors;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_CEILING_LIGHT_SETTINGS;
import static com.jammy1.modernlights.util.DefaultBlockSettings.DEFAULT_MINI_LIGHT_SETTINGS;

public class LuminousLights {

    // Map to store mini_lights and ceiling_lights of different colors
    public static final Map<LuminousColors, Block> CEILING_LIGHTS = new HashMap<>();
    public static final Map<LuminousColors, Block> MINI_LIGHTS = new HashMap<>();

    static {
        // Initialize blocks for each color
        for (LuminousColors color : LuminousColors.values()) {
            // Create ceiling_light and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "ceiling_light" : "ceiling_light_" + color.name().toLowerCase();

            CEILING_LIGHTS.put(color, createBlock(blockName, false));
        }

        for (LuminousColors color : LuminousColors.values()) {
            // Create mini_light and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_light" : "mini_light_" + color.name().toLowerCase();

            MINI_LIGHTS.put(color, createBlock(blockName, true));
        }
    }

    // Method to create panels
    private static Block createBlock(String name, boolean isMiniLight) {
        return Util.registerBlocks(name, isMiniLight ? new MiniLightBlock(DEFAULT_MINI_LIGHT_SETTINGS) : new CeilingLightBlock(DEFAULT_CEILING_LIGHT_SETTINGS));
    }

    // Access Ceiling Lights and Mini Lights by color [just in case]
    public static Block getCeilingLightBLock(LuminousColors color) {
        return CEILING_LIGHTS.get(color);
    }

    public static Block getMiniLightBLock(LuminousColors color) {
        return MINI_LIGHTS.get(color);
    }

    public static void registerBlocks() {

    }
}
