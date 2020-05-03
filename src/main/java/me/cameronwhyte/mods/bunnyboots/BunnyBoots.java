package me.cameronwhyte.mods.bunnyboots;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("bunnyboots")
public class BunnyBoots {
    public BunnyBoots() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static Item BUNNYBOOTS = new ArmorItem(BootsMaterial.BUNNY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).maxDamage(200)).setRegistryName("bunnyboots", "bunnyboots");

    @SubscribeEvent
    public void onArmourTick(TickEvent.PlayerTickEvent event) {
        if(!event.player.world.isRemote) return;
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
