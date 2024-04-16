package com.jammy1.modernlights.custom.types;

import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ToggleablePlus extends WallMountedBlock {

    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    protected ToggleablePlus(Settings settings) {
        super(settings);
        this.setDefaultState((this.stateManager.getDefaultState())
                .with(FACING, Direction.NORTH).with(FACE, WallMountLocation.WALL).with(LIT, true));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())).with(FACING, getFacingState(ctx))
                .with(FACE, getFaceState(ctx));
    }

    private WallMountLocation getFaceState(ItemPlacementContext ctx) {

        Direction dir = ctx.getSide().getOpposite();

        return switch (dir) {
            case UP -> WallMountLocation.CEILING;
            case DOWN -> WallMountLocation.FLOOR;
            default -> WallMountLocation.WALL;
        };
    }

    private Direction getFacingState(ItemPlacementContext ctx) {

        Direction side = ctx.getSide();

        return switch (side) {
            case UP, DOWN -> Direction.NORTH;
            default -> side;
        };
    }

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

        if (world.isReceivingRedstonePower(pos)) {
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
        if (state.get(LIT) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, state.cycle(LIT), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, LIT);
    }

}
