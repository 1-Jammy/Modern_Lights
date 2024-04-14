package com.jammy1.modernlights.custom.shapes;

import com.jammy1.modernlights.custom.types.ToggleableSlab;
import com.jammy1.modernlights.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LuminousSlabBlock extends ToggleableSlab {

    public LuminousSlabBlock(Settings settings) {
        super(settings);
    }



}
