# EntityTimeInStructureCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityTimeInStructureCondition;
```


## Extending LootCondition

EntityTimeInStructureCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityTimeInStructureCondition

## Constructors


```zenscript
new EntityTimeInStructureCondition(num as int, structure as ResourceLocation, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityTimeInStructureCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| num       | int                                                        |
| structure | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide              |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



```zenscript
new EntityTimeInStructureCondition(min as int, max as int, structure as ResourceLocation, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityTimeInStructureCondition
```
| Parameter |                            Type                            |
|-----------|------------------------------------------------------------|
| min       | int                                                        |
| max       | int                                                        |
| structure | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide              |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityTimeInStructureCondition.getPriority() as int

myEntityTimeInStructureCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityTimeInStructureCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityTimeInStructureCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityTimeInStructureCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityTimeInStructureCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


