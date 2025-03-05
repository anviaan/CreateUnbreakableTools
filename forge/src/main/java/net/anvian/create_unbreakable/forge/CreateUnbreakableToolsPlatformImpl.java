package net.anvian.create_unbreakable.forge;

import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class CreateUnbreakableToolsPlatformImpl {
    public static String platformName() {
        return "Forge";
    }

    public static int getModGroupId() {
        return -1;
    }

    public static Path getConfigPath() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}
