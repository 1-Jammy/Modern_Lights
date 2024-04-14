package com.jammy1.modernlights;

import net.fabricmc.api.ClientModInitializer;

public class modernLightsClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {


/*
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_RED_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_GRAY_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BLUE_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIME_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_CYAN_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_PINK_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BLACK_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BROWN_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_GREEN_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_ORANGE_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_PURPLE_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_YELLOW_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_MAGENTA_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIGHT_BLUE_FULL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIGHT_GRAY_FULL, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_GRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_CYAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BLACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_BROWN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_MAGENTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(MiniBlocks.MINI_LUMINOUS_BLOCK_LIGHT_GRAY, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_GRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_LIME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_CYAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_BLACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_BROWN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_MAGENTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.CEILING_LIGHT_LIGHT_GRAY, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_GRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_LIME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_CYAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_BLACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_BROWN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_MAGENTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_SMALL_LIGHT_GRAY, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_GRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_LIME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_CYAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_BLACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_BROWN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_MAGENTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Lights.MINI_LIGHT_LIGHT_GRAY, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_RED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_GRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_LIME, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_CYAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_PINK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_BLACK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_BROWN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_GREEN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_ORANGE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_PURPLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_YELLOW, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_MAGENTA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_LIGHT_BLUE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Panels.PANEL_LIGHT_GRAY, RenderLayer.getCutout());
*/
    }

}
