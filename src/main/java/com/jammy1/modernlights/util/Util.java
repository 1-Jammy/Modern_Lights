package com.jammy1.modernlights.util;

import com.jammy1.modernlights.modernLights;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class Util {

    public static Block registerBlocks(String name, Block block) {// register blocks without tooltip

        registerBlockItem(name, block); //calls the registerBlockItem function to register an item for this block
        return Registry.register(Registry.BLOCK, new Identifier(modernLights.MOD_ID, name), block);
    }


    public static Block registerBlocks(String name, String info, Block block) { //register blocks with tooltip

        if (info == null) {
            return registerBlocks(name, block);
        } else {
            registerBlockItem(name, info, block); //calls the registerBlockItem function to register an item for this block
            return Registry.register(Registry.BLOCK, new Identifier(modernLights.MOD_ID, name), block);
        }
    }

    private static Item registerBlockItem(String name, Block block) {

        //adds freshly created item to the item group

        return Registry.register(Registry.ITEM, new Identifier(modernLights.MOD_ID, name), new BlockItem(block, (new FabricItemSettings()
                .group(modernLights.ITEM_GROUP))
        ));
    }


    //Register blocks with only one tooltip
    private static Item registerBlockItem(String name, String info, Block block) {


        return Registry.register(Registry.ITEM, new Identifier(modernLights.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(modernLights.ITEM_GROUP)) {//adds freshly created item to the item group

            @Override //add tooltip for this item
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(new TranslatableText(info));
            }
        });
    }

    //Make the block settings for the blocks
    public static final FabricBlockSettings CREATE_BLOCK_SETTINGS(float hardness, float resistance, BooleanProperty property, int lit, boolean isNonOpaque, modernLights.LuminousColors mapColor) {
        final PistonBehavior pistonBehavior = isNonOpaque ? PistonBehavior.DESTROY : PistonBehavior.NORMAL;
        FabricBlockSettings settings = FabricBlockSettings.of(
                        new Material(getMapColor(mapColor), false, !isNonOpaque, true, false, true, false, pistonBehavior))
                .sounds(BlockSoundGroup.METAL).strength(hardness, resistance);

        if (isNonOpaque) {
            return settings = settings.luminance((state) -> state.get(property) ? lit : 0).nonOpaque();
        } else {
            return settings = settings.luminance((state) -> state.get(property) ? lit : 0);

        }
    }

    //Make the *click* sound
    public static void makeClickSound(BlockState state, World world, BlockPos pos, Hand hand, BooleanProperty clicked) {

        if (!world.isClient() && hand == Hand.MAIN_HAND) {
            float pitch = state.get(clicked) ? 1.5F : 2.0F;
            SoundEvent soundEvent = SoundEvents.BLOCK_LEVER_CLICK;
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 0.1F, pitch);
        }
    }


    //Provide faces for FACING block state
    public static VoxelShape voxelShapeMaker(Direction dir, WallMountLocation face, VoxelShape North, VoxelShape South, VoxelShape East, VoxelShape West, VoxelShape Up, VoxelShape Down) {

        switch (face) {
            case WALL -> {
                return switch (dir) {
                    case SOUTH -> South;
                    case EAST -> East;
                    case WEST -> West;
                    default -> North;
                };
            }
            case CEILING -> {
                return Up;
            }
            default -> {
                return Down;
            }
        }
    }

    public static MapColor getMapColor(@Nullable modernLights.LuminousColors color) {
        if (color == null) {
            return MapColor.CLEAR;
        }
        return switch (color) {
            case LIGHT_GRAY -> MapColor.LIGHT_GRAY;
            case GRAY -> MapColor.GRAY;
            case BLACK -> MapColor.BLACK;
            case BROWN -> MapColor.BROWN;
            case RED -> MapColor.RED;
            case ORANGE -> MapColor.ORANGE;
            case YELLOW -> MapColor.YELLOW;
            case LIME -> MapColor.LIME;
            case GREEN -> MapColor.GREEN;
            case CYAN -> MapColor.CYAN;
            case LIGHT_BLUE -> MapColor.LIGHT_BLUE;
            case BLUE -> MapColor.BLUE;
            case PURPLE -> MapColor.PURPLE;
            case MAGENTA -> MapColor.MAGENTA;
            case PINK -> MapColor.PINK;
            default -> MapColor.WHITE;
        };
    }
}
