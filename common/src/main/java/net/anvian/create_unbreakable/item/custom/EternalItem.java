package net.anvian.create_unbreakable.item.custom;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class EternalItem extends Item {
    public EternalItem(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public boolean canBeHurtBy(DamageSource damageSource) {
        return !damageSource.is(DamageTypeTags.IS_EXPLOSION);
    }
}
