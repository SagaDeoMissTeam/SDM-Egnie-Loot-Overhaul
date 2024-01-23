package net.sdm.sdm_rpg.core.data;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;


import javax.annotation.Nonnull;

public class SDMLevelSavedData extends SavedData {


    private CompoundTag data;

    public SDMLevelSavedData() {

        this.data = new CompoundTag();
    }

    public SDMLevelSavedData(@Nonnull CompoundTag data) {

        this.data = data;
    }

    public static SDMLevelSavedData load(CompoundTag tag) {
        return new SDMLevelSavedData(tag);
    }


    public void updateData(CompoundTag data) {

        this.data.merge(data);
    }
    public CompoundTag getData(){
        return data;
    }

    @Override
    public @NotNull CompoundTag save(CompoundTag tag) {
        tag.merge(data);
        return tag;
    }

    @Override
    public boolean isDirty() {

        return true;
    }
}
