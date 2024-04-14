package com.jammy1.modernlights.modBlocks;

import com.jammy1.modernlights.custom.shapes.CeilingLightBlock;
import com.jammy1.modernlights.custom.shapes.MiniLightBlock;
import com.jammy1.modernlights.modernLights;
import com.jammy1.modernlights.util.Util;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import java.util.HashMap;
import java.util.Map;

public class Lights {

    /*

        public static final Block CEILING_LIGHT_ORANGE     = Make.CeilingLight("ceiling_light_orange");
        public static final Block CEILING_LIGHT_MAGENTA    = Make.CeilingLight("ceiling_light_magenta");
        public static final Block CEILING_LIGHT_LIGHT_BLUE = Make.CeilingLight("ceiling_light_light_blue");
        public static final Block CEILING_LIGHT_YELLOW     = Make.CeilingLight("ceiling_light_yellow");
        public static final Block CEILING_LIGHT_LIME       = Make.CeilingLight("ceiling_light_lime");
        public static final Block CEILING_LIGHT_PINK       = Make.CeilingLight("ceiling_light_pink");
        public static final Block CEILING_LIGHT_GRAY       = Make.CeilingLight("ceiling_light_gray");
        public static final Block CEILING_LIGHT_LIGHT_GRAY = Make.CeilingLight("ceiling_light_light_gray");
        public static final Block CEILING_LIGHT_CYAN       = Make.CeilingLight("ceiling_light_cyan");
        public static final Block CEILING_LIGHT_PURPLE     = Make.CeilingLight("ceiling_light_purple");
        public static final Block CEILING_LIGHT_BLUE       = Make.CeilingLight("ceiling_light_blue");
        public static final Block CEILING_LIGHT_BROWN      = Make.CeilingLight("ceiling_light_brown");
        public static final Block CEILING_LIGHT_GREEN      = Make.CeilingLight("ceiling_light_green");
        public static final Block CEILING_LIGHT_RED        = Make.CeilingLight("ceiling_light_red");
        public static final Block CEILING_LIGHT_BLACK      = Make.CeilingLight("ceiling_light_black");


        public static final Block MINI_LIGHT_ORANGE     = Make.MiniLight("mini_light_orange");
        public static final Block MINI_LIGHT_MAGENTA    = Make.MiniLight("mini_light_magenta");
        public static final Block MINI_LIGHT_LIGHT_BLUE = Make.MiniLight("mini_light_light_blue");
        public static final Block MINI_LIGHT_YELLOW     = Make.MiniLight("mini_light_yellow");
        public static final Block MINI_LIGHT_LIME       = Make.MiniLight("mini_light_lime");
        public static final Block MINI_LIGHT_PINK       = Make.MiniLight("mini_light_pink");
        public static final Block MINI_LIGHT_GRAY       = Make.MiniLight("mini_light_gray");
        public static final Block MINI_LIGHT_LIGHT_GRAY = Make.MiniLight("mini_light_light_gray");
        public static final Block MINI_LIGHT_CYAN       = Make.MiniLight("mini_light_cyan");
        public static final Block MINI_LIGHT_PURPLE     = Make.MiniLight("mini_light_purple");
        public static final Block MINI_LIGHT_BLUE       = Make.MiniLight("mini_light_blue");
        public static final Block MINI_LIGHT_BROWN      = Make.MiniLight("mini_light_brown");
        public static final Block MINI_LIGHT_GREEN      = Make.MiniLight("mini_light_green");
        public static final Block MINI_LIGHT_RED        = Make.MiniLight("mini_light_red");
        public static final Block MINI_LIGHT_BLACK      = Make.MiniLight("mini_light_black");
*/

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
/*
        // Access blocks by color [just in case]
        public static Block getCeilingLight(modernLights.LuminousColor color) {
                return CEILING_LIGHTS.get(color);
        }
        public static Block getMiniLight(modernLights.LuminousColor color) {

                return MINI_LIGHTS.get(color);
        }*/

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
