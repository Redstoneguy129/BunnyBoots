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

/**
 * @author Redstoneguy129
 * <p>
 * Main class of the mod
 */
@Mod("bunnyboots")
public class BunnyBoots {

    /**
     * Constructor that register the class as an Envent Listener
     */
    public BunnyBoots() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Item instance for the bunny boots
     */
    public static Item BUNNYBOOTS = new ArmorItem(BootsMaterial.BUNNY, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).maxDamage(200)).setRegistryName("bunnyboots", "bunnyboots");

    /**
     * Event called in every tick for the armour
     *
     * @param event
     */
    @SubscribeEvent
    public void onArmourTick(TickEvent.PlayerTickEvent event) {
        if (!event.player.world.isRemote) return;
        PlayerEntity player = event.player;
        if (player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem().equals(BUNNYBOOTS)) {
            player.jumpMovementFactor = .045F;
        }
    }

    /**
     * Class to register the armour
     */
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Register {

        /**
         * Event called when the items are registered to register the armour
         *
         * @param event
         */
        @SubscribeEvent
        public static void armourRegister(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(BUNNYBOOTS);
        }
    }
}
