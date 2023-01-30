package codes.cheater.fluid_sieve.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import virtuoel.towelette.api.FluidProperties;
import virtuoel.towelette.api.Fluidloggable;

public class NetBlock extends Block implements Fluidloggable {
    private static final VoxelShape collisionShape=
            VoxelShapes.union(
                    createCuboidShape(0, 0, 0, 1, 16, 1),
                    createCuboidShape(15, 0, 0, 16, 16, 1),
                    createCuboidShape(0, 0, 15, 1, 16, 16),
                    createCuboidShape(15, 0, 15, 16, 16, 16),
                    createCuboidShape(1, 1, 0, 15, 14, 1),
                    createCuboidShape(1, 1, 15, 15, 14, 16),
                    createCuboidShape(0, 1, 1, 1, 14, 16),
                    createCuboidShape(15, 1, 1, 16, 14, 16)
            );

    public NetBlock(Block.Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FluidProperties.FLUID, FluidProperties.LEVEL_1_8, FluidProperties.FALLING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return collisionShape;
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return collisionShape;
    }
}
