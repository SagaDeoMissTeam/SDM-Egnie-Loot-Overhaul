# BiomeCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.BiomeCondition;
```


## Extending LootCondition

BiomeCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in BiomeCondition

## Constructors


```zenscript
new BiomeCondition(biome as ResourceLocation, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as BiomeCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| biome     | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide              |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// BiomeCondition.getPriority() as int

myBiomeCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// BiomeCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myBiomeCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
BiomeCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
BiomeCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


