package net.sdm.sdm_rpg;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.Constants;
import net.sdm.sdm_rpg.core.config.ConfigInit;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.data.ISDMDataHelper;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.data.SDMLevelSavedData;
import net.sdm.sdm_rpg.core.data.parser.FilesParser;
import net.sdm.sdm_rpg.core.events.minecraft.EntityEvents;
import net.sdm.sdm_rpg.core.events.minecraft.LevelEvents;
import net.sdm.sdm_rpg.core.events.minecraft.PlayerEvents;
import net.sdm.sdm_rpg.core.logger.SDMLogger;
import net.sdm.sdm_rpg.core.register.SDMRegistries;
import org.slf4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SDMRPG.MODID)
public class SDMRPG {
    public static Path getFile() {
        return FMLPaths.CONFIGDIR.get().resolve("sdmrpg/").resolve("sdmrpg.snbt");
    }
    public static final String MODID = "sdm_rpg";
    public static final SDMLogger LOGGER = new SDMLogger("LootOverhaul", Constants.LOG_FILE);

    public static List<String> REGISTER_ID = new ArrayList<>();

    public SDMRPG() {

        createFile();
        ConfigInit.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(SDMRegistries.class);
        MinecraftForge.EVENT_BUS.register(LevelEvents.class);
        MinecraftForge.EVENT_BUS.register(EntityEvents.class);
        MinecraftForge.EVENT_BUS.register(PlayerEvents.class);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStartingEvent);
        MinecraftForge.EVENT_BUS.addListener(this::realodListener);
        MinecraftForge.EVENT_BUS.addListener(this::onServerStoppingEvent);
        new LevelInfo().init();
    }


    public void realodListener(AddReloadListenerEvent event){
        event.addListener(new DataContainer());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {


//        SDMTest.init();
    }


    public void onServerStartingEvent(ServerStartingEvent event){
        LOGGER.sendInfo("Loading data from file !");
        if(event.getServer().overworld() != null) {
            LOGGER.sendInfo("Loading level data !");
            ServerLevel level = event.getServer().overworld();
            SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();
            LevelInfo.deserializeNBT(data.getData());
            LOGGER.sendInfo("Loaded level data !");
        }
//        LOGGER.sendInfo("Loading conditions !");
//        DataContainer.readFile();
//        LOGGER.sendInfo("Loaded conditions !");
//        LOGGER.sendInfo("Registered " + DataContainer.LOOT_PROPERTY.size() + " conditions !");
//        LOGGER.sendInfo("Registered " +    DataContainer.BLOCKS_PROPERTY.size() + " block conditions !");
//        LOGGER.sendInfo("Registered " + DataContainer.ENTITY_PROPERTY.size() + " entity conditions !");
//        LOGGER.sendInfo("Registered " + DataContainer.CHEST_PROPERTY.size() + " chest conditions !");
//        LOGGER.sendInfo("Registered " + DataContainer.FISH_PROPERTY.size() + " fishing conditions !");
    }

    public void onServerStoppingEvent(ServerStoppingEvent event){

        if(!DataContainer.LOOT_PROPERTY.isEmpty()) {
            DataContainer.serialize();
//            SNBT.write(getFile(), DataContainer.serialize());
        }

        if(event.getServer().overworld() != null){
            ServerLevel level = event.getServer().overworld();
            SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();
            data.updateData(LevelInfo.serializeNBT());
        }
    }



    protected void createFile(){
        FilesParser.readFiles();
        if(!Constants.CONFIG_FOLDER.toFile().exists()){
            Constants.CONFIG_FOLDER.toFile().mkdirs();
        }
        if(!Constants.PROPERTY_FOLDER.toFile().exists()){
            Constants.PROPERTY_FOLDER.toFile().mkdirs();
        }
        if(!Constants.OLD_CONDITIONS_FOLDER.toFile().exists()){
            Constants.OLD_CONDITIONS_FOLDER.toFile().mkdirs();
        }
        if(!Constants.LOG_FOLDER.toFile().exists()){
            Constants.LOG_FOLDER.toFile().mkdirs();
        }
        if(!LOGGER.isExist()){
            LOGGER.createFile();
        }

        if(LOGGER.isExist()){
            LOGGER.sendInfo("Thanks for downloading this mod ^_^");
        }
    }
}
