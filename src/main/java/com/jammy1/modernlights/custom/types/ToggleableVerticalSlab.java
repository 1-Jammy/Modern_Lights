package com.jammy1.modernlights.custom.types;

import com.jammy1.modernlights.util.Util;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class ToggleableVerticalSlab extends HorizontalFacingBlock implements Waterloggable {
    public static final MapCodec<ToggleableVerticalSlab> CODEC = createCodec(ToggleableVerticalSlab::new);
    public static final EnumProperty<VerticalSlabType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final EnumProperty<VerticalSlabType> VERTICAL_SLAB_TYPE = EnumProperty.of("type", VerticalSlabType.class);
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    static {
        TYPE = VERTICAL_SLAB_TYPE;
        WATERLOGGED = Properties.WATERLOGGED;
    }


    public ToggleableVerticalSlab(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(TYPE, VerticalSlabType.SINGLE)
                .with(FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
                .with(POWERED, false)
                .with(CLICKED, true)
                .with(LIT, true));
    }

    @Override
    protected MapCodec<? extends ToggleableVerticalSlab> getCodec() {
        return null;
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
    @Override
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

    @SuppressWarnings("deprecation")
    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override // Letting Minecraft know that there are FOUR properties in this block
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(TYPE, FACING, WATERLOGGED, POWERED, CLICKED, LIT);
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
        }

        return blockState;
    }

    private BlockState getBaseState(ItemPlacementContext ctx) {
        Direction blockSide = ctx.getSide();

        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = ctx.getWorld().getBlockState(blockPos);

        if (blockState.isOf(this)) {
            return blockState.with(TYPE, VerticalSlabType.DOUBLE).with(WATERLOGGED, false);
        }

        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState2 = this.getDefaultState().with(TYPE, VerticalSlabType.SINGLE).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);

        BlockState blockState3;

        switch (blockSide) {
            case DOWN, UP -> {
                switch (ctx.getHorizontalPlayerFacing()) {
                    case NORTH, SOUTH -> {
                        if (ctx.getHitPos().z - (double) blockPos.getZ() > 0.5) {
                            blockState3 = blockState2.with(TYPE, VerticalSlabType.SINGLE).with(FACING, Direction.SOUTH);
                            break;
                        }
                        blockState3 = blockState2.with(TYPE, VerticalSlabType.SINGLE).with(FACING, Direction.NORTH);
                    }
                    default -> {
                        if (ctx.getHitPos().x - (double) blockPos.getX() < 0.5) {
                            blockState3 = blockState2.with(TYPE, VerticalSlabType.SINGLE).with(FACING, Direction.WEST);
                            break;
                        }
                        blockState3 = blockState2.with(TYPE, VerticalSlabType.SINGLE).with(FACING, Direction.EAST);
                    }
                }
            }
            default -> {
                blockState3 = blockState2.with(TYPE, VerticalSlabType.SINGLE).with(FACING, blockSide.getOpposite());
            }
        }
        return blockState3;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        ItemStack itemStack = context.getStack();
        VerticalSlabType slabType = state.get(TYPE);

        if (slabType == VerticalSlabType.DOUBLE || !itemStack.isOf(this.asItem())) {
            return false;
        }
        if (context.canReplaceExisting()) {

            Direction direction = context.getSide();
            Direction facing = state.get(FACING);
            return direction.getOpposite() == facing;

        }
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (state.get(TYPE) != VerticalSlabType.DOUBLE) {
            return Waterloggable.super.tryFillWithFluid(world, pos, state, fluidState);
        }
        return false;
    }

    public boolean canFillWithFluid(@Nullable PlayerEntity player, BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return state.get(TYPE) != VerticalSlabType.DOUBLE ? Waterloggable.super.canFillWithFluid(player, world, pos, state, fluid) : false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @SuppressWarnings("deprecation")
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND, AIR -> {
                return false;
            }
            case WATER -> {
                return world.getFluidState(pos).isIn(FluidTags.WATER);
            }
        }
        return false;
    }
}
