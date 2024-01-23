package net.sdm.sdm_rpg.core.utils.snbt;

import com.google.common.collect.Sets;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.stream.IntStream;

public class NBTUtils {

    public NBTUtils() {
    }

    public static MobEffectInstance readMobEffectInstance(CompoundTag nbt, String key){
        return new MobEffectInstance(
                ForgeRegistries.MOB_EFFECTS.getValue(NBTUtils.readResourceLocation(nbt,"id")),
                nbt.getInt("duration"),
                nbt.getInt("amplifier"),
                nbt.getBoolean("ambient"),
                nbt.getBoolean("visible"),
                nbt.getBoolean("showIcon")
        );
    }

    public static void writeMobEffectInstance(CompoundTag nbt, String key, MobEffectInstance effect){
        NBTUtils.writeResourceLocation(nbt, "id", ForgeRegistries.MOB_EFFECTS.getKey(effect.getEffect()));
        nbt.putInt("amplifier", effect.getAmplifier());
        nbt.putInt("duration", effect.getDuration());
        nbt.putBoolean("ambient", effect.isAmbient());
        nbt.putBoolean("visible", effect.isVisible());
        nbt.putBoolean("showIcon", effect.showIcon());

    }

    public static ResourceLocation readResourceLocation(CompoundTag nbt, String key){
        return new ResourceLocation(nbt.getString(key));
    }

    public static void writeResourceLocation(CompoundTag nbt, String key, ResourceLocation rs){
        nbt.putString(key, rs.getNamespace() + ":" + rs.getPath());
    }

    public static EntityType<?> readEntity(CompoundTag nbt, String key){
        return ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(nbt.getString(key)));
    }
    public static void writeEntity(CompoundTag nbt, String key, EntityType<?> entityType){
        nbt.putString(key, ForgeRegistries.ENTITY_TYPES.getKey(entityType).getNamespace() + ":" + ForgeRegistries.ENTITY_TYPES.getKey(entityType).getPath());
    }

    public static ItemStack readItem(CompoundTag nbt, String key) {
        Tag nbt1 = nbt.get(key);
        if (nbt1 instanceof CompoundTag) {
            return MissingItem.readItem((CompoundTag)nbt1);
        } else if (nbt1 instanceof StringTag) {
            CompoundTag nbt2 = new CompoundTag();
            nbt2.putString("id", nbt1.getAsString());
            nbt2.putByte("Count", (byte)1);
            return MissingItem.readItem(nbt2);
        } else {
            return ItemStack.EMPTY;
        }
    }

    public static void writeItem(CompoundTag nbt, String key, ItemStack stack) {
        if (!stack.isEmpty()) {
            CompoundTag nbt1 = MissingItem.writeItem(stack);
            if (nbt1.size() == 2 && nbt1.getInt("Count") == 1) {
                nbt.putString(key, nbt1.getString("id"));
            } else {
                nbt.put(key, nbt1);
            }
        }

    }

    public static boolean compareNbt(@Nullable Tag tagA, @Nullable Tag tagB, boolean fuzzy, boolean compareLists) {
        if (tagA == tagB) {
            return true;
        } else if (tagA == null) {
            return true;
        } else if (tagB == null) {
            return false;
        } else if (!tagA.getType().equals(tagB.getType())) {
            return false;
        } else {
            if (tagA instanceof CompoundTag) {
                CompoundTag compoundA = (CompoundTag)tagA;
                if (tagB instanceof CompoundTag) {
                    CompoundTag compoundB = (CompoundTag)tagB;
                    Set<String> keysA = compoundA.getAllKeys();
                    Set<String> keysB = compoundB.getAllKeys();
                    if (fuzzy || keysA.size() == keysB.size() && Sets.intersection(keysA, keysB).size() == keysA.size()) {
                        return keysA.stream().allMatch((key) -> {
                            return compareNbt(compoundA.get(key), compoundB.get(key), fuzzy, compareLists);
                        });
                    }

                    return false;
                }
            }

            if (compareLists && tagA instanceof ListTag) {
                ListTag listA = (ListTag)tagA;
                if (tagB instanceof ListTag) {
                    ListTag listB = (ListTag)tagB;
                    if (listA.isEmpty()) {
                        return listB.isEmpty();
                    }

                    if (listA.size() != listB.size()) {
                        return false;
                    }

                    return IntStream.range(0, listA.size()).allMatch((i) -> {
                        return compareNbt(listA.get(i), listB.get(i), fuzzy, true);
                    });
                }
            }

            return tagA.equals(tagB);
        }
    }
}
