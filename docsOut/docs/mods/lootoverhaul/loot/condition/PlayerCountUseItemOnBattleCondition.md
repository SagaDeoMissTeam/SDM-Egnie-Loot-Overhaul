# PlayerCountUseItemOnBattleCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.PlayerCountUseItemOnBattleCondition;
```


## Extending LootCondition

PlayerCountUseItemOnBattleCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in PlayerCountUseItemOnBattleCondition

## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// PlayerCountUseItemOnBattleCondition.getPriority() as int

myPlayerCountUseItemOnBattleCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// PlayerCountUseItemOnBattleCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myPlayerCountUseItemOnBattleCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
PlayerCountUseItemOnBattleCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
PlayerCountUseItemOnBattleCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


