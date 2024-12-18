package net.anvian.create_unbreakable.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ModConfigs {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue LUMINARCHY_EXPLOSION_AT_BREAK = BUILDER.define("luminarchy_explosion_at_break", true);
    private static final ForgeConfigSpec.BooleanValue PHILOLITE_EXPLOSION_AT_BREAK = BUILDER.define("philolite_explosion_at_break", true);

    public static boolean luminarchyExplosionAtBreak;
    public static boolean philoliteExplosionAtBreak;

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);

        luminarchyExplosionAtBreak = LUMINARCHY_EXPLOSION_AT_BREAK.get();
        philoliteExplosionAtBreak = PHILOLITE_EXPLOSION_AT_BREAK.get();
    }
}
