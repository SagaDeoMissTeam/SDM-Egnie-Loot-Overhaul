package net.sdm.sdm_rpg.core.loot.condition.basic;

public interface ICondition<T extends LootCondition>{


    public T createDefaultInstance();
}
