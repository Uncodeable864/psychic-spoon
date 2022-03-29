package net.kidkoder.psychicspoon.register;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.kidkoder.psychicspoon.te.TileEntityEntitySummoningOrbStand;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class TileEntityRegister {
    public static BlockEntityType<TileEntityEntitySummoningOrbStand> TILE_ENTITY_ENTITY_SUMMONING_ORB_STAND;
    public static void registerTileEntities() {
        TILE_ENTITY_ENTITY_SUMMONING_ORB_STAND = Registry.register(Registry.BLOCK_ENTITY_TYPE, "psychicspoon:summoning_orb_stand_entity", FabricBlockEntityTypeBuilder.create(TileEntityEntitySummoningOrbStand::new, BlockRegister.SUMMONING_ORB_STAND).build());
    }
}
