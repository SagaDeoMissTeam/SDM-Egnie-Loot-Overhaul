# PlayerCountOnThisDimensionCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerCountOnThisDimensionCondition;
```


## Extending LootCondition

PlayerCountOnThisDimensionCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerCountOnThisDimensionCondition

## Constructors


```zenscript
new PlayerCountOnThisDimensionCondition(dimension as ResourceLocation, num as int, property as LootProperty) as PlayerCountOnThisDimensionCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| dimension | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| num       | int                                                        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



```zenscript
new PlayerCountOnThisDimensionCondition(dimension as ResourceLocation, min as int, max as int, property as LootProperty) as PlayerCountOnThisDimensionCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| dimension | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| min       | int                                                        |
| max       | int                                                        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerCountOnThisDimensionCondition.getPriority() as int

myPlayerCountOnThisDimensionCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerCountOnThisDimensionCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerCountOnThisDimensionCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerCountOnThisDimensionCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerCountOnThisDimensionCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


