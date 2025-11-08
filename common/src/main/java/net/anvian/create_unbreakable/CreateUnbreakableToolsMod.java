package net.anvian.create_unbreakable;

import com.simibubi.create.foundation.data.CreateRegistrate;
import net.anvian.anvianslib.platform.Services;
import net.anvian.anvianslib.util.LibUtil;
import net.anvian.create_unbreakable.block.ModBlock;
import net.anvian.create_unbreakable.config.ModConfigs;
import net.anvian.create_unbreakable.item.ModItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUnbreakableToolsMod {
    public static final String MOD_ID = "create_unbreakable";
    public static final String NAME = "Create Unbreakable Tools Mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    public static ModConfigs configs = new ModConfigs(ModConfigs.CreateUnbreakableConfig.class, LOGGER);

    public static void init() {
        LOGGER.info("{} initializing!", NAME);

        configs.initialize(Services.PLATFORM.getConfigPath().resolve(MOD_ID).toFile(), MOD_ID);
        LibUtil.setupTelemetry(MOD_ID, "1.9");

        ModItem.init();
        ModBlock.init();
    }
}
