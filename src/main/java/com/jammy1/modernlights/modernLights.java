package com.jammy1.modernlights;

import com.jammy1.modernlights.modBlocks.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class modernLights implements ModInitializer {

    public static final String MOD_ID = "modernlights";

    public static final String fullInfo = "full.info";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "modernlights"), () -> {
        return new ItemStack(LuminousBlocks.getLuminousBLock(LuminousColors.WHITE));
    });

    @Override
    public void onInitialize() {

        System.out.println(MOD_ID + " Registration Started");

        LuminousBlocks.registerBlocks();
        LuminousSlabs.registerBlocks();
        LuminousVerticalSlabs.registerBlocks();
        LuminousMiniBlocks.registerBlocks();
        LuminousPanels.registerBlocks();
        LuminousLights.registerBlocks();

        System.out.println(MOD_ID + " Registration Completed!");

    }

    public enum LuminousColors { //All the colors for all the blocks
        WHITE, LIGHT_GRAY, GRAY, BLACK, BROWN, RED, ORANGE, YELLOW, LIME, GREEN, CYAN, LIGHT_BLUE, BLUE, PURPLE, MAGENTA, PINK
    }

}
