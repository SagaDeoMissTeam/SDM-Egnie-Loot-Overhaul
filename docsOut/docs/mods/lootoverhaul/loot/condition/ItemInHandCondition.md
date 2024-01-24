# ItemInHandCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.ItemInHandCondition;
```


## Extending LootCondition

ItemInHandCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in ItemInHandCondition

## Constructors


```zenscript
new ItemInHandCondition(stack as ItemStack, hand as InteractionHand, side as mods.sdmrpg.loot.condition.side.ConditionSide, property as LootProperty) as ItemInHandCondition
```
| Parameter |                         Type                         |
|-----------|------------------------------------------------------|
| stack     | [ItemStack](/vanilla/api/item/ItemStack)             |
| hand      | [InteractionHand](/vanilla/api/util/InteractionHand) |
| side      | mods.sdmrpg.loot.condition.side.ConditionSide        |
| property  | [LootProperty](/mods/lootoverhaul/loot/LootProperty) |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// ItemInHandCondition.getPriority() as int

myItemInHandCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// ItemInHandCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myItemInHandCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
ItemInHandCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
ItemInHandCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


