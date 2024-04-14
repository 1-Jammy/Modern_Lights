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

public class PanelSmallBlock extends ToggleablePlus {

    public PanelSmallBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        WallMountLocation face = state.get(FACE);

        return Util.Shape(state, dir, face,
                VoxelShapes.cuboid(0.1875, 0.1875, 0.9375, 0.8125, 0.8125, 1),
                VoxelShapes.cuboid(0.1875, 0.1875, 0, 0.8125, 0.8125, 0.0625),
                VoxelShapes.cuboid(0, 0.1875, 0.1875, 0.0625, 0.8125, 0.8125),
                VoxelShapes.cuboid(0.9375, 0.1875, 0.1875, 1, 0.8125, 0.8125),
                VoxelShapes.cuboid(0.1875, 0.9375, 0.1875, 0.8125, 1, 0.8125),
                VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125));
    }

}
