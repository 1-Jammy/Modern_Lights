package com.jammy1.modernlights.custom.shapes;

import com.jammy1.modernlights.custom.types.ToggleablePlus;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CeilingLightBlock extends ToggleablePlus {

    public CeilingLightBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        WallMountLocation face = state.get(FACE);

        return Util.voxelShapeMaker(dir, face,
                VoxelShapes.cuboid(0.3125, 0.3125, 0.9375, 0.6875, 0.6875, 1),
                VoxelShapes.cuboid(0.3125, 0.3125, 0, 0.6875, 0.6875, 0.0625),
                VoxelShapes.cuboid(0, 0.3125, 0.3125, 0.0625, 0.6875, 0.6875),
                VoxelShapes.cuboid(0.9375, 0.3125, 0.3125, 1, 0.6875, 0.6875),
                VoxelShapes.cuboid(0.3125, 0.9375, 0.3125, 0.6875, 1, 0.6875),
                VoxelShapes.cuboid(0.3125, 0, 0.3125, 0.6875, 0.0625, 0.6875)
        );
    }

}
