package net.anvian.create_unbreakable.block;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.anvian.create_unbreakable.CreateUnbreakableToolsMod;
import net.anvian.create_unbreakable.block.custom.LuminarchyBlock;
import net.anvian.create_unbreakable.block.custom.PhiloliteBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("unused")
public class ModBlock {
    public static final CreateRegistrate REGISTRATE = CreateUnbreakableToolsMod.REGISTRATE;

    public static final BlockEntry<PhiloliteBlock> PHILOLITE_BLOCK = REGISTRATE.block(
                    "philolite_block", PhiloliteBlock::new)
            .simpleItem()
            .register();

    public static final BlockEntry<LuminarchyBlock> LUMINARCHY_BLOCK = REGISTRATE.block(
                    "luminarchy_block", LuminarchyBlock::new)
            .properties(p -> p.lightLevel((state) -> 3).hasPostProcess(ModBlock::always).emissiveRendering(ModBlock::always))
            .simpleItem()
            .register();

    public static void init() {
        CreateUnbreakableToolsMod.LOGGER.info("Registering blocks for " + CreateUnbreakableToolsMod.NAME);
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }
}
