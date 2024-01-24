# NotCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.global.NotCondition;
```


## Extending LootFunction

NotCondition extends [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction). That means all methods available in [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction) are also available in NotCondition

## Constructors


```zenscript
new NotCondition(condition as LootCondition, property as LootProperty) as NotCondition
```
| Parameter |                                  Type                                  |
|-----------|------------------------------------------------------------------------|
| condition | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty)                   |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// NotCondition.getPriority() as int

myNotCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// NotCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myNotCondition.getSide();
```

:::

:::group{name=setPriority}

```zenscript
NotCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


