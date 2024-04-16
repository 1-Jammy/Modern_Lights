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

    public static final Map<modernLights.LuminousColor, Block> CEILING_LIGHTS = new HashMap<>(); //Create all the color variants
    public static final Map<modernLights.LuminousColor, Block> MINI_LIGHTS = new HashMap<>(); //Create all the color variants

    static {
        final Block CEILING_LIGHT = CeilingLight("ceiling_light");
        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "ceiling_light_" + color.name().toLowerCase();
            CEILING_LIGHTS.put(color, CeilingLight(blockName));
        }

        //MINI LIGHTS
        final Block MINI_LIGHT = MiniLight("mini_light");
        for (modernLights.LuminousColor color : modernLights.LuminousColor.values()) {
            String blockName = "mini_light_" + color.name().toLowerCase();
            MINI_LIGHTS.put(color, MiniLight(blockName));
        }
    }

    private static FabricBlockSettings DefaultCeilingLightSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 8, true);
    }

    private static FabricBlockSettings DefaultMiniLightSettings() {
        return Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 7, true);
    }

    // Ceiling Light
    public static Block CeilingLight(String name) {
        return Util.registerBlocks(name,
                new CeilingLightBlock(DefaultCeilingLightSettings()));
    }

    // Mini Light
    public static Block MiniLight(String name) {
        return Util.registerBlocks(name,
                new MiniLightBlock(DefaultMiniLightSettings()));
    }

    public static void registerBlocks() {

    }
}
