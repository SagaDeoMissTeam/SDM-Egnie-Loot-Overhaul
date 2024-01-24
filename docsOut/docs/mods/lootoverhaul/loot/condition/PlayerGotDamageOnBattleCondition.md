# PlayerGotDamageOnBattleCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerGotDamageOnBattleCondition;
```


## Extending LootCondition

PlayerGotDamageOnBattleCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerGotDamageOnBattleCondition

## Constructors


```zenscript
new PlayerGotDamageOnBattleCondition(property as LootProperty) as PlayerGotDamageOnBattleCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerGotDamageOnBattleCondition(num as int, property as LootProperty) as PlayerGotDamageOnBattleCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerGotDamageOnBattleCondition(min as int, max as int, property as LootProperty) as PlayerGotDamageOnBattleCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| min       | int                                                  |
| max       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerGotDamageOnBattleCondition.getPriority() as int

myPlayerGotDamageOnBattleCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerGotDamageOnBattleCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerGotDamageOnBattleCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerGotDamageOnBattleCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerGotDamageOnBattleCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


