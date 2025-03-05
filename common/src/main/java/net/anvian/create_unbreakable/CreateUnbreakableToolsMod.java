package net.anvian.create_unbreakable;

import com.simibubi.create.Create;
import net.anvian.anvianslib.config.TelemetryConfigManager;
import net.anvian.anvianslib.util.LibUtil;
import net.anvian.create_unbreakable.block.ModBlock;
import net.anvian.create_unbreakable.item.ModItem;
import net.anvian.create_unbreakable.item.tab.ModGroup;
import net.minecraft.SharedConstants;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUnbreakableToolsMod {
    public static final String MOD_ID = "create_unbreakable";
    public static final String NAME = "Create Unbreakable Tools Mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static final String CONFIG_FILE_NAME = CreateUnbreakableToolsMod.MOD_ID + "-config.toml";

    public static void init() {
        LOGGER.info("{} initializing! Create version: {} on platform: {}", NAME, Create.VERSION, CreateUnbreakableToolsPlatform.platformName());

        LibUtil.generateConfigPath(MOD_ID, CreateUnbreakableToolsPlatform.getConfigPath());

        TelemetryConfigManager.initialize(CreateUnbreakableToolsPlatform.getConfigPath().resolve(MOD_ID).toFile());
        if (TelemetryConfigManager.getConfig().enableTelemetry) {
            TelemetryConfigManager.sendTelemetryData(
                    MOD_ID,
                    "1.7",
                    SharedConstants.getCurrentVersion().getName(),
                    CreateUnbreakableToolsPlatform.platformName(),
                    !CreateUnbreakableToolsPlatform.isDevelopmentEnvironment()
            );
        }

        ModGroup.register();
        ModItem.init();
        ModBlock.init();
    }
}
