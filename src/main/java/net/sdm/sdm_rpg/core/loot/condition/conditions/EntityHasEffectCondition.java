package net.sdm.sdm_rpg.core.loot.condition.conditions;

import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker_annotations.annotations.Document;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.registries.ForgeRegistries;
import net.sdm.sdm_rpg.core.loot.LootProperty;
import net.sdm.sdm_rpg.core.loot.condition.basic.ConditionsList;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;
import net.sdm.sdm_rpg.core.loot.condition.side.ConditionSide;
import net.sdm.sdm_rpg.core.utils.snbt.NBTUtils;
import org.openzen.zencode.java.ZenCodeType;

import java.util.ArrayList;
import java.util.List;
@ZenRegister
@Document("mods/lootoverhaul/loot/condition/EntityHasEffectCondition")
@ZenCodeType.Name("mods.lootoverhaul.loot.condition.EntityHasEffectCondition")
public class EntityHasEffectCondition extends LootCondition {

    public List<MobEffect> effects = new ArrayList<>();
    public EntityHasEffectCondition(){}
    @ZenCodeType.Constructor
    public EntityHasEffectCondition(MobEffect effects, ConditionSide side, LootProperty property){
        super(property, side);
        this.effects.add(effects);
    }
    @ZenCodeType.Constructor
    public EntityHasEffectCondition(List<MobEffect> effects, ConditionSide side, LootProperty property){
        super(property, side);
        this.effects = effects;
    }

    @Override
    public boolean isConditionSuccess(Entity entity) {
        if(side == ConditionSide.ENTITY && entity instanceof LivingEntity livingEntity){
            for (int i = 0; i < effects.size(); i++){
                if(!livingEntity.hasEffect(effects.get(i))) return false;
            }
        }
        if(side == ConditionSide.PLAYER && entity instanceof Player player){
            for (int i = 0; i < effects.size(); i++){
                if(!player.hasEffect(effects.get(i))) return false;
            }
        }
        return super.isConditionSuccess(entity);
    }

    @Override
    public ConditionsList getType() {
        return ConditionsList.EntityHasEffect;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        ListTag tags = new ListTag();
        for(int i =0; i < effects.size(); i++){
            CompoundTag effectTag = new CompoundTag();
            MobEffect effect = effects.get(i);
            NBTUtils.writeResourceLocation(effectTag, "effectID", ForgeRegistries.MOB_EFFECTS.getKey(effect));
            tags.add(i, effectTag);
        }
        nbt.put("effects", tags);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        ListTag tags = nbt.getList("effects", Tag.TAG_COMPOUND);
        for(int i =0; i < tags.size(); i++){
            CompoundTag tag = (CompoundTag) tags.get(i);
            effects.add(ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(tag.getString("effectID"))));
        }
    }
}
