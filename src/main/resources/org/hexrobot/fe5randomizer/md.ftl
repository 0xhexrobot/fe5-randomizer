# Fire Emblem 5 Randomizer log

## Randomization details

ROM: ${romName} <#if romHeadered>Headered<#else>Headerless</#if> *(${romChecksum})*

Seed: [${seed[0].getName()}][${seed[1].getName()}][${seed[2].getName()}][${seed[3].getName()}][${seed[4].getName()}][${seed[5].getName()}]

Randomize bases: <#if summary.randomizeBases>**Yes**<#else>No</#if><#if summary.randomizeBases>, by <#if summary.basesRandomizationType == "variance">**Variance**: **±${summary.basesVariance}%**<#elseif summary.basesRandomizationType == "redistribute">**Redistribute**: **±${summary.basesRedistributeVar}%**</#if></#if>

Randomize growths: <#if summary.randomizeGrowths>**Yes**<#else>No</#if><#if summary.randomizeGrowths>, by <#if summary.growthsRandomizationType == "variance">**Variance**: **±${summary.growthsVariance}%**<#elseif summary.growthsRandomizationType == "redistribute">**Redistribute**: **±${summary.growthsRedistributeVar}%**<#elseif summary.growthsRandomizationType == "absolute">**Absolute**: [**${summary.growthsAbsoluteMin}%** - **${summary.growthsAbsoluteMax}%**]</#if></#if>

Randomize playable unit classes: <#if summary.randomizePlayableUnitClasses>**Yes**, Exclude healers: <#if summary.excludeHealers>**Yes**<#else>No</#if>, Exclude thieves: <#if summary.excludeThieves>**Yes**<#else>No</#if><#else>No</#if>

Randomize ally unit classes: <#if summary.randomizeAllyUnitClasses>**Yes**<#else>No</#if>

Randomize pursuit critical: <#if summary.randomizePursuitCrit>**Yes**<#else>No</#if>

Randomize movement stars: <#if summary.randomizeMovStars>**Yes**<#else>No</#if>

Randomize leadership stars: <#if summary.randomizeLeadershipStars>**Yes**<#else>No</#if>

Randomize skills: <#if summary.randomizeSkills>**Yes**, Max skill count: ${summary.maxSkillCount}<#else>No</#if> 

Randomize enemy classes: <#if summary.randomizeEnemyUnitClasses>**Yes**, Exclude bosses: <#if summary.randomizeEnemyUnitClassesExcludeBosses>**Yes**<#else>No</#if><#else>No</#if>

Add enemy inventory: <#if summary.enemiesAddExtraInventory>**Yes**, Max new items: ${summary.enemiesMaxExtraInventoryCount}<#else>No</#if>

Randomize enemy movement stars: <#if summary.randomizeEnemyMovStars>**Yes**, Exclude units with zero stars: <#if summary.enemyMovStarsExcludeZero>**Yes**<#else>No</#if><#else>No</#if>

Randomize enemy leadership stars: <#if summary.randomizeEnemyLeadershipStars>**Yes**, ${summary.enemyLeadershipStarsCap}<#else>No</#if>

Randomize Boss skills: <#if summary.randomizeBossSkills>**Yes**, Max skill count: ${summary.maxBossSkillCount}<#else> No</#if>, Randomize Enemy skills: <#if summary.randomizeEnemySkills>**Yes**, Max skill count: ${summary.maxEnemySkillCount}<#else>No</#if>

Randomize items: 
<#if summary.randomizeWpnsMight>* Might: **±${summary.wpnsMightDelta}**</#if>
<#if summary.randomizeWpnsAccuracy>* Accuracy **±${summary.wpnsAccuracyDelta}**</#if>
<#if summary.randomizeWpnsWeight>* Weight **±${summary.wpnsWeightDelta}**</#if>
<#if summary.randomizeWpnsCritical>* Critical **±${summary.wpnsCriticalDelta}**</#if>
<#if summary.randomizeWpnsMaxUses>* Max uses</#if>
<#if summary.randomizeWpnsCost>* Cost</#if>
<#if summary.wpnsAddBladeEffect>* Add Blade effect, chance: **${summary.wpnsBladeEffectChance}%**, available effects: <#list summary.wpnsAvailableBladeEffectsList as effect>**${effect.getName()}**<#sep>, <#else>None</#list></#if>
<#if summary.wpnsAddStatBonus>* Add stat bonus, chance: **${summary.wpnsStatBonusChance}%**</#if>
<#if summary.wpnsAddWeaponSkill>* Add weapon skill: chance: **${summary.wpnsSkillChance}%**, allow multiple skills: <#if summary.wpnsAllowMultipleWeaponSkills>**Yes**<#else>No</#if></#if>
<#if summary.wpnsExcludeIronWeapons>* Exclude Iron weapons</#if>

