package net.anvian.create_unbreakable.block.custom;

import net.anvian.create_unbreakable.config.ModConfigs;
import net.anvian.create_unbreakable.item.ModItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.Collections;
import java.util.List;

public class PhiloliteBlock extends EternalBlock {
    public PhiloliteBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && ModConfigs.philoliteExplosionAtBreak) {
            level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 3, false, Explosion.BlockInteraction.BREAK);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
        if (builder.getOptionalParameter(LootContextParams.TOOL).isCorrectToolForDrops(blockState)) {
            ItemStack tool = builder.getOptionalParameter(LootContextParams.TOOL);
            if (tool != null && tool.hasTag() && tool.getTag().contains("Enchantments")) {
                ListTag enchantments = tool.getTag().getList("Enchantments", 10);
                for (int i = 0; i < enchantments.size(); i++) {
                    CompoundTag enchantment = enchantments.getCompound(i);
                    if (enchantment.getString("id").equals("minecraft:silk_touch")) {
                        return Collections.singletonList(new ItemStack(this));
                    } else {
                        return Collections.singletonList(new ItemStack(ModItem.PHILOLITE.get()));
                    }
                }
            }
            return Collections.singletonList(new ItemStack(ModItem.PHILOLITE.get()));
        }
        return super.getDrops(blockState, builder);
    }
}
