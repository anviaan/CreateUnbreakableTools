package net.anvian.create_unbreakable.config;

import net.anvian.anvianslib.config.Config;
import org.slf4j.Logger;

public class ModConfigs extends Config<ModConfigs.CreateUnbreakableConfig> {

    public ModConfigs(Class<CreateUnbreakableConfig> configClass, Logger logger) {
        super(configClass, logger);
    }

    @Override
    protected CreateUnbreakableConfig createDefaultConfig() {
        return new CreateUnbreakableConfig();
    }

    public static class CreateUnbreakableConfig {
        public boolean luminarchyExplosionAtBreak;
        public boolean philoliteExplosionAtBreak;
        public boolean apply_on_mending;

        CreateUnbreakableConfig() {
            this.luminarchyExplosionAtBreak = true;
            this.philoliteExplosionAtBreak = true;
            this.apply_on_mending = true;
        }
    }
}