Randomize rewards: <#if summary.randomizeRewards>**Yes**, randomization type: ${summary.rewardsRandomizationType}<#if summary.rewardsRandomizationType != "shuffle">, Safe scrolls: <#if summary.rewardsSafeScrolls>**Yes**<#else>No</#if>, Safe Knight Proofs: <#if summary.rewardsSafeKnightProofs>**Yes**<#else>No</#if></#if><#else>No</#if>

Randomize shop items: <#if summary.randomizeShops>**Yes**, randomization type: ${summary.shopsRandomizationType}<#else>No</#if><#if summary.shopsRandomizationType != "replace">, maintain item count: <#if summary.shopsMaintainItemCount>**Yes**<#else>No</#if></#if>

Randomize Scrolls: <#if summary.randomizeScrolls>**Yes**, randomization type: ${summary.scrollsRandomizationType}<#else>No</#if>

Balance:
<#if summary.balanceChangeBraveAxeToBRank>* Change Brave axe to B rank</#if>
<#if summary.balanceBuffAllyUnits>* Buff ally units</#if>
<#if summary.balanceAllyAddExtraInventory>* Add ally units up to ${summary.balanceAllyMaxExtraInventoryCount} items</#if>
<#if summary.nerfBallistae>* Nerf ballistae accuracy</#if>
<#if summary.balanceWpnsIncreaseUses>* Increase weapon uses</#if>
<#if summary.balanceDowngradeWindTome>* Downgrade Wind tome</#if>
<#if summary.balanceRemovePrfLocks>* Remove Prf* locks</#if>

Shuffle palettes: <#if summary.shufflePalettes>**Yes**<#else>No</#if>

<#if summary.lilMansterRenamePugi>
Lil' Manster
* Rename *Voulge* to _**Pugi**_
</#if>

<#if summary.projectExileRenamePugi>
Project Exile
* Rename *Bhuj* to _**Pugi**_
</#if>

<#if units??>
## Units

