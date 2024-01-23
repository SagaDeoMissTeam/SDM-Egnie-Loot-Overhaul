package net.sdm.sdm_rpg.core.loot.condition.property;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.List;

public class ListProperty<T extends IProperty> implements IProperty {

    public List<T> list;

    public ListProperty(List<T> list){
        this.list = list;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();
        ListTag nbt = new ListTag();
        list.forEach(tag -> {
            nbt.add(tag.serializeNBT());
        });
        compoundTag.put("list", nbt);
        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        ListTag tags = nbt.getList("list", Tag.TAG_COMPOUND);
        tags.forEach(s -> {

        });
    }
}
