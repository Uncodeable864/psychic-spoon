package net.kidkoder.psychicspoon.item;

import net.kidkoder.psychicspoon.register.ItemRegister;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMysteriousOrb extends Item {
    public ItemMysteriousOrb(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && user.getStackInHand(hand).getItem() == ItemRegister.MYSTERIOUS_ORB) {
            user.getInventory().removeOne(user.getStackInHand(hand));
            ItemStack stack = new ItemStack(ItemRegister.DISCOVERED_ORB, 1);
            // Randomly choose an ability
            String[] abilities = new String[]{"Invulnerable", "Invisibility", "Speed"};
            // Pick a random element from the list
            int random = (int) (Math.random() * abilities.length);
            stack.getOrCreateNbt().putString("ability", abilities[random]);
            user.getInventory().offerOrDrop(stack);
            user.sendMessage(new TranslatableText("message.psychicspoon.orb_discovered", abilities[random]), true);
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new LiteralText("§7Ability: §kunknown"));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
