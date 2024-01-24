package net.sdm.sdm_rpg.core.data;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.sdm.sdm_rpg.core.data.data.TimeInStructureData;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;



@ZenRegister
@Document("mods/lootoverhaul/data/LevelInfo")
@ZenCodeType.Name("mods.lootoverhaul.data.LevelInfo")
public class LevelInfo {

    public static LevelInfo INSTANCE;

    public static int countGrowingTree = 0;

    public static int countKillEnderDragon = 0;

    public static int countCreeperDetonation = 0;

    public static int countSkeletonsKillByEachOther = 0;

    public static int countPlayerSleepNight = 0;

    @ZenCodeType.Method
    public static int getCountGrowingTree() {
        return countGrowingTree;
    }
    @ZenCodeType.Method
    public static int getCountKillEnderDragon() {
        return countKillEnderDragon;
    }
    @ZenCodeType.Method
    public static int getCountPlayerSleepNight() {
        return countPlayerSleepNight;
    }
    @ZenCodeType.Method
    public static int getCountSkeletonsKillByEachOther() {
        return countSkeletonsKillByEachOther;
    }
    @ZenCodeType.Method
    public static int getCountCreeperDetonation() {
        return countCreeperDetonation;
    }


    //    @ZenCodeType.Field
    public static List<TimeInStructureData> timeInStructureData = new ArrayList<>();


    public static CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("countGrowingTree", countGrowingTree);
        tag.putInt("countKillEnderDragon", countKillEnderDragon);
        tag.putInt("creeperDetonation", countCreeperDetonation);
        tag.putInt("countSkeletonsKillByEachOther", countSkeletonsKillByEachOther);
        tag.putInt("countPlayerSleepNight", countPlayerSleepNight);
        ListTag timeST = new ListTag();
        for (int i = 0; i < timeInStructureData.size(); i++) {
           timeST.add(timeInStructureData.get(i).serializeNBT());
        }
//        tag.put("timeInStcuture", timeST);
        return tag;
    }

    public static void deserializeNBT(CompoundTag nbt) {
        countGrowingTree = nbt.getInt("countGrowingTree");
        countKillEnderDragon = nbt.getInt("countKillEnderDragon");
        countCreeperDetonation = nbt.getInt("creeperDetonation");
        countSkeletonsKillByEachOther = nbt.getInt("countSkeletonsKillByEachOther");
        countPlayerSleepNight = nbt.getInt("countPlayerSleepNight");
//        ListTag timeST = nbt.getList("timeInStcuture", Tag.TAG_COMPOUND);
//        for (int i = 0; i < timeST.size(); i++) {
//            TimeInStructureData it = new TimeInStructureData();
//            it.deserializeNBT(timeST.getCompound(i));
//            timeInStructureData.add(it);
//        }
    }

    public void init(){
        INSTANCE = this;
    }
}
