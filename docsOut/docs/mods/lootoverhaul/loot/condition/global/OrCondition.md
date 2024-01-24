# OrCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.global.OrCondition;
```


## Extending LootFunction

OrCondition extends [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction). That means all methods available in [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction) are also available in OrCondition

## Constructors


```zenscript
new OrCondition(conditionList as stdlib.List<LootCondition>, property as LootProperty) as OrCondition
```
|   Parameter   |                                           Type                                            |
|---------------|-------------------------------------------------------------------------------------------|
| conditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |
| property      | [LootProperty](/mods/lootoverhaul/loot/LootProperty)                                      |



## Methods

:::group{name=add}

Return Type: [OrCondition](/mods/lootoverhaul/loot/condition/global/OrCondition)

```zenscript
OrCondition.add(lootConditionList as LootCondition) as OrCondition
```

|     Parameter     |                                  Type                                  |
|-------------------|------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) |


:::

:::group{name=add}

Return Type: [OrCondition](/mods/lootoverhaul/loot/condition/global/OrCondition)

```zenscript
OrCondition.add(lootConditionList as LootCondition[]) as OrCondition
```

|     Parameter     |                                   Type                                   |
|-------------------|--------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)[] |


:::

:::group{name=add}

Return Type: [OrCondition](/mods/lootoverhaul/loot/condition/global/OrCondition)

```zenscript
OrCondition.add(lootConditionList as stdlib.List<LootCondition>) as OrCondition
```

|     Parameter     |                                           Type                                            |
|-------------------|-------------------------------------------------------------------------------------------|
| lootConditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |


:::

:::group{name=getPriority}

Return Type: int

```zenscript
// OrCondition.getPriority() as int

myOrCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// OrCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myOrCondition.getSide();
```

:::

:::group{name=setPriority}

```zenscript
OrCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


