package net.anvian.create_unbreakable.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class CreateUnbreakableToolsPlatformImpl {
	public static String platformName() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? "Quilt" : "Fabric";
	}

    public static Path getConfigPath() {
		return FabricLoader.getInstance().getConfigDir();
    }

	public static boolean isDevelopmentEnvironment() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}
}
