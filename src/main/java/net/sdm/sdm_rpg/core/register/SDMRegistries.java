package net.sdm.sdm_rpg.core.register;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;
import net.sdm.sdm_rpg.SDMRPG;
import net.sdm.sdm_rpg.core.loot.condition.basic.LootCondition;

import java.util.function.Supplier;
@Mod.EventBusSubscriber(modid = SDMRPG.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SDMRegistries {

    public static final Supplier<IForgeRegistry<LootCondition>> MODULES_REGISTRY =
            ConditionRegister.REGISTRY.makeRegistry(RegistryBuilder::new);



    @SubscribeEvent
    public static void registerRegistries(NewRegistryEvent event) {
        createRegistry(event, ConditionRegister.REGISTRY_ID);
    }

    private static <T> void createRegistry(NewRegistryEvent event, ResourceLocation id) {
        event.create(new RegistryBuilder<T>().setName(id));
    }
}
