package net.sdm.sdm_rpg.core.loot.type;

public enum LootTypeList {

    Block(LootBlock.class),
    ENTITY(LootEntityType.class),
    CHEST(LootChestType.class),
    FISHING(LootFishing.class);

    public Class<? extends LootType> loot;
    LootTypeList(Class<? extends LootType> loot){
        this.loot = loot;
    }
}
