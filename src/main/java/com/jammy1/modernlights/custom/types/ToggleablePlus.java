package com.jammy1.modernlights.custom.types;


import com.jammy1.modernlights.util.Util;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ToggleablePlus extends WallMountedBlock implements Waterloggable {


    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public static final BooleanProperty LIT = BooleanProperty.of("lit");


    protected ToggleablePlus(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState()).with(FACING, Direction.NORTH).with(FACE, WallMountLocation.WALL).with(WATERLOGGED, false).with(POWERED, false).with(CLICKED, true).with(LIT, true));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {

        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean bl = fluidState.getFluid() == Fluids.WATER;

        BlockState blockState = this.getDefaultState().with(FACING, getFacing(ctx)).with(FACE, getFace(ctx)).with(WATERLOGGED, bl);

        if (ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())) {
            return blockState.with(POWERED, true).with(CLICKED, false).with(LIT, true);
        } else {
            return blockState;
        }
    }

    private WallMountLocation getFace(ItemPlacementContext ctx) {

        Direction dir = ctx.getSide().getOpposite();

        switch (dir) {
            case UP:
                return WallMountLocation.CEILING;
            case DOWN:
                return WallMountLocation.FLOOR;
            default:
                return WallMountLocation.WALL;
        }
    }

    private Direction getFacing(ItemPlacementContext ctx) {

        Direction side = ctx.getSide();

        switch (side) {
            case UP:
                return Direction.NORTH;
            case DOWN:
                return Direction.NORTH;
            default:
                return side;
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
            world.scheduleBlockTick(pos, this, 1); // Then set LIT = false
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.isReceivingRedstonePower(pos)) {
            return ActionResult.PASS;
        }
        Util.makeClickSound(state, world, pos, hand, CLICKED);
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

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = attachedDirection(state).getOpposite();
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.getOpposite());
    }

    protected static Direction attachedDirection(BlockState state) {
        if (state.get(FACE) == WallMountLocation.WALL) {
            return state.get(FACING);
        }
        return state.get(FACE) == WallMountLocation.FLOOR ? Direction.UP : Direction.DOWN;
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, WATERLOGGED, POWERED, CLICKED, LIT);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {

        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
