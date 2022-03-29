package net.kidkoder.psychicspoon.te;

import net.kidkoder.psychicspoon.register.TileEntityRegister;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TileEntityEntitySummoningOrbStand extends BlockEntity {
    public TileEntityEntitySummoningOrbStand(BlockPos pos, BlockState state) {
        super(TileEntityRegister.TILE_ENTITY_ENTITY_SUMMONING_ORB_STAND, pos, state);

    }

    private String it = "worked";

    @Override
    protected void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putString("it", it);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        it = tag.getString("it");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
