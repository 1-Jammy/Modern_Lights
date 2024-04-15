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

public class MiniBlock extends ToggleablePlus {

    public MiniBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        WallMountLocation face = state.get(FACE);

        return Util.voxelShapeMaker(state, dir, face,
                VoxelShapes.cuboid(0.375, 0.375, 0.75, 0.625, 0.625, 1),
                VoxelShapes.cuboid(0.375, 0.375, 0, 0.625, 0.625, 0.25),
                VoxelShapes.cuboid(0, 0.375, 0.375, 0.25, 0.625, 0.625),
                VoxelShapes.cuboid(0.75, 0.375, 0.375, 1, 0.625, 0.625),
                VoxelShapes.cuboid(0.375, 0.75, 0.375, 0.625, 1, 0.625),
                VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.25, 0.625));
    }

}
