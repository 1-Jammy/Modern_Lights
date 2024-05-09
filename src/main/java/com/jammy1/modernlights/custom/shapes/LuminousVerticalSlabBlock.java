package com.jammy1.modernlights.custom.shapes;

import com.jammy1.modernlights.custom.types.ToggleableVerticalSlab;
import com.jammy1.modernlights.custom.types.VerticalSlabType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class LuminousVerticalSlabBlock extends ToggleableVerticalSlab {
    public static final VoxelShape North = VoxelShapes.cuboid(0, 0, 0, 1, 1, 0.5);
    public static final VoxelShape South = VoxelShapes.cuboid(0, 0, 0.5, 1, 1, 1);
    public static final VoxelShape East = VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 1);
    public static final VoxelShape West = VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 1);

    public LuminousVerticalSlabBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        VerticalSlabType type = state.get(TYPE);

        if (type == VerticalSlabType.DOUBLE) {
            return VoxelShapes.fullCube();
        }
        switch (dir) {
            case SOUTH -> {
                return South;
            }
            case EAST -> {
                return East;
            }
            case WEST -> {
                return West;
            }
            default -> {
                return North;
            }
        }
    }
}
