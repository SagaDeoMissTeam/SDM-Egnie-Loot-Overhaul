package net.sdm.sdm_rpg.core.loot.result;

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
    public Class<? extends ILootResult> result;
    LootResultList(Class<? extends ILootResult> result){
        this.result = result;
    }
}
