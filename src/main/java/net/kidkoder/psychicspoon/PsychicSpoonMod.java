package net.kidkoder.psychicspoon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kidkoder.psychicspoon.register.ItemRegister;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PsychicSpoonMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("psychicspoon");
	public static final ItemGroup PSYCHIC_SPOON_GROUP = FabricItemGroupBuilder.build(
			new Identifier("psychicspoon", "items"),
			() -> new ItemStack(ItemRegister.MYSTERIOUS_ORB));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ItemRegister.registerItems();
		LOGGER.info("PsychicSpoon initialized!");
	}
}
