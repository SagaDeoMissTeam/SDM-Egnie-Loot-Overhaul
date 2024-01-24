# EventLootCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.basic.EventLootCondition;
```


## Extending LootCondition

EventLootCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in EventLootCondition

## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// EventLootCondition.getPriority() as int

myEventLootCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// EventLootCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myEventLootCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
EventLootCondition.isConditionSuccess(entity as Entity) as boolean
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| entity    | [Entity](/vanilla/api/entity/Entity) |


:::

:::group{name=setPriority}

```zenscript
EventLootCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


