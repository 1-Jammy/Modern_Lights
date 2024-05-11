package com.jammy1.modernlights.custom.types;

import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ToggleableSlab extends SlabBlock {

    public static final EnumProperty<SlabType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    static {
        TYPE = Properties.SLAB_TYPE;
        WATERLOGGED = Properties.WATERLOGGED;
    }


    public ToggleableSlab(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(TYPE, SlabType.BOTTOM)
                .with(WATERLOGGED, false)
                .with(POWERED, false)
                .with(CLICKED, true)
                .with(LIT, true));
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
            world.scheduleBlockTick(pos, this, 1); // Then set LIT = false
        }
    }

    @SuppressWarnings("deprecation")
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (world.isReceivingRedstonePower(pos)) {
            return ActionResult.PASS;
        }
        Util.makeClickSound(state, world, pos, Hand.MAIN_HAND, CLICKED);
        world.setBlockState(pos, state.cycle(CLICKED));
        world.scheduleBlockTick(pos, this, 1);


        return ActionResult.SUCCESS;
    }


    // check if the block is receiving redstone signal or not every tick
    // If not, then set LIT to false
    @SuppressWarnings("deprecation")
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        boolean powered = state.get(POWERED);
        boolean clicked = state.get(CLICKED);
        boolean lit = state.get(LIT);

        if (world.isReceivingRedstonePower(pos) != powered)
            world.setBlockState(pos, state.cycle(POWERED));


        if (powered && clicked)
            world.setBlockState(pos, state.with(CLICKED, false));


        if (lit != (clicked || powered))
            world.setBlockState(pos, state.cycle(LIT), NOTIFY_LISTENERS);


        if (!clicked && !powered)
            world.setBlockState(pos, state.cycle(LIT), NOTIFY_LISTENERS);

    }

    @Override // Letting Minecraft know that there are FOUR properties in this block
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(TYPE, WATERLOGGED, POWERED, CLICKED, LIT);
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = getBaseState(ctx);

        if (ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())) {
            return blockState
                    .with(POWERED, true)
                    .with(CLICKED, false)
                    .with(LIT, true);
        } else {
            return blockState;
        }
    }

    private BlockState getBaseState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();

        BlockState blockState = ctx.getWorld().getBlockState(blockPos);
        if (blockState.isOf(this)) {
            return blockState.with(TYPE, SlabType.DOUBLE).with(WATERLOGGED, false);
            // change the block type to double if the same slab if being placed
        }
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState2 = this.getDefaultState().with(TYPE, SlabType.BOTTOM).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        Direction direction = ctx.getSide();
        if (direction == Direction.DOWN || direction != Direction.UP && ctx.getHitPos().y - (double) blockPos.getY() > 0.5) {
            return blockState2.with(TYPE, SlabType.TOP);
        }
        return blockState2;
    }
}
