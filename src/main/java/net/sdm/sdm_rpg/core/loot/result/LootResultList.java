package net.sdm.sdm_rpg.core.loot.result;


import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.BracketEnum;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@Document("mods/lootoverhaul/loot/condition/result/LootResultList")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.result.LootResultList")
@BracketEnum("lootoverhaul:lootresult")
public enum LootResultList {

    Attribute(AttributeResult.class),
    Command(CommandResult.class),
    Entity(EntityResult.class),
    GameStages(GameStagesResult.class),
    Item(ItemResult.class),
    Items(ItemResult.class),
    LootTable(LootTableResult.class),
    MobEffect(MobEffectResult.class),
    Quest(QuestResult.class),
    RandomItems(RandomItemsResult.class);
    @ZenCodeType.Field
    public Class<? extends ILootResult> result;
    LootResultList(Class<? extends ILootResult> result){
        this.result = result;
    }
}
