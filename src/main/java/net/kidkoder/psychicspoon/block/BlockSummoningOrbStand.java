package net.kidkoder.psychicspoon.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kidkoder.psychicspoon.te.TileEntityEntitySummoningOrbStand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class BlockSummoningOrbStand extends Block implements BlockEntityProvider {
    public BlockSummoningOrbStand(FabricBlockSettings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TileEntityEntitySummoningOrbStand(pos, state);
    }
}
