package net.sdm.sdm_rpg.core.data;

import dev.ftb.mods.ftblibrary.snbt.SNBT;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.Constants;
import net.sdm.sdm_rpg.core.data.parser.FilesParser;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.type.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DataContainer extends SimplePreparableReloadListener<Void> {

    public static List<LootProperty> LOOT_PROPERTY = new ArrayList<>();
    public static List<LootProperty> LOOT_FROM_SCRIPTS = new ArrayList<>();
    public static List<LootProperty> LOOT_FROM_FILE = new ArrayList<>();

    public static List<LootProperty> BLOCKS_PROPERTY = new ArrayList<>();
    public static List<LootProperty> ENTITY_PROPERTY = new ArrayList<>();
    public static List<LootProperty> CHEST_PROPERTY = new ArrayList<>();
    public static List<LootProperty> FISH_PROPERTY = new ArrayList<>();
    public static List<LootProperty> TABLE_PROPERTY = new ArrayList<>();

    public static List<LootProperty> TEST = new ArrayList<>();
    @Override
    protected Void prepare(ResourceManager p_10796_, ProfilerFiller p_10797_) {
        return null;
    }

    @Override
    protected void apply(Void p_10793_, ResourceManager p_10794_, ProfilerFiller p_10795_) {
        //TODO : Добавить RELOAD
        SDMRPG.LOGGER.sendInfo("Start Reloading !");
        DataContainer.LOOT_PROPERTY.clear();
        DataContainer.BLOCKS_PROPERTY.clear();
        DataContainer.ENTITY_PROPERTY.clear();
        DataContainer.CHEST_PROPERTY.clear();
        DataContainer.FISH_PROPERTY.clear();
        SDMRPG.LOGGER.sendInfo("Loading conditions !");
        DataContainer.readFile();
        SDMRPG.LOGGER.sendInfo("Loaded conditions !");
        SDMRPG.LOGGER.sendInfo("Registered " + DataContainer.LOOT_PROPERTY.size() + " conditions !");
        SDMRPG.LOGGER.sendInfo("Registered " +    DataContainer.BLOCKS_PROPERTY.size() + " block conditions !");
        SDMRPG.LOGGER.sendInfo("Registered " + DataContainer.ENTITY_PROPERTY.size() + " entity conditions !");
        SDMRPG.LOGGER.sendInfo("Registered " + DataContainer.CHEST_PROPERTY.size() + " chest conditions !");
        SDMRPG.LOGGER.sendInfo("Registered " + DataContainer.FISH_PROPERTY.size() + " fishing conditions !");
        SDMRPG.LOGGER.sendInfo("Reloaded !");


    }


    public static CompoundTag serialize(){
        CompoundTag nbt = new CompoundTag();
        ListTag tags = new ListTag();
        LOOT_PROPERTY.forEach(loot -> {
            if(!LOOT_FROM_SCRIPTS.contains(loot)) {
                createFile(loot.serializeNBT(), loot.id, loot);
                tags.add(loot.serializeNBT());
            }
        });
        nbt.put("loot_property", tags);
        return nbt;
    }

    public static void sort(){
        for (LootProperty property : LOOT_PROPERTY) {
            if(property.type.getType() == LootTypeList.BLOCK) BLOCKS_PROPERTY.add(property);
            if(property.type.getType() == LootTypeList.ENTITY) ENTITY_PROPERTY.add(property);
            if(property.type.getType() == LootTypeList.CHEST) CHEST_PROPERTY.add(property);
            if(property.type.getType() == LootTypeList.FISHING) FISH_PROPERTY.add(property);
            if(property.type.getType() == LootTypeList.TABLE) TABLE_PROPERTY.add(property);
        }
    }

    public static void deserialize(CompoundTag nbt, String fileName){
//        ListTag tags = nbt.getList("loot_property", Tag.TAG_COMPOUND);
//        tags.forEach(loot -> {
//            LootProperty p = new LootProperty();
//            p.deserializeNBT((CompoundTag) loot);
//            LOOT_PROPERTY.add(p);
//        });

        LootProperty p = new LootProperty();
        p.deserializeNBT(nbt);
        p.fileName = fileName;
        LOOT_PROPERTY.add(p);
        LOOT_FROM_FILE.add(p);
    }

    public static void createFile(CompoundTag nbt, String ID, LootProperty type){
        Path file = Constants.PROPERTY_FOLDER;
        if(type.type instanceof LootBlockType){
            file = file.resolve("block");
        }
        if(type.type instanceof LootChestType){
            file = file.resolve("chest");
        }
        if(type.type instanceof LootEntityType){
            file = file.resolve("entity");
        }
        if(type.type instanceof LootFishingType){
            file = file.resolve("fishing");
        }
        if(type.type instanceof LootTableType){
            file = file.resolve("table");
        }

        if(!file.toFile().exists()){
            file.toFile().mkdirs();
        }

        file = file.resolve(!type.fileName.isEmpty() ? type.fileName : type.id + ".snbt");
        SNBT.write(file, nbt);
    }

    public static void readFile(){
        for (Path file : FilesParser.files) {
           CompoundTag tag = SNBT.read(file);
           if(tag != null){
               DataContainer.deserialize(tag, file.getFileName().toString());
           }
        }

        DataContainer.sort();
    }
}
