package net.sdm.sdm_rpg.core;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class Constants {

    public static final Path SDM_ENGINE = FMLPaths.CONFIGDIR.get().resolve("SDMEngine");
    public static final Path LOG_FOLDER = SDM_ENGINE.resolve("logs");
    public static final Path LOG_FILE = LOG_FOLDER.resolve("LootOverhaul.log");

    public static final Path LOOT_OVERHAUL_FOLDER = FMLPaths.CONFIGDIR.get().resolve("SDMEngine").resolve("LootOverhaul");
    public static final Path CONFIG_FOLDER = LOOT_OVERHAUL_FOLDER.resolve("config");
    public static final Path COMMON_CONFIG = CONFIG_FOLDER.resolve("common.toml");

    public static final Path PROPERTY_FOLDER = LOOT_OVERHAUL_FOLDER.resolve("condition");

    public static final Path OLD_CONDITIONS_FOLDER = LOOT_OVERHAUL_FOLDER.resolve("old_conditions");
}
