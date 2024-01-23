package net.sdm.sdm_rpg.core.events.minecraft;

import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sdm.sdm_rpg.core.config.CommonConfig;
import net.sdm.sdm_rpg.core.data.HistoryList;
import net.sdm.sdm_rpg.core.data.ISDMDataHelper;
import net.sdm.sdm_rpg.core.data.LevelInfo;
import net.sdm.sdm_rpg.core.data.SDMLevelSavedData;

public class LevelEvents {

    @SubscribeEvent
    public static void onSaplingGrowTreeEvent(SaplingGrowTreeEvent event){
        ServerLevel level = event.getLevel().getServer().overworld();
        SDMLevelSavedData data = ((ISDMDataHelper)level).sdm$saveData();

        if(!data.getData().contains("growingsapplingcount")){
            data.getData().putInt("growingsapplingcount", 1);
            LevelInfo.countGrowingTree = 1;
        }
        else {
            data.getData().putInt("growingsapplingcount", data.getData().getInt("growingsapplingcount")+1);
            LevelInfo.countGrowingTree++;
        }
    }

    @SubscribeEvent
    public static void onTickServer(TickEvent.LevelTickEvent event){
        if(event.level.getGameTime() % CommonConfig.HISTORY_PETS_KILL_TIME.get() == 0){
            HistoryList.clearPetHistory();
        }
        if(event.level.getGameTime() % CommonConfig.HISTORY_ITEMS_USE_TIME.get() == 0){
            HistoryList.clearItemHistory();
        }
        if(event.level.getGameTime() % CommonConfig.HISTORY_COUNT_USE_TOTEM_ON_BATTLE_TIME.get() == 0){
            HistoryList.clearTotemHistory();
        }
    }
}
