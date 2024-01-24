# LootFunction

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.basic.LootFunction;
```


## Extending LootCondition

LootFunction extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in LootFunction

## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// LootFunction.getPriority() as int

myLootFunction.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// LootFunction.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myLootFunction.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
LootFunction.isConditionSuccess(entity as Entity) as boolean
```

| Parameter |                 Type                 |
|-----------|--------------------------------------|
| entity    | [Entity](/vanilla/api/entity/Entity) |


:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
LootFunction.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
LootFunction.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


