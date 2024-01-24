# DimensionCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.DimensionCondition;
```


## Extending LootCondition

DimensionCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in DimensionCondition

## Constructors


```zenscript
new DimensionCondition(dimension as ResourceLocation, property as LootProperty) as DimensionCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| dimension | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// DimensionCondition.getPriority() as int

myDimensionCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// DimensionCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myDimensionCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
DimensionCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
DimensionCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


