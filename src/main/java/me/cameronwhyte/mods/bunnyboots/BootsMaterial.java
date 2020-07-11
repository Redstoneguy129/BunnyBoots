package me.cameronwhyte.mods.bunnyboots;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum BootsMaterial implements IArmorMaterial {
    BUNNY( "bunnyboots",200, new int[]{1,0,0,0}, 20, 0);

    private String name;
    private int durability;
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private int[] damageReductionAmount;
    private int enchantability;
    private float toughness;

    BootsMaterial(String name, int durability, int[] damageReductionAmount, int enchantability, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.toughness = toughness;
    }

    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionAmount[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.RABBIT_HIDE);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return "bunnyboots:"+this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }
}
