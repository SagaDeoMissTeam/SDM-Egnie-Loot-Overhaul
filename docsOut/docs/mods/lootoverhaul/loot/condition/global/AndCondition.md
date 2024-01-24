# AndCondition

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.global.AndCondition;
```


## Extending LootFunction

AndCondition extends [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction). That means all methods available in [LootFunction](/mods/lootoverhaul/loot/condition/basic/LootFunction) are also available in AndCondition

## Constructors


```zenscript
new AndCondition(conditionList as stdlib.List<LootCondition>, property as LootProperty) as AndCondition
```
|   Parameter   |                                           Type                                            |
|---------------|-------------------------------------------------------------------------------------------|
| conditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |
| property      | [LootProperty](/mods/lootoverhaul/loot/LootProperty)                                      |



## Methods

:::group{name=add}

Return Type: [AndCondition](/mods/lootoverhaul/loot/condition/global/AndCondition)

```zenscript
AndCondition.add(lootConditionList as LootCondition) as AndCondition
```

|     Parameter     |                                  Type                                  |
|-------------------|------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition) |


:::

:::group{name=add}

Return Type: [AndCondition](/mods/lootoverhaul/loot/condition/global/AndCondition)

```zenscript
AndCondition.add(lootConditionList as LootCondition[]) as AndCondition
```

|     Parameter     |                                   Type                                   |
|-------------------|--------------------------------------------------------------------------|
| lootConditionList | [LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)[] |


:::

:::group{name=add}

Return Type: [AndCondition](/mods/lootoverhaul/loot/condition/global/AndCondition)

```zenscript
AndCondition.add(lootConditionList as stdlib.List<LootCondition>) as AndCondition
```

|     Parameter     |                                           Type                                            |
|-------------------|-------------------------------------------------------------------------------------------|
| lootConditionList | stdlib.List&lt;[LootCondition](/mods/lootoverhaul/loot/condition/basic/LootCondition)&gt; |


:::

:::group{name=getPriority}

Return Type: int

```zenscript
// AndCondition.getPriority() as int

myAndCondition.getPriority();
```

:::

:::group{name=getSide}

Return Type: mods.sdmrpg.loot.condition.side.ConditionSide

```zenscript
// AndCondition.getSide() as mods.sdmrpg.loot.condition.side.ConditionSide

myAndCondition.getSide();
```

:::

:::group{name=setPriority}

```zenscript
AndCondition.setPriority(priority as int)
```

| Parameter | Type |
|-----------|------|
| priority  | int  |


:::


