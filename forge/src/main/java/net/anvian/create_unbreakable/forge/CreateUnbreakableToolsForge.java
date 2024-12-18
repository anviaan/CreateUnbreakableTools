package net.anvian.create_unbreakable.forge;

import net.anvian.create_unbreakable.CreateUnbreakableToolsMod;
import net.anvian.create_unbreakable.block.ModBlock;
import net.anvian.create_unbreakable.config.ModConfigs;
import net.anvian.create_unbreakable.forge.registry.ModGroup;
import net.anvian.create_unbreakable.item.ModItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(CreateUnbreakableToolsMod.MOD_ID)
public class CreateUnbreakableToolsForge {
    public CreateUnbreakableToolsForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ModConfigs.SPEC, CreateUnbreakableToolsMod.MOD_ID + "-config.toml");
        ModConfigs.loadConfig(ModConfigs.SPEC, FMLPaths.CONFIGDIR.get().resolve(CreateUnbreakableToolsMod.MOD_ID + "-config.toml"));

        ModItem.REGISTRATE.registerEventListeners(eventBus);
        ModBlock.REGISTRATE.registerEventListeners(eventBus);
        ModGroup.TABS.register(eventBus);
        CreateUnbreakableToolsMod.init();
    }
}
