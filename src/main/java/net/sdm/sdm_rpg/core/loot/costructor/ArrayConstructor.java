package net.sdm.sdm_rpg.core.loot.costructor;

import java.util.List;

public class ArrayConstructor<T> extends LootConstructor{

    public List<T> obj;

    public ArrayConstructor(List<T> obj){
        this.obj = obj;
    }

    public List<T> getObj() {
        return obj;
    }

    public int size(){
        return obj.size();
    }
}
