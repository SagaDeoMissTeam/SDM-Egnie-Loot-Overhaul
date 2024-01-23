package net.sdm.sdm_rpg.core.config;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.sdm.sdm_rpg.core.Constants;

public class ConfigInit {

    public static void init(){

        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON,
                CommonConfig.SPEC
        );
        CommonConfig.init(Constants.COMMON_CONFIG);

//        ModLoadingContext.get().registerConfig(
//                ModConfig.Type.COMMON,
//                ConfigCommon.SPEC
//        );
//        ConfigCommon.init(path.resolve(SDMBestiary.MODID + "-common.toml"));
    }
}
