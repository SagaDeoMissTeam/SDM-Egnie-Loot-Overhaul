package net.sdm.sdm_rpg.core.loot.costructor;

import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;

public class SingleConstructor<T> extends LootConstructor {

    public T obj;
    public SingleConstructor(T obj){
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
