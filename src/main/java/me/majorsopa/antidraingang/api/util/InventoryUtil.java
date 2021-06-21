package me.majorsopa.antidraingang.api.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.Iterator;

public class InventoryUtil {
    public static PlayerInventory getInventory() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        assert player != null;
        return player.inventory;
    }



    public static int amountInInv(Item item) {
        return getInventory().count(item);
    }



    public static ItemStack getMainhand() {
        return getInventory().getMainHandStack();
    }

    public static ItemStack getOffhand() {
        return getInventory().offHand.get(0);
    }



    public static ItemStack getArmor(int slot) {
        return getInventory().getArmorStack(slot);
    }

    //todo see if these are actually the correct indices
    public static ItemStack getHelmet() {
        return getArmor(0);
    }

    public static ItemStack getChestplate() {
        return getArmor(1);
    }

    public static ItemStack getLeggings() {
        return getArmor(2);
    }

    public static ItemStack getBoots() {
        return getArmor(3);
    }



    public static int getSelectedSlot() {
        return getInventory().selectedSlot;
    }

    public static ItemStack getSlot(int slot) {
        return getInventory().getStack(slot);
    }

    public static ItemStack getSelectedItem() {
        return getSlot(getSelectedSlot());
    }
}
