package me.cameronwhyte.mods.bunnyboots;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @author Redstoneguy129
 * <p>
 * Enum for the armor material
 */
public enum BootsMaterial implements IArmorMaterial {
    BUNNY("bunnyboots", 200, new int[]{1, 0, 0, 0}, 20, 0);

    /**
     * Name of the armour
     */
    private String name;

    /**
     * Durability of the armour
     */
    private int durability;

    /**
     * Max durability of the armour parts
     */
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};

    /**
     * The amount of damage that reduce the part of the armour
     */
    private int[] damageReductionAmount;

    /**
     * The enchantability level
     */
    private int enchantability;

    /**
     * Toughness of the armour
     */
    private float toughness;

    BootsMaterial(String name, int durability, int[] damageReductionAmount, int enchantability, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmount = damageReductionAmount;
        this.enchantability = enchantability;
        this.toughness = toughness;
    }

    /**
     * Getter for the actual durability of the armour
     * @param equipmentSlotType Slot type of the armour part
     * @return Actual durability
     */
    @Override
    public int getDurability(EquipmentSlotType equipmentSlotType) {
        return MAX_DAMAGE_ARRAY[equipmentSlotType.getIndex()] * this.durability;
    }

    /**
     * Getter for the amount of damage that reduce the armour for that part
     * @param equipmentSlotType Slot type of the armour part
     * @return Damage reduction for the part
     */
    @Override
    public int getDamageReductionAmount(EquipmentSlotType equipmentSlotType) {
        return this.damageReductionAmount[equipmentSlotType.getIndex()];
    }

    /**
     * Getter for the enchantability level
     * @return enchantability level
     */
    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    /**
     * Getter for the correspondent sound of the armour for the equipment
     * @return Sound event
     */
    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    /**
     * Getter for the necessary material to repair it
     * @return material to repair it
     */
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(Items.RABBIT_HIDE);
    }

    /**
     * Getter for the Name
     * @return modID:name
     */
    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return "bunnyboots:" + this.name;
    }

    /**
     * Getter for the toughness of the armour
     * @return
     */
    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }
}
