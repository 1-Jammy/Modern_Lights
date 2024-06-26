package com.jammy1.modernlights;

import com.jammy1.modernlights.modBlocks.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class modernLights implements ModInitializer {

    public static final String MOD_ID = "modernlights";

    // Adds a new Inventory Tab
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, MOD_ID));
    public static final String fullInfo = "full.info"; // Provides tooltip for the block, can be changed in the lang file

    @Override
    public void onInitialize() {

        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(LuminousBlocks.getLuminousBLock(LuminousColors.WHITE)))
                .displayName(Text.translatable("itemGroup.modernlights"))
                .build());

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
