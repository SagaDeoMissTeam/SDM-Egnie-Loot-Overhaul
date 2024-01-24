# MobEffectResult

## Importing the class

It might be required for you to import the package if you encounter any issues (like casting an Array), so better be safe than sorry and add the import at the very top of the file.
```zenscript
import mods.lootoverhaul.loot.condition.result.MobEffectResult;
```


## Extending ILootResult

MobEffectResult extends [ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult). That means all methods available in [ILootResult](/mods/lootoverhaul/loot/condition/result/ILootResult) are also available in MobEffectResult

## Constructors


```zenscript
new MobEffectResult(effect as MobEffectInstance) as MobEffectResult
```
| Parameter |                               Type                                |
|-----------|-------------------------------------------------------------------|
| effect    | [MobEffectInstance](/vanilla/api/entity/effect/MobEffectInstance) |



