package com.jammy1.modernlights.custom.types;

import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ToggleableLtd extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    protected ToggleableLtd(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(LIT, true));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }


    // TODO: Fix Lit turning flase when lever (or any other block) placed next to it
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        boolean bl = state.get(LIT);
        if (bl != world.isReceivingRedstonePower(pos)) { // if LIT = true && isReceivingRedstonePower = false
            if (bl) {
                world.scheduleBlockTick(pos, this, 1);
            } else {
                world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS); // Then set LIT = false
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {

        if(world.isReceivingRedstonePower(pos)){
            return ActionResult.PASS;
        }
        Util.noise(state, world, pos, player, hand, hit, LIT);
        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);

        return ActionResult.SUCCESS;
    }

    // check if the block is receiving redstone signal or not every tick
    // If not, then set LIT to false
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LIT).booleanValue() && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
        }
    }


/* @Override
*
*    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
*                              BlockHitResult hit) {
*
*        Util.noise(state, world, pos, player, hand, hit, LIT);
*        world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
*
*        return ActionResult.SUCCESS;
*    }
*/ // Old Code

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

}
