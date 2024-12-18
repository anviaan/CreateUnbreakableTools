package net.anvian.create_unbreakable.block.custom;

import net.minecraft.world.level.block.Block;

public abstract class EternalBlock extends Block {
    public EternalBlock(Properties properties) {
        super(properties.strength(25.0F, 1200.0F));
    }
}
