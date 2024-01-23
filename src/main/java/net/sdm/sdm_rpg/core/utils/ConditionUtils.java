package net.sdm.sdm_rpg.core.utils;

import net.minecraft.nbt.CompoundTag;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootResult;
import net.sdm.sdm_rpg.core.loot.condition.property.IProperty;
import net.sdm.sdm_rpg.core.loot.result.ILootResult;
import net.sdm.sdm_rpg.core.loot.result.LootResultList;
import net.sdm.sdm_rpg.core.loot.type.LootType;
import net.sdm.sdm_rpg.core.loot.type.LootTypeList;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class ConditionUtils {


    public static @Nullable LootType createType(CompoundTag tag){
        String type = "";
        if(tag.contains("type")) type = tag.getString("type");
        if(type.isEmpty()) return null;
        LootTypeList cd = LootTypeList.valueOf(type);
        try {
            Class<?> cls = cd.loot;
            Constructor<?> constructor = cls.getConstructor();
            LootType obj = (LootType) constructor.newInstance(new Object[]{});
            obj.deserializeNBT(tag);
            return obj;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | StackOverflowError e) {}
        return null;
    }

    public static @Nullable LootCondition createCondition(CompoundTag tag, LootProperty property){
        String type = "";
        if(tag.contains("type")) type = tag.getString("type");
        if(type.isEmpty()) return null;
        ConditionsList cd = ConditionsList.valueOf(type);
        try {
            Class<?> cls = cd.condition;
            Constructor<?> constructor = cls.getConstructor();
            LootCondition obj = (LootCondition) constructor.newInstance(new Object[]{});
            obj.parent = property;
            obj.deserializeNBT(tag);
            return obj;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | StackOverflowError e) {}
        return null;
    }

    public static @Nullable ILootResult createLootResult(CompoundTag tag){
        String type = "";
        if(tag.contains("type")) type = tag.getString("type");
        if(type.isEmpty()) return null;
        LootResultList cd = LootResultList.valueOf(type);
        try {
            Class<?> cls = cd.result;
            Constructor<?> constructor = cls.getConstructor();
            ILootResult obj = (ILootResult) constructor.newInstance(new Object[]{});
            obj.deserializeNBT(tag);
            return obj;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | StackOverflowError e) {}
        return null;
    }

    public static @Nullable IProperty createProperty(CompoundTag tag){
        return null;
    }


    public static String generateID(){
        String ID = "NULL";
        boolean t = true;
        while (t)
        {
            int leght = 8;
            String valid = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
            StringBuilder res = new StringBuilder();
            Random rnd = new Random();
            while (0 < leght--)
            {
                res.append(valid.charAt(rnd.nextInt(valid.length())));
            }

            ID = res.toString();

            if (ID != "NULL" && !SDMRPG.REGISTER_ID.contains("V_" + ID)) t = false;
        }
        return "V_" + ID;
    }
}
