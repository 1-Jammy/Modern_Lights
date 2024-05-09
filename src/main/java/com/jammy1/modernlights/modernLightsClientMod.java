package com.jammy1.modernlights;

import com.jammy1.modernlights.modBlocks.*;
import com.jammy1.modernlights.modernLights.LuminousColors;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class modernLightsClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        for (LuminousColors color : LuminousColors.values()) {
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousLights.getCeilingLightBLock(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousLights.getMiniLightBLock(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousMiniBlocks.getMiniBLock(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousMiniBlocks.getMiniBlockFull(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousPanels.getPanelBLock(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousPanels.getSmallPanelBLock(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousVerticalSlabs.getLuminousVerticalSlab(color), RenderLayer.getCutout());
            BlockRenderLayerMap.INSTANCE.putBlock(LuminousVerticalSlabs.getLuminousVerticalSlabFull(color), RenderLayer.getCutout());
        }
    }

}
