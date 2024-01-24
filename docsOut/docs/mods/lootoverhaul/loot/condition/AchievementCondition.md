# AchievementCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.AchievementCondition;
```


## Extending LootCondition

AchievementCondition extends [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition). That means all methods available in [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) are also available in AchievementCondition

## Constructors


```zenscript
new AchievementCondition(advancement as ResourceLocation, property as LootProperty) as AchievementCondition
```
|  Parameter  |                            Type                            |
|-------------|------------------------------------------------------------|
| advancement | [ResourceLocation](/vanilla/api/resource/ResourceLocation) |
| property    | [LootProperty](/mods/lootoverhaul/loot/LootProperty)       |



## Methods

:::group{name=getPriority}

Return Type: int

```zenscript
// AchievementCondition.getPriority() as int

myAchievementCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// AchievementCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myAchievementCondition.getSide();
```

:::

:::group{name=isConditionSuccess}

Return Type: boolean

```zenscript
AchievementCondition.isConditionSuccess(event as Event) as boolean
```

| Parameter |              Type               |
|-----------|---------------------------------|
| event     | [Event](/forge/api/event/Event) |


:::

:::group{name=setPriority}

```zenscript
AchievementCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


