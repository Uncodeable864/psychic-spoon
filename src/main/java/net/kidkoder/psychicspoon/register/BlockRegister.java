package net.kidkoder.psychicspoon.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kidkoder.psychicspoon.PsychicSpoonMod;
import net.kidkoder.psychicspoon.block.BlockOrbCrusher;
import net.kidkoder.psychicspoon.block.BlockSummoningOrbStand;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegister {
    public static final Block ORB_CRUSHER = new BlockOrbCrusher(FabricBlockSettings.of(Material.METAL).strength(3.0F, 3.0F));
    public static final Block SUMMONING_ORB_STAND = new BlockSummoningOrbStand(FabricBlockSettings.of(Material.METAL).strength(3.0F, 3.0F));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("psychicspoon", "orb_crusher"), ORB_CRUSHER);
        Registry.register(Registry.BLOCK, new Identifier("psychicspoon", "summoning_orb_stand"), SUMMONING_ORB_STAND);
    }

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier("psychicspoon", "orb_crusher"), new BlockItem(ORB_CRUSHER, new FabricItemSettings().group(PsychicSpoonMod.PSYCHIC_SPOON_GROUP_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("psychicspoon", "summoning_orb_stand"), new BlockItem(SUMMONING_ORB_STAND, new FabricItemSettings().group(PsychicSpoonMod.PSYCHIC_SPOON_GROUP_BLOCKS)));
    }
}
