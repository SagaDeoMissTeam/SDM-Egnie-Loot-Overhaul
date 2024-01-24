# EntityIsUnderwaterCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.EntityIsUnderwaterCondition;
```


## Extending LootCondition

EntityIsUnderwaterCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EntityIsUnderwaterCondition

## Constructors


```zenscript
new EntityIsUnderwaterCondition(side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as EntityIsUnderwaterCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EntityIsUnderwaterCondition.getPriority() as int

myEntityIsUnderwaterCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EntityIsUnderwaterCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEntityIsUnderwaterCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EntityIsUnderwaterCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
EntityIsUnderwaterCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


