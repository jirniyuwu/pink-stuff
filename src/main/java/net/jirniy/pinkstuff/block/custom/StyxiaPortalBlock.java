package net.jirniy.pinkstuff.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Portal;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

//public class StyxiaPortalBlock extends CustomPortalBlock implements Portal {
//    private static final VoxelShape SHAPE =
//            Block.createCuboidShape(0, 5, 0, 16, 10, 16);
//
//    public StyxiaPortalBlock(Settings settings) {
//        super(settings);
//    }
//
//    @Override
//    public int getPortalDelay(ServerWorld world, Entity entity) {
//        return 0;
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return SHAPE;
//    }
//}
