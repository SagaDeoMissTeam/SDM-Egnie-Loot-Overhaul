package net.sdm.sdm_rpg.core.loot.condition.global;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.eventbus.api.Event;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootFunction;
import net.sdm.sdm_rpg.core.utils.ConditionUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ZenRegister
@Document("mods/lootoverhaul/loot/condition/global/OrCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.global.OrCondition")
public class OrCondition extends LootFunction {

    public List<LootCondition> conditionList = new ArrayList<>();

    public OrCondition(){
        super(null);
    }

    @ZenCodeType.Constructor
    public OrCondition(List<LootCondition> conditionList, LootProperty property){
        super(property);
        this.conditionList = conditionList;
    }

    @ZenCodeType.Method
    public OrCondition add(LootCondition lootConditionList){
        this.conditionList.add(lootConditionList);
        return this;
    }
    @ZenCodeType.Method
    public OrCondition add(List<LootCondition> lootConditionList){
        this.conditionList.addAll(lootConditionList);
        return this;
    }
    @ZenCodeType.Method
    public OrCondition add(LootCondition[] lootConditionList){
        this.conditionList.addAll(Arrays.stream(lootConditionList).toList());
        return this;
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.Or;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        int i = 0;
        for(LootCondition condition : conditionList){
            if(condition.isConditionSuccess(entity)) i++;
        }
        return i > 0;
    }

    @Override
    public boolean isConditionSuccess(Event event) {
        int i = 0;
        for(LootCondition condition : conditionList){
            if(condition.isConditionSuccess(event)) i++;
        }
        return i > 0;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag conditionTagList = new ListTag();
        for(LootCondition condition : conditionList){
            conditionTagList.add(condition.serializeNBT());
        }
        nbt.put("conditions", conditionTagList);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag conditionTagList = nbt.getList("conditions", Tag.TAG_COMPOUND);
        for(int i = 0; i < conditionTagList.size(); i++){
            conditionList.add(ConditionUtils.createCondition((CompoundTag) conditionTagList.get(i), parent));
        }
    }
}
