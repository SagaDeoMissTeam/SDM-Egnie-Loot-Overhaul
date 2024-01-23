package net.sdm.sdm_rpg.core.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class CommonConfig {
    public static void init(Path file)
    {
        final CommentedFileConfig configData = CommentedFileConfig.builder(file)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        SPEC.setConfig(configData);
    }
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_PETS_KILL_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_ITEMS_USE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_COUNT_USE_TOTEM_ON_BATTLE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_COUNT_USE_ITEM_ON_BATTLE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_COUNT_DAMAGE_GOT_ON_BATTLE_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_COMBO_KILL_ENTITY_TIME;
    public static final ForgeConfigSpec.ConfigValue<Integer> HISTORY_SEQUENCE_KILL_ENTITY_TIME;

    static {

        BUILDER.comment("Настройка времени очисти истории для каждого из журналов.");
        BUILDER.comment("Setting up the history clearing time for each of the logs.");
        BUILDER.push("HISTORY");

        BUILDER.comment("История убийств мобов приручёнными животными игрока");
        BUILDER.comment("The story of mobs being killed by the player's tamed animals");
        HISTORY_PETS_KILL_TIME = BUILDER.define("PETS_KILL", 50);

        BUILDER.comment("История использованных предметов во время битвы");
        BUILDER.comment("The history of the items used during the battle");
        HISTORY_ITEMS_USE_TIME = BUILDER.define("ITEMS_USE", 50);

        BUILDER.comment("История использования тотемов бессмертия во время битвы");
        BUILDER.comment("The history of the use of immortality totems during battle");
        HISTORY_COUNT_USE_TOTEM_ON_BATTLE_TIME = BUILDER.define("USE_TOTEM_ON_BATTLE", 50);

        BUILDER.comment("История использования предметов во время битвы");
        BUILDER.comment("The history of using items during the battle");
        HISTORY_COUNT_USE_ITEM_ON_BATTLE_TIME = BUILDER.define("USE_ITEM_ON_BATTLE", 50);

        BUILDER.comment("История полученного урона во время битвы");
        BUILDER.comment("The history of damage received during the battle");
        HISTORY_COUNT_DAMAGE_GOT_ON_BATTLE_TIME = BUILDER.define("DAMAGE_GOT_ON_BATTLE", 50);

        BUILDER.comment("История комбо убийств");
        BUILDER.comment("The history of combo murders");
        HISTORY_COMBO_KILL_ENTITY_TIME = BUILDER.define("COMBO_KILL_ENTITY", 50);

        BUILDER.comment("История последовательного убийства мобов");
        BUILDER.comment("The story of the sequential killing of mobs");
        HISTORY_SEQUENCE_KILL_ENTITY_TIME = BUILDER.define("SEQUENCE_KILL_ENTITY", 50);

        BUILDER.pop();
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
