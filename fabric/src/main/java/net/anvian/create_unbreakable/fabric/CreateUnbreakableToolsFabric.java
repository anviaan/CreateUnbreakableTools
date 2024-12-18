package net.anvian.create_unbreakable.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.anvian.create_unbreakable.CreateUnbreakableToolsMod;
import net.anvian.create_unbreakable.block.ModBlock;
import net.anvian.create_unbreakable.config.ModConfigs;
import net.anvian.create_unbreakable.fabric.registry.ModWorld;
import net.anvian.create_unbreakable.item.ModItem;
import net.anvian.create_unbreakable.item.tab.ModGroup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraftforge.api.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class CreateUnbreakableToolsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        CreateUnbreakableToolsMod.init();
        CreateUnbreakableToolsMod.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a Fabric client!",
                () -> () -> "{} is accessing Porting Lib on a Fabric server!"
                ), CreateUnbreakableToolsMod.NAME);

        ModLoadingContext.registerConfig(CreateUnbreakableToolsMod.MOD_ID, ModConfig.Type.SERVER, ModConfigs.SPEC, CreateUnbreakableToolsMod.MOD_ID + "-config.toml");
        ModConfigs.loadConfig(ModConfigs.SPEC, FabricLoader.getInstance().getConfigDir().resolve(CreateUnbreakableToolsMod.MOD_ID + "-config.toml"));

        ModGroup.REGISTRATE.register();
        ModItem.REGISTRATE.register();
        ModBlock.REGISTRATE.register();

        ModWorld.register();
    }
}