<#list units as unit>
* [${unit.getName()}](#${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")})
</#list>

<#list units as unit>
### ${unit.getName()}

**Offset:** ${unit.offset?string.@hex_4} **Class:** <#if unit.oldValues["characterClass"]??>${unit.oldValues["characterClass"].getName()} (${unit.oldValues["characterClass"].offset?string.@hex_2}) -> **${unit.characterClass.getName()} _(${unit.characterClass.offset?string.@hex_2})_**<#else>${unit.characterClass.getName()} *(${unit.characterClass.offset?string.@hex_2})*</#if>

#### Bases

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov | Lead * | Mov * | P Crit |
-- | --- | --- | --- | --- | --- | --- | --- | --- | ------ | ----- | ------ |
<#if unit.oldValues["baseHp"]??>${unit.oldValues["baseHp"]} -> **${unit.baseHp}**<#else>${unit.baseHp}</#if> | <#if unit.oldValues["baseAtk"]??>${unit.oldValues["baseAtk"]} -> **${unit.baseAtk}**<#else>${unit.baseAtk}</#if> | <#if unit.oldValues["baseMag"]??>${unit.oldValues["baseMag"]} -> **${unit.baseMag}**<#else>${unit.baseMag}</#if> | <#if unit.oldValues["baseSkl"]??>${unit.oldValues["baseSkl"]} -> **${unit.baseSkl}**<#else>${unit.baseSkl}</#if> | <#if unit.oldValues["baseSpd"]??>${unit.oldValues["baseSpd"]} -> **${unit.baseSpd}**<#else>${unit.baseSpd}</#if> | <#if unit.oldValues["baseLck"]??>${unit.oldValues["baseLck"]} -> **${unit.baseLck}**<#else>${unit.baseLck}</#if> | <#if unit.oldValues["baseDef"]??>${unit.oldValues["baseDef"]} -> **${unit.baseDef}**<#else>${unit.baseDef}</#if> | <#if unit.oldValues["baseBld"]??>${unit.oldValues["baseBld"]} -> **${unit.baseBld}**<#else>${unit.baseBld}</#if> | <#if unit.oldValues["baseMov"]??>${unit.oldValues["baseMov"]} -> **${unit.baseMov}**<#else>${unit.baseMov}</#if> | <#if unit.oldValues["leadershipStars"]??>${unit.oldValues["leadershipStars"]} -> **${unit.leadershipStars}**<#else>${unit.leadershipStars}</#if> | <#if unit.oldValues["movementStars"]??>${unit.oldValues["movementStars"].amount} -> **${unit.movementStars.amount}**<#else>${unit.movementStars.amount}</#if> | <#if unit.oldValues["counterCritBoost"]??>${unit.oldValues["counterCritBoost"]} -> **${unit.counterCritBoost}**<#else>${unit.counterCritBoost}</#if> |

<#if unit.hasRandomBases()>_(Random bases)_</#if>

#### Growths

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov |
-- | --- | --- | --- | --- | --- | --- | --- | --- |
<#if unit.oldValues["hpGrowth"]??>${unit.oldValues["hpGrowth"]} -> **${unit.hpGrowth}**<#else>${unit.hpGrowth}</#if> | <#if unit.oldValues["atkGrowth"]??>${unit.oldValues["atkGrowth"]} -> **${unit.atkGrowth}**<#else>${unit.atkGrowth}</#if> | <#if unit.oldValues["magGrowth"]??>${unit.oldValues["magGrowth"]} -> **${unit.magGrowth}**<#else>${unit.magGrowth}</#if> | <#if unit.oldValues["sklGrowth"]??>${unit.oldValues["sklGrowth"]} -> **${unit.sklGrowth}**<#else>${unit.sklGrowth}</#if> | <#if unit.oldValues["spdGrowth"]??>${unit.oldValues["spdGrowth"]} -> **${unit.spdGrowth}**<#else>${unit.spdGrowth}</#if> | <#if unit.oldValues["lckGrowth"]??>${unit.oldValues["lckGrowth"]} -> **${unit.lckGrowth}**<#else>${unit.lckGrowth}</#if> | <#if unit.oldValues["defGrowth"]??>${unit.oldValues["defGrowth"]} -> **${unit.defGrowth}**<#else>${unit.defGrowth}</#if> | <#if unit.oldValues["bldGrowth"]??>${unit.oldValues["bldGrowth"]} -> **${unit.bldGrowth}**<#else>${unit.bldGrowth}</#if> | <#if unit.oldValues["movGrowth"]??>${unit.oldValues["movGrowth"]} -> **${unit.movGrowth}**<#else>${unit.movGrowth}</#if> |

#### Weapon Proficiency

| Weapon | Proficiency                                                                                                                                    | Extra Ranks              | Weapon  | Proficiency                                                                                                                                            | Extra Ranks                |
|--------|------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|---------|--------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------|
| Sword  | <#if unit.oldValues["baseSwordLv"]??>${unit.oldValues["baseSwordLv"]} -> **${unit.baseSwordLv.amount}**<#else>${unit.baseSwordLv.amount}</#if> | ${unit.baseSwordLv.name} | Fire    | <#if unit.oldValues["baseFireLv"]??>${unit.oldValues["baseFireLv"]} -> **${unit.baseFireLv.amount}**<#else>${unit.baseFireLv.amount}</#if>             | ${unit.baseFireLv.name}    |
| Lance  | <#if unit.oldValues["baseLanceLv"]??>${unit.oldValues["baseLanceLv"]} -> **${unit.baseLanceLv.amount}**<#else>${unit.baseLanceLv.amount}</#if> | ${unit.baseLanceLv.name} | Thunder | <#if unit.oldValues["baseThunderLv"]??>${unit.oldValues["baseThunderLv"]} -> **${unit.baseThunderLv.amount}**<#else>${unit.baseThunderLv.amount}</#if> | ${unit.baseThunderLv.name} |
| Axe    | <#if unit.oldValues["baseAxeLv"]??>${unit.oldValues["baseAxeLv"]} -> **${unit.baseAxeLv.amount}**<#else>${unit.baseAxeLv.amount}</#if>         | ${unit.baseAxeLv.name}   | Wind    | <#if unit.oldValues["baseWindLv"]??>${unit.oldValues["baseWindLv"]} -> **${unit.baseWindLv.amount}**<#else>${unit.baseWindLv.amount}</#if>             | ${unit.baseWindLv.name}    |
| Bow    | <#if unit.oldValues["baseBowLv"]??>${unit.oldValues["baseBowLv"]} -> **${unit.baseBowLv.amount}**<#else>${unit.baseBowLv.amount}</#if>         | ${unit.baseBowLv.name}   | Light   | <#if unit.oldValues["baseLightLv"]??>${unit.oldValues["baseLightLv"]} -> **${unit.baseLightLv.amount}**<#else>${unit.baseLightLv.amount}</#if>         | ${unit.baseLightLv.name}   |
| Staff  | <#if unit.oldValues["baseStaffLv"]??>${unit.oldValues["baseStaffLv"]} -> **${unit.baseStaffLv.amount}**<#else>${unit.baseStaffLv.amount}</#if> | ${unit.baseStaffLv.name} | Dark    | <#if unit.oldValues["baseDarkLv"]??>${unit.oldValues["baseDarkLv"]} -> **${unit.baseDarkLv.amount}**<#else>${unit.baseDarkLv.amount}</#if>             | ${unit.baseDarkLv.name}    |

#### Skills

| **Skills1**                                                                                                                                                      | **Skills2**                                                                                                                                                      | **Skills3**                                                                                                                                                      |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <#if unit.oldValues["skills1"]??>*${unit.oldValues["skills1"]?string.@hex_2}* -> _**${unit.skills1?string.@hex_2}**_<#else>*${unit.skills1?string.@hex_2}*</#if> | <#if unit.oldValues["skills2"]??>*${unit.oldValues["skills2"]?string.@hex_2}* -> _**${unit.skills2?string.@hex_2}**_<#else>*${unit.skills2?string.@hex_2}*</#if> | <#if unit.oldValues["skills3"]??>*${unit.oldValues["skills3"]?string.@hex_2}* -> _**${unit.skills3?string.@hex_2}**_<#else>*${unit.skills3?string.@hex_2}*</#if> |

<#list unit.comparedSkills as skillsDiff><#if skillsDiff.value gt 0>**<#elseif skillsDiff.value lt 0>~~</#if>${skillsDiff.key.getName()} (${skillsDiff.value})<#if skillsDiff.value gt 0>**<#elseif skillsDiff.value lt 0>~~</#if><#sep>, </#list>

</#list>
</#if>

<#if classes??>

## Classes
<#list classes as class>
### ${class.getName()}

**Offset**: ${class.offset?string.@hex_2}

#### Bases

HP | Atk | Mag | Skl | Spd | Def | Bld | Mov |
-- | --- | --- | --- | --- | --- | --- | --- |
<#if class.oldValues["baseHp"]??>${class.oldValues["baseHp"]} -> **${class.baseHp}**<#else>${class.baseHp}</#if> | <#if class.oldValues["baseAtk"]??>${class.oldValues["baseAtk"]} -> **${class.baseAtk}**<#else>${class.baseAtk}</#if> | <#if class.oldValues["baseMag"]??>${class.oldValues["baseMag"]} -> **${class.baseMag}**<#else>${class.baseMag}</#if> | <#if class.oldValues["baseSkl"]??>${class.oldValues["baseSkl"]} -> **${class.baseSkl}**<#else>${class.baseSkl}</#if> | <#if class.oldValues["baseSpd"]??>${class.oldValues["baseSpd"]} -> **${class.baseSpd}**<#else>${class.baseSpd}</#if> | <#if class.oldValues["baseDef"]??>${class.oldValues["baseDef"]} -> **${class.baseDef}**<#else>${class.baseDef}</#if> | <#if class.oldValues["baseBld"]??>${class.oldValues["baseBld"]} -> **${class.baseBld}**<#else>${class.baseBld}</#if> | <#if class.oldValues["baseMov"]??>${class.oldValues["baseMov"]} -> **${class.baseMov}**<#else>${class.baseMov}</#if> |

#### Weapon Proficiency

| Weapon | Proficiency                 | Extra Ranks               | Weapon  | Proficiency                   | Extra Ranks                 |
|--------|-----------------------------|---------------------------|---------|-------------------------------|-----------------------------|
| Sword  | ${class.baseSwordLv.amount} | ${class.baseSwordLv.name} | Fire    | ${class.baseFireLv.amount}    | ${class.baseFireLv.name}    |
| Lance  | ${class.baseLanceLv.amount} | ${class.baseLanceLv.name} | Thunder | ${class.baseThunderLv.amount} | ${class.baseThunderLv.name} |
| Axe    | ${class.baseAxeLv.amount}   | ${class.baseAxeLv.name}   | Wind    | ${class.baseWindLv.amount}    | ${class.baseWindLv.name}    |
| Bow    | ${class.baseBowLv.amount}   | ${class.baseBowLv.name}   | Light   | ${class.baseLightLv.amount}   | ${class.baseLightLv.name}   |
| Staff  | ${class.baseStaffLv.amount} | ${class.baseStaffLv.name} | Dark    | ${class.baseDarkLv.amount}    | ${class.baseDarkLv.name}    |


#### Skills

**Skills1:** *${class.skills1?string.@hex_2}*, **Skills2:** *${class.skills2?string.@hex_2}*, **Skills3:** *${class.skills3?string.@hex_2}*

<#list class.skills as skill>${skill.getName()}<#sep>, </#list>

</#list>
</#if>

## Portrait palettes
<#list portraitPalettes as palette>
* ${palette.label}(${palette.offset?string.@hex_2}): <#list palette.palette as i>${i.toRgbString()}<#sep>, </#sep></#list>
</#list>

<#if items??>
## Items

Name | Mt | Acc | Wt | Crt | Rng | Rank | Uses | Skills1 | Skills2 | Skills | Blade Eff | CostPerUse | Stat Bonus |
---- | -- | --- | -- | --- | --- | ---- | ---- | ------- | ------- | ------ | --------- | ---------- | ---------- |
<#list items as item>
${item.getName()} | <#if item.oldValues["power"]??>${item.oldValues["power"]} -> **${item.power}**<#else>${item.power}</#if> | <#if item.oldValues["accuracy"]??>${item.oldValues["accuracy"]} -> **${item.accuracy}**<#else>${item.accuracy}</#if> | <#if item.oldValues["weight"]??>${item.oldValues["weight"]} -> **${item.weight}**<#else>${item.weight}</#if> | <#if item.oldValues["critical"]??>${item.oldValues["critical"]} -> **${item.critical}**<#else>${item.critical}</#if> | <#if item.oldValues["weaponRange"]??>${item.olValues["weaponRange"].getName()} -> **${item.weaponRange.getName()}**<#else>${item.weaponRange.getName()}</#if> | <#if item.oldValues["weaponRank"]??>${item.oldValues["weaponRank"].getName()} -> **${item.weaponRank.getName()}**<#else>${item.weaponRank.getName()}</#if> | <#if item.oldValues["maxUses"]??>${item.oldValues["maxUses"]} -> **${item.maxUses}**<#else>${item.maxUses}</#if> | <#if item.oldValues["skills1"]??>*${item.oldValues["skills1"]?string.@hex_2}* -> _**${item.skills1?string.@hex_2}**_<#else>*${item.skills1?string.@hex_2}*</#if> | <#if item.oldValues["skills2"]??>*${item.oldValues["skills2"]?string.@hex_2}* -> _**${item.skills2?string.@hex_2}**_<#else>*${item.skills2?string.@hex_2}*</#if> | <#list item.comparedSkills as skillDiff><#if skillDiff.value gt 0>**<#elseif skillDiff.value lt 0>~~</#if>${skillDiff.key.getName()} (${skillDiff.value})<#if skillDiff.value gt 0>**<#elseif skillDiff.value lt 0>~~</#if><#sep>, </#list> | <#if item.oldValues["weaponBladeEffect"]??>${item.oldValues["weaponBladeEffect"].getName()} -> **${item.weaponBladeEffect.getName()}**<#else>${item.weaponBladeEffect.getName()}</#if> | <#if item.oldValues["costPerUse"]??>${item.oldValues["costPerUse"]} -> **${item.costPerUse}**<#else>${item.costPerUse}</#if> | <#if item.oldValues["weaponStatBonus"]??>${item.oldValues["weaponStatBonus"].getName()} -> **${item.weaponStatBonus.getName()}**<#else>${item.weaponStatBonus.getName()}</#if> |
</#list>
</#if>

## Scrolls

Scroll name | Hp | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov |
----------- | -- | --- | --- | --- | --- | --- | --- | --- | --- |
<#list scrolls as scroll>
<#if scroll.modified>**${scroll.getName()}**<#else>${scroll.getName()}</#if> | <#if scroll.oldValues["hp"]??>${scroll.oldValues["hp"]} -> **${scroll.hp}**<#else>${scroll.hp}</#if> | <#if scroll.oldValues["atk"]??>${scroll.oldValues["atk"]} -> **${scroll.atk}**<#else>${scroll.atk}</#if> | <#if scroll.oldValues["mag"]??>${scroll.oldValues["mag"]} -> **${scroll.mag}**<#else>${scroll.mag}</#if> | <#if scroll.oldValues["skl"]??>${scroll.oldValues["skl"]} -> **${scroll.skl}**<#else>${scroll.skl}</#if> | <#if scroll.oldValues["spd"]??>${scroll.oldValues["spd"]} -> **${scroll.spd}**<#else>${scroll.spd}</#if> | <#if scroll.oldValues["lck"]??>${scroll.oldValues["lck"]} -> **${scroll.lck}**<#else>${scroll.lck}</#if> | <#if scroll.oldValues["def"]??>${scroll.oldValues["def"]} -> **${scroll.def}**<#else>${scroll.def}</#if> | <#if scroll.oldValues["bld"]??>${scroll.oldValues["bld"]} -> **${scroll.bld}**<#else>${scroll.bld}</#if> | <#if scroll.oldValues["mov"]??>${scroll.oldValues["mov"]} -> **${scroll.mov}**<#else>${scroll.mov}</#if> |
</#list>

<#if summary.randomizeRewards>
## Event rewards
<#list eventRewards as event>
* ${event.getName()} <#if event.isModified()>-> **${event.item.getName()}**</#if>
</#list>

## Chest rewards
<#list chestRewards as chest>
* ${chest.getName()} <#if chest.isModified()>-> **${chest.item.getName()}**</#if>
</#list>

## House rewards
<#list houseRewards as house>
* ${house.getName()} <#if house.isModified()>-> **${house.item.getName()}**</#if>
</#list>
</#if>

## Shops
<#list shops as shop>
${shop.getName()} |
----------------- |
<#list shop.comparedItems as itemDiff>
<#if itemDiff.value gt 0>**<#elseif itemDiff.value lt 0>~~</#if>${itemDiff.key.getName()} ${itemDiff.key.totalCost} (${itemDiff.value})<#if itemDiff.value gt 0>**<#elseif itemDiff.value lt 0>~~</#if> |
</#list>

</#list>

<#if chapterData??>
## Army data

<#list chapterData as chapter>

### ${chapter.getName()}

<#list chapter.getArmyData() as unit>
**Character**: ${unit.character.getName()}(${unit.character.offset?string.@hex_4}) <#if unit.character.oldValues["characterClass"]??> -> **${unit.character.characterClass.getName()}**</#if>

X: ${unit.getXCoord()}, Y: ${unit.getYCoord()}, Army: ${unit.armyOrigin?string.@hex_4}, Level: ${unit.level}<#if unit.autoLeveled>(A)</#if>,

Inventory |
--------- |
<#list unit.comparedInventory as itemDiffPair>
<#if itemDiffPair.value gt 0>**${itemDiffPair.key.getName()}(${itemDiffPair.key.offset?string.@hex_2}) (${itemDiffPair.value})** |<#elseif itemDiffPair.value lt 0>~~${itemDiffPair.key.getName()}(${itemDiffPair.key.offset?string.@hex_2}) (${itemDiffPair.value})~~ |<#else>${itemDiffPair.key.getName()}(${itemDiffPair.key.offset?string.@hex_2}) (${itemDiffPair.value}) |</#if>
<#else>
*Empty* |
</#list>

Unknown1: ${unit.unknown1?string.@hex_2}, Unknown2: ${unit.unknown2?string.@hex_2}, Unknown3: ${unit.unknown3?string.@hex_2}, Unknown4: ${unit.unknown4?string.@hex_2}

--------------

</#list>

</#list>

</#if>
