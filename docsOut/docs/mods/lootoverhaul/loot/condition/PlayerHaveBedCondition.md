# PlayerHaveBedCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerHaveBedCondition;
```


## Extending LootCondition

PlayerHaveBedCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerHaveBedCondition

## Constructors


```zenscript
new PlayerHaveBedCondition(property as LootProperty) as PlayerHaveBedCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerHaveBedCondition.getPriority() as int

myPlayerHaveBedCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerHaveBedCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerHaveBedCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerHaveBedCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerHaveBedCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


