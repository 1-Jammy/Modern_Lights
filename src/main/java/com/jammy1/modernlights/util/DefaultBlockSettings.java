package com.jammy1.modernlights.util;

import com.jammy1.modernlights.custom.shapes.*;
import com.jammy1.modernlights.modernLights.LuminousColors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class DefaultBlockSettings {

    public static FabricBlockSettings defaultAndesiteFrameSettings() {
        return FabricBlockSettings.of(Material.STONE)
                .sounds(BlockSoundGroup.METAL)
                .strength(5.0F, 5.0F);
    }

    public static FabricBlockSettings defaultLuminousBlockSettings(LuminousColors color) {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousBlock.LIT, 15, false, color);
    }
    public static FabricBlockSettings defaultPanelSettings(LuminousColors color) {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelBlock.LIT, 14, true, color);
    }

    public static FabricBlockSettings defaultLuminousSlabSettings(LuminousColors color) {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousSlabBlock.LIT, 15, false, color);
    }
    public static FabricBlockSettings defaultLuminousVerticalSlabSettings(LuminousColors color) {
        return Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, LuminousSlabBlock.LIT, 15, false, color);
    }
    public static final FabricBlockSettings DEFAULT_CEILING_LIGHT_SETTINGS =
            Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 10, true, null).noCollision();
    public static final FabricBlockSettings DEFAULT_MINI_LIGHT_SETTINGS =
            Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniLightBlock.LIT, 8, true, null).noCollision();
    public static final FabricBlockSettings DEFAULT_MINI_BLOCK_SETTINGS =
            Util.CREATE_BLOCK_SETTINGS(2.0f, 4.0f, MiniBlock.LIT, 12, true, null);
    public static final FabricBlockSettings DEFAULT_SMALL_PANEL_SETTINGS =
            Util.CREATE_BLOCK_SETTINGS(2.5f, 5.0f, PanelSmallBlock.LIT, 12, true, null).noCollision();

}
