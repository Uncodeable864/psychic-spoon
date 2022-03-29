package net.kidkoder.psychicspoon.block;

import net.kidkoder.psychicspoon.item.ItemMysteriousOrb;
import net.kidkoder.psychicspoon.register.ItemRegister;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOrbCrusher extends Block {
    public BlockOrbCrusher(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            // Check if the player is holding an orb
            if (player.getStackInHand(hand).getItem() instanceof ItemMysteriousOrb) {
                player.sendMessage(new LiteralText("You crushed the orb!"), true);
                player.getStackInHand(hand).decrement(1);
                player.giveItemStack(new ItemStack(ItemRegister.CRUSHED_ORB, 64));
            }
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
