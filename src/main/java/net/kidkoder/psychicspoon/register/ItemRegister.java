package net.kidkoder.psychicspoon.register;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kidkoder.psychicspoon.PsychicSpoonMod;
import net.kidkoder.psychicspoon.item.ItemDiscoveredOrb;
import net.kidkoder.psychicspoon.item.ItemMysteriousOrb;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegister {
    public static final Item MYSTERIOUS_ORB = new ItemMysteriousOrb(new FabricItemSettings().group(PsychicSpoonMod.PSYCHIC_SPOON_GROUP_ITEMS).maxCount(1));
    public static final Item DISCOVERED_ORB = new ItemDiscoveredOrb(new FabricItemSettings().group(PsychicSpoonMod.PSYCHIC_SPOON_GROUP_ITEMS).maxCount(1));
    public static final Item CRUSHED_ORB = new Item(new FabricItemSettings().group(PsychicSpoonMod.PSYCHIC_SPOON_GROUP_ITEMS));
    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("psychicspoon", "mysterious_orb"), MYSTERIOUS_ORB);
        Registry.register(Registry.ITEM, new Identifier("psychicspoon", "discovered_orb"), DISCOVERED_ORB);
        Registry.register(Registry.ITEM, new Identifier("psychicspoon", "crushed_orb"), CRUSHED_ORB);
    }
}
