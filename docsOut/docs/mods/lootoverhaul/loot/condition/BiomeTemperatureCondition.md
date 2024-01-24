# BiomeTemperatureCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.BiomeTemperatureCondition;
```


## Extending LootCondition

BiomeTemperatureCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in BiomeTemperatureCondition

## Constructors


```zenscript
new BiomeTemperatureCondition(num as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as BiomeTemperatureCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new BiomeTemperatureCondition(min as int, max as int, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as BiomeTemperatureCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| min       | int                                                  |
| max       | int                                                  |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// BiomeTemperatureCondition.getPriority() as int

myBiomeTemperatureCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// BiomeTemperatureCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myBiomeTemperatureCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
BiomeTemperatureCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
BiomeTemperatureCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


