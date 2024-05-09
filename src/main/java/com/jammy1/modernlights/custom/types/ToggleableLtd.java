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
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ToggleableLtd extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    protected ToggleableLtd(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState()
                .with(POWERED, false)
                .with(CLICKED, true)
                .with(LIT, true));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())) {
            return this.getDefaultState()
                    .with(POWERED, true)
                    .with(CLICKED, false)
                    .with(LIT, true);
        } else {
            return this.getDefaultState();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) {
            return;
        }
        boolean bl = state.get(POWERED);
        if (bl != world.isReceivingRedstonePower(pos)) { // if LIT = true && isReceivingRedstonePower = false
            world.setBlockState(pos, state.cycle(POWERED));
            world.createAndScheduleBlockTick(pos, this, 1); // Then set LIT = false
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
                              BlockHitResult hit) {

        if (world.isReceivingRedstonePower(pos)) {
            return ActionResult.PASS;
        }
        Util.makeClickSound(state, world, pos, hand, CLICKED);
        world.setBlockState(pos, state.cycle(CLICKED));
        world.createAndScheduleBlockTick(pos, this, 1);


        return ActionResult.SUCCESS;
    }


    // check if the block is receiving redstone signal or not every tick
    // If not, then set LIT to false
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        boolean powered = state.get(POWERED);
        boolean lit = state.get(LIT);
        boolean clicked = state.get(CLICKED);

        if (world.isReceivingRedstonePower(pos) != powered) {
            world.setBlockState(pos, state.cycle(POWERED));
        }

        if (powered && clicked) {
            world.setBlockState(pos, state.with(CLICKED, false));
        }

        if (lit != (clicked || powered)) {
            world.setBlockState(pos, state.cycle(LIT), 3);
        }

        if (!clicked && !powered) {
            world.setBlockState(pos, state.cycle(LIT), 3);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED, CLICKED, LIT);
    }
}
