package me.cameronwhyte.mods.bunnyboots;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.rmi.registry.Registry;

@Mod("bunnyboots")
public class BunnyBoots {
    public BunnyBoots() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static Item BUNNYBOOTS = new ArmorItem(BootsMaterial.BUNNY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName("bunnyboots", "bunnyboots");

    @SubscribeEvent
    public void onArmourTick(TickEvent.PlayerTickEvent event) {
        //if(event.player.world.isRemote) return;
        PlayerEntity player = event.player;
        if(player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(BUNNYBOOTS)) {
            player.jumpMovementFactor = .045F;
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {
        @SubscribeEvent
        public static void armourRegister(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(BUNNYBOOTS);
        }
    }
}
