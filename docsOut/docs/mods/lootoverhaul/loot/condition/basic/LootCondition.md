# LootCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.basic.LootCondition;
```


## Implemented Interfaces
LootCondition implements the following interfaces. That means all methods defined in these interfaces are also available in LootCondition

- [ICondition](/mods/lootoverhaul/loot/condition/basic/ICondition)&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt;

## Constructors


```zenscript
new LootCondition() as LootCondition
new LootCondition();
```

```zenscript
new LootCondition(parent as LootProperty, side as mods.sdmrpg.loot.condition.side.ConditionSide) as LootCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| parent    | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// LootCondition.getPriority() as int

myLootCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// LootCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myLootCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
LootCondition.isConditionSuccess(entity as Entity) as boolean
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| entity    | [Entity](/vanilla/api/entity/Entity) |


:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
LootCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
LootCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


