package net.anvian.create_unbreakable;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class CreateUnbreakableToolsPlatform {
    @ExpectPlatform
    public static String platformName() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static Path getConfigPath() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isDevelopmentEnvironment() {
        throw new AssertionError();
    }
}
