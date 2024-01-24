package net.sdm.sdm_rpg.core.loot;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.data.DataContainer;
import net.sdm.sdm_rpg.core.load.LoadType;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.result.ILootResult;
import net.sdm.sdm_rpg.core.loot.type.LootType;
import net.sdm.sdm_rpg.core.utils.ConditionUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ZenRegister
@Document("mods/lootoverhaul/loot/LootProperty")
@ZenCodeType.Name("mods.lootoverhaul.loot.LootProperty")
public class LootProperty implements INBTSerializable<CompoundTag> {


    public LoadType loadType = LoadType.NONE;
    @ZenCodeType.Field
    public LootType type;
    @ZenCodeType.Field
    public String id;
    public String fileName = "";
    @ZenCodeType.Field
    public List<ILootResult> lootResults = new ArrayList<>();
    @ZenCodeType.Field
    public List<LootCondition> lootConditionList = new ArrayList<>();
    public LootProperty(){}
    @ZenCodeType.Constructor
    public LootProperty(LootType type){
        this.type = type;
    }
    @ZenCodeType.Constructor
    public LootProperty(List<LootCondition> lootConditionList, LootType type){
        this.lootConditionList = lootConditionList;
        this.type = type;
    }

    @ZenCodeType.Method
    public LootProperty add(LootCondition lootConditionList){
        this.lootConditionList.add(lootConditionList);
        return this;
    }
    @ZenCodeType.Method
    public LootProperty add(List<LootCondition> lootConditionList){
        this.lootConditionList.addAll(lootConditionList);
        return this;
    }
    @ZenCodeType.Method
    public LootProperty add(LootCondition[] lootConditionList){
        this.lootConditionList.addAll(Arrays.stream(lootConditionList).toList());
        return this;
    }

    @ZenCodeType.Method
    public LootProperty add(ILootResult lootResult){
        this.lootResults.add(lootResult);
        return this;
    }
    @ZenCodeType.Method
    public LootProperty saveFile(){
        loadType = LoadType.FILE;
        return this;
    }

    @ZenCodeType.Method
    public void create(){
        if(loadType != LoadType.FILE) loadType = LoadType.CRAFTTWEAKER;
        id = ConditionUtils.generateID();
        SDMRPG.REGISTER_ID.add(id);

        if(loadType == LoadType.FILE || loadType == LoadType.NONE)
            DataContainer.LOOT_FROM_FILE.add(this);
        else
            DataContainer.LOOT_FROM_SCRIPTS.add(this);

        DataContainer.LOOT_PROPERTY.add(this);
    }

    public void createFile(){
        loadType = LoadType.FILE;
        id = ConditionUtils.generateID();
        SDMRPG.REGISTER_ID.add(id);
        DataContainer.LOOT_FROM_FILE.add(this);
        DataContainer.LOOT_PROPERTY.add(this);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        ListTag lootconditions = new ListTag();
        lootConditionList.forEach(s -> {
            lootconditions.add(s.serializeNBT());
        });
        ListTag lootResultsTag = new ListTag();
        lootResults.forEach(s -> {
            lootResultsTag.add(s.serializeNBT());
        });
        nbt.putString("id", id);
        if(!fileName.isEmpty()) nbt.putString("fileName", fileName);
        nbt.put("conditions", lootconditions);
        nbt.put("lootResults", lootResultsTag);
        nbt.put("type", type.serializeNBT());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ListTag lootconditions = nbt.getList("conditions", Tag.TAG_COMPOUND);
        ListTag lootResultsTag = nbt.getList("lootResults", Tag.TAG_COMPOUND);
        lootconditions.forEach(s -> {
            lootConditionList.add(ConditionUtils.createCondition((CompoundTag) s, this));
        });
        for (int i = 0; i < lootResultsTag.size(); i++) {
            lootResults.add(ConditionUtils.createLootResult(lootResultsTag.getCompound(i)));
        }
        id = nbt.getString("id");
        if(nbt.contains("fileName")) fileName = nbt.getString("fileName");
        SDMRPG.REGISTER_ID.add(id);
        type = ConditionUtils.createType(nbt.getCompound("type"));
    }


}
