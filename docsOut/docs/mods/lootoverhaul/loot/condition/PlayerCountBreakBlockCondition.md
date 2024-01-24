# PlayerCountBreakBlockCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerCountBreakBlockCondition;
```


## Extending LootCondition

PlayerCountBreakBlockCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerCountBreakBlockCondition

## Constructors


```zenscript
new PlayerCountBreakBlockCondition(block as Block, num as int, property as LootProperty) as PlayerCountBreakBlockCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| block     | [Block](/vanilla/api/block/Block)                    |
| num       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



```zenscript
new PlayerCountBreakBlockCondition(block as Block, min as int, max as int, property as LootProperty) as PlayerCountBreakBlockCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| block     | [Block](/vanilla/api/block/Block)                    |
| min       | int                                                  |
| max       | int                                                  |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerCountBreakBlockCondition.getPriority() as int

myPlayerCountBreakBlockCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerCountBreakBlockCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerCountBreakBlockCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerCountBreakBlockCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerCountBreakBlockCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


