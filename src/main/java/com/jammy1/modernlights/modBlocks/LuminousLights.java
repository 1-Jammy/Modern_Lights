package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.CeilingLightBlock;
import com.jammy1.modernlights.custom.shapes.MiniLightBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LuminousLights {

    // Map to store mini_lights and ceiling_lights of different colors
    public static final Map<modernLights.LuminousColors, Block> CEILING_LIGHTS = new HashMap<>();
    public static final Map<modernLights.LuminousColors, Block> MINI_LIGHTS = new HashMap<>();
    private static final FabricBlockSettings DefaultCeilingLightSettings = Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 10, true, null);
    private static final FabricBlockSettings DefaultMiniLightSettings = Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 8, true, null);


    static {
        // Initialize blocks for each color
        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create ceiling_light and add to map
            String blockName = color.name().equalsIgnoreCase("white") ? "ceiling_light" : "ceiling_light_" + color.name().toLowerCase();

            CEILING_LIGHTS.put(color, createBlock(blockName, false));
        }

        for (modernLights.LuminousColors color : modernLights.LuminousColors.values()) {
            // Create mini_light and add to map

            String blockName = color.name().equalsIgnoreCase("white") ? "mini_light" : "mini_light_" + color.name().toLowerCase();

            MINI_LIGHTS.put(color, createBlock(blockName, true));
        }
    }

    // Method to create panels
    private static Block createBlock(String name, boolean isMiniLight) {
        return Util.registerBlocks(name, isMiniLight ? new MiniLightBlock(DefaultMiniLightSettings) : new CeilingLightBlock(DefaultCeilingLightSettings));
    }

    // Access Ceiling Lights and Mini Lights by color [just in case]
    public static Block getCeilingLightBLock(modernLights.LuminousColors color) {
        return CEILING_LIGHTS.get(color);
    }

    public static Block getMiniLightBLock(modernLights.LuminousColors color) {
        return MINI_LIGHTS.get(color);
    }

    public static void registerBlocks() {

    }
}
