package net.kidkoder.psychicspoon.mixin;

import net.kidkoder.psychicspoon.PsychicSpoonMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class PsychicSpoonMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		PsychicSpoonMod.LOGGER.info("PsychicSpoon mixin registered!");
	}
}
