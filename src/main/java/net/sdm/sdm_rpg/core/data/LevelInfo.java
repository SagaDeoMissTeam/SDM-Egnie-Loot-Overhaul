package net.sdm.sdm_rpg.core.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;
import net.sdm.sdm_rpg.core.data.data.TimeInStructureData;

import java.util.ArrayList;
import java.util.List;

public class LevelInfo {
    public static LevelInfo INSTANCE;
    public static int countGrowingTree = 0;
    public static int countKillEnderDragon = 0;
    public static int creeperDetonation = 0;
    public static int countSkeletonsKillByEachOther = 0;
    public static int countPlayerSleepNight = 0;

    public static List<TimeInStructureData> timeInStructureData = new ArrayList<>();


    public static CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("countGrowingTree", countGrowingTree);
        tag.putInt("countKillEnderDragon", countKillEnderDragon);
        tag.putInt("creeperDetonation", creeperDetonation);
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
        creeperDetonation = nbt.getInt("creeperDetonation");
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
