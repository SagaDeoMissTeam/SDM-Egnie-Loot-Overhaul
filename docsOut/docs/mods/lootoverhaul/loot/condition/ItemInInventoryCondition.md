# ItemInInventoryCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.ItemInInventoryCondition;
```


## Extending LootCondition

ItemInInventoryCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in ItemInInventoryCondition

## Constructors


```zenscript
new ItemInInventoryCondition(stack as ItemStack, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as ItemInInventoryCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| stack     | [ItemStack](/vanilla/api/item/ItemStack)             |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// ItemInInventoryCondition.getPriority() as int

myItemInInventoryCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// ItemInInventoryCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myItemInInventoryCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
ItemInInventoryCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
ItemInInventoryCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


