package net.anvian.create_unbreakable.block.custom;

import net.anvian.create_unbreakable.config.ModConfigs;
import net.anvian.create_unbreakable.item.ModItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class LuminarchyBlock extends EternalBlock {
    public LuminarchyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && ModConfigs.luminarchyExplosionAtBreak) {
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3, false, Level.ExplosionInteraction.BLOCK);
        }
        ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItem.LUMINARCHY.get()));
        level.addFreshEntity(itemEntity);
        super.onRemove(state, level, pos, newState, isMoving);
    }
}
