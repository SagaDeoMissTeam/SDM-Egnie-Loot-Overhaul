package net.sdm.sdm_rpg.core.register;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;

import java.util.List;

public class ConditionRegister {

    public static final ResourceLocation REGISTRY_ID =
            new ResourceLocation(SDMRPG.MODID, "conditions");


    public static final DeferredRegister<LootCondition> REGISTRY = DeferredRegister.create(REGISTRY_ID, SDMRPG.MODID);

    //public static final RegistryObject<LootCondition> ACHIEVEMENT = REGISTRY.register("achievement", AchievementCondition::new);


    public static List<LootCondition> conditionsList() {
        return SDMRegistries.MODULES_REGISTRY.get().getValues().stream()
                .map(LootCondition.class::cast)
                .toList();
    }
}
