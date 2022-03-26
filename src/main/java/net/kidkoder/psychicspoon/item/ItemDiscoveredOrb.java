package net.kidkoder.psychicspoon.item;

import net.kidkoder.psychicspoon.PsychicSpoonMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ItemDiscoveredOrb extends Item {
    public ItemDiscoveredOrb(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            String ability = user.getStackInHand(hand).getNbt().getString("ability");
            if (ability.equals("")) {
            } else if (ability.equals("Invulnerable")) {
                PsychicSpoonMod.LOGGER.info("Invulnerable");
                if (user.isInvulnerable()) {
                    user.setInvulnerable(false);
                    user.sendMessage(new TranslatableText("action.psychicspoon.off", "invulnerable"), true);
                } else {
                    user.setInvulnerable(true);
                    user.sendMessage(new TranslatableText("action.psychicspoon.on", "invulnerable"), true);
                }
            } else if (ability.equals("Invisibility")) {
                if (user.isInvisible()) {
                    user.setInvisible(false);
                    user.sendMessage(new TranslatableText("action.psychicspoon.off", "invisible"), true);
                } else {
                    user.setInvisible(true);
                    user.sendMessage(new TranslatableText("action.psychicspoon.on", "invisible"), true);
                }
            } else if (ability.equals("Speed")) {
                if (user.hasStatusEffect(StatusEffects.SPEED)) {
                    user.removeStatusEffect(StatusEffects.SPEED);
                    user.sendMessage(new TranslatableText("action.psychicspoon.off_effect", "speed"), true);
                } else {
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 999999, 4));
                    user.sendMessage(new TranslatableText("action.psychicspoon.on_effect", "speed"), true);
                }
            }
        }
        //   user.setVelocity(user.getVelocity().add(0, 10, 0));
        return super.use(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
//        stack.getOrCreateNbt().getString("ability");
        // set tooltip to be gray color
        String ability = stack.getOrCreateNbt().getString("ability");
        if (ability.equals("")) {
            ability = "None";
        }
        tooltip.add(new LiteralText("§7Ability: " + ability));
    }
}
