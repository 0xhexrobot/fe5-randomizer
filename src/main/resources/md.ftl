# Fire Emblem 5 Randomizer log

## Randomization details

ROM: Fire Emblem 5 <#if romHeadered>Headered<#else>Headerless</#if> *(${romChecksum})*

Seed: [${"Iron sword"}][${3 + 2}][${"11111101"}][0][0]

### Playable Units options

Randomize bases: <#if randomizeSummary.randomizeBases>**Yes**<#else>No</#if><#if randomizeSummary.randomizeBases>, by <#if randomizeSummary.basesRandomizationType == "variance">**Variance**: **±${randomizeSummary.basesVariance}%**<#elseif randomizeSummary.basesRandomizationType == "redistribute">**Redistribute**: **±${randomizeSummary.basesRedistributeVar}%**</#if></#if>

Randomize growths: <#if randomizeSummary.randomizeGrowths>**Yes**<#else>No</#if><#if randomizeSummary.randomizeGrowths>, by <#if randomizeSummary.growthsRandomizationType == "variance">**Variance**: **±${randomizeSummary.growthsVariance}%**<#elseif randomizeSummary.growthsRandomizationType == "redistribute">**Redistribute**: **±${randomizeSummary.growthsRedistributeVar}%**<#elseif randomizeSummary.growthsRandomizationType == "absolute">**Absolute**: [**${randomizeSummary.growthsAbsoluteMin}%** - **${randomizeSummary.growthsAbsoluteMax}%**]</#if></#if>

Randomize playable unit classes: <#if randomizeSummary.randomizePlayableUnitClasses>**Yes**, Exclude healers: <#if randomizeSummary.excludeHealers>**Yes**<#else>No</#if>, Exclude thieves: <#if randomizeSummary.excludeThieves>**Yes**<#else>No</#if><#else>No</#if>

Randomize enemy classes: <#if randomizeSummary.randomizeEnemyUnitClasses>**Yes**, Exclude bosses: <#if randomizeSummary.randomizeEnemyUnitClassesExcludeBosses>**Yes**<#else>No</#if><#else>No</#if>

<#if units??>
## Units

<#list units as unit>
* [${unit.getName()}](#${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")})
</#list>

<#list units as unit>
### ${unit.getName()}

**Offset:** ${unit.offset?string.@hex_4} **Class:** <#if unit.oldValues["characterClass"]??>${unit.oldValues["characterClass"].getName()} (${unit.oldValues["characterClass"].offset?string.@hex_2}) → **${unit.characterClass.getName()} _(${unit.characterClass.offset?string.@hex_2})_**<#else>${unit.characterClass.getName()} *(${unit.characterClass.offset?string.@hex_2})*</#if>

#### Bases

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov | Lead * | Mov * | P Crit |
-- | --- | --- | --- | --- | --- | --- | --- | --- | ------ | ----- | ------ |
<#if unit.oldValues["baseHp"]??>${unit.oldValues["baseHp"]} → **${unit.baseHp}**<#else>${unit.baseHp}</#if> | <#if unit.oldValues["baseAtk"]??>${unit.oldValues["baseAtk"]} → **${unit.baseAtk}**<#else>${unit.baseAtk}</#if> | <#if unit.oldValues["baseMag"]??>${unit.oldValues["baseMag"]} → **${unit.baseMag}**<#else>${unit.baseMag}</#if> | <#if unit.oldValues["baseSkl"]??>${unit.oldValues["baseSkl"]} → **${unit.baseSkl}**<#else>${unit.baseSkl}</#if> | <#if unit.oldValues["baseSpd"]??>${unit.oldValues["baseSpd"]} → **${unit.baseSpd}**<#else>${unit.baseSpd}</#if> | <#if unit.oldValues["baseLck"]??>${unit.oldValues["baseLck"]} → **${unit.baseLck}**<#else>${unit.baseLck}</#if> | <#if unit.oldValues["baseDef"]??>${unit.oldValues["baseDef"]} → **${unit.baseDef}**<#else>${unit.baseDef}</#if> | <#if unit.oldValues["baseBld"]??>${unit.oldValues["baseBld"]} → **${unit.baseBld}**<#else>${unit.baseBld}</#if> | <#if unit.oldValues["baseMov"]??>${unit.oldValues["baseMov"]} → **${unit.baseMov}**<#else>${unit.baseMov}</#if> | <#if unit.oldValues["leadershipStars"]??>${unit.oldValues["leadershipStars"]} → **${unit.leadershipStars}**<#else>${unit.leadershipStars}</#if> | <#if unit.oldValues["movementStars"]??>${unit.oldValues["movementStars"].amount} → **${unit.movementStars.ammount}**<#else>${unit.movementStars.ammount}</#if> | <#if unit.oldValues["counterCritBoost"]??>${unit.oldValues["counterCritBoost"]} → **${unit.counterCritBoost}**<#else>${unit.counterCritBoost}</#if> |

#### Growths

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov |
-- | --- | --- | --- | --- | --- | --- | --- | --- |
<#if unit.oldValues["hpGrowth"]??>${unit.oldValues["hpGrowth"]} → **${unit.hpGrowth}**<#else>${unit.hpGrowth}</#if> | <#if unit.oldValues["atkGrowth"]??>${unit.oldValues["atkGrowth"]} → **${unit.atkGrowth}**<#else>${unit.atkGrowth}</#if> | <#if unit.oldValues["magGrowth"]??>${unit.oldValues["magGrowth"]} → **${unit.magGrowth}**<#else>${unit.magGrowth}</#if> | <#if unit.oldValues["sklGrowth"]??>${unit.oldValues["sklGrowth"]} → **${unit.sklGrowth}**<#else>${unit.sklGrowth}</#if> | <#if unit.oldValues["sklGrowth"]??>${unit.oldValues["sklGrowth"]} → **${unit.sklGrowth}**<#else>${unit.sklGrowth}</#if> | <#if unit.oldValues["spdGrowth"]??>${unit.oldValues["spdGrowth"]} → **${unit.spdGrowth}**<#else>${unit.spdGrowth}</#if> | <#if unit.oldValues["lckGrowth"]??>${unit.oldValues["lckGrowth"]} → **${unit.lckGrowth}**<#else>${unit.lckGrowth}</#if> | <#if unit.oldValues["defGrowth"]??>${unit.oldValues["defGrowth"]} → **${unit.defGrowth}**<#else>${unit.defGrowth}</#if> | <#if unit.oldValues["bldGrowth"]??>${unit.oldValues["bldGrowth"]} → **${unit.bldGrowth}**<#else>${unit.bldGrowth}</#if> | <#if unit.oldValues["movGrowth"]??>${unit.oldValues["movGrowth"]} → **${unit.movGrowth}**<#else>${unit.movGrowth}</#if> |

#### Weapon Proficiency

Weapon | Proficiency | Extra Ranks | Weapon | Proficiency | Extra Ranks |
------ | ----------- | ------------| ------ | ----------- | ------------|
Sword | <#if unit.oldValues["baseSwordLv"]??>${unit.oldValues["baseSwordLv"]} → **${unit.baseSwordLv.amount}**<#else>${unit.baseSwordLv.amount}</#if> | ${unit.baseSwordLv.name} | Fire | <#if unit.oldValues["baseFireLv"]??>${unit.oldValues["baseFireLv"]} → **${unit.baseFireLv.amount}**<#else>${unit.baseFireLv.amount}</#if> | ${unit.baseFireLv.name} |
Lance | <#if unit.oldValues["baseLanceLv"]??>${unit.oldValues["baseLanceLv"]} → **${unit.baseLanceLv.amount}**<#else>${unit.baseLanceLv.amount}</#if> | ${unit.baseLanceLv.name} | Thunder | <#if unit.oldValues["baseThunderLv"]??>${unit.oldValues["baseThunderLv"]} → **${unit.baseThunderLv.amount}**<#else>${unit.baseThunderLv.amount}</#if> | ${unit.baseThunderLv.name} |
Axe | <#if unit.oldValues["baseAxeLv"]??>${unit.oldValues["baseAxeLv"]} → **${unit.baseAxeLv.amount}**<#else>${unit.baseAxeLv.amount}</#if> | ${unit.baseAxeLv.name} | Wind | <#if unit.oldValues["baseWindLv"]??>${unit.oldValues["baseWindLv"]} → **${unit.baseWindLv.amount}**<#else>${unit.baseWindLv.amount}</#if> | ${unit.baseWindLv.name} |
Bow | <#if unit.oldValues["baseBowLv"]??>${unit.oldValues["baseBowLv"]} → **${unit.baseBowLv.amount}**<#else>${unit.baseBowLv.amount}</#if> | ${unit.baseBowLv.name} | Light | <#if unit.oldValues["baseLightLv"]??>${unit.oldValues["baseLightLv"]} → **${unit.baseLightLv.amount}**<#else>${unit.baseLightLv.amount}</#if> | ${unit.baseLightLv.name} |
Staff | <#if unit.oldValues["baseStaffLv"]??>${unit.oldValues["baseStaffLv"]} → **${unit.baseStaffLv.amount}**<#else>${unit.baseStaffLv.amount}</#if> | ${unit.baseStaffLv.name} | Dark | <#if unit.oldValues["baseDarkLv"]??>${unit.oldValues["baseDarkLv"]} → **${unit.baseDarkLv.amount}**<#else>${unit.baseDarkLv.amount}</#if> | ${unit.baseDarkLv.name} |

#### Skills

**Skills1:** *${unit.skills1?string.@hex_2}*, **Skills2:** *${unit.skills2?string.@hex_2}*, **Skills3:** *${unit.skills3?string.@hex_2}*

<#list unit.skills as skill>${skill.getName()}<#sep>, </#list>

</#list>
</#if>

<#if classes??>
<#list classes as class>
## Classes

### ${class.getName()}

**Offset**: ${class.offset?string.@hex_2}

#### Bases

HP | Atk | Mag | Skl | Spd | Def | Bld | Mov |
-- | --- | --- | --- | --- | --- | --- | --- |
<#if class.oldValues["baseHp"]??>${class.oldValues["baseHp"]} → **${class.baseHp}**<#else>${class.baseHp}</#if> | <#if class.oldValues["baseAtk"]??>${class.oldValues["baseAtk"]} → **${class.baseAtk}**<#else>${class.baseAtk}</#if> | <#if class.oldValues["baseMag"]??>${class.oldValues["baseMag"]} → **${class.baseMag}**<#else>${class.baseMag}</#if> | <#if class.oldValues["baseSkl"]??>${class.oldValues["baseSkl"]} → **${class.baseSkl}**<#else>${class.baseSkl}</#if> | <#if class.oldValues["baseSpd"]??>${class.oldValues["baseSpd"]} → **${class.baseSpd}**<#else>${class.baseSpd}</#if> | <#if class.oldValues["baseDef"]??>${class.oldValues["baseDef"]} → **${class.baseDef}**<#else>${class.baseDef}</#if> | <#if class.oldValues["baseBld"]??>${class.oldValues["baseBld"]} → **${class.baseBld}**<#else>${class.baseBld}</#if> | <#if class.oldValues["baseMov"]??>${class.oldValues["baseMov"]} → **${class.baseMov}**<#else>${class.baseMov}</#if> |

#### Weapon Proficiency

Weapon | Proficiency | Extra Ranks | Weapon | Proficiency | Extra Ranks |
------ | ----------- | ------------| ------ | ----------- | ------------|
Sword | ${class.baseSwordLv.amount} | ${class.baseSwordLv.name} | Fire | ${class.baseFireLv.amount} | ${class.baseFireLv.name} |
Lance | ${class.baseLanceLv.amount} | ${class.baseLanceLv.name} | Thunder | ${class.baseThunderLv.amount} | ${class.baseThunderLv.name} |
Axe | ${class.baseAxeLv.amount} | ${class.baseAxeLv.name} | Wind | ${class.baseWindLv.amount} | ${class.baseWindLv.name} |
Bow | ${class.baseBowLv.amount} | ${class.baseBowLv.name} | Light | ${class.baseLightLv.amount} | ${class.baseLightLv.name} |
Staff | ${class.baseStaffLv.amount} | ${class.baseStaffLv.name} | Dark | ${class.baseDarkLv.amount} | ${class.baseDarkLv.name} |


#### Skills

**Skills1:** *${class.skills1?string.@hex_2}*, **Skills2:** *${class.skills2?string.@hex_2}*, **Skills3:** *${class.skills3?string.@hex_2}*

<#list class.skills as skill>${skill.getName()}<#sep>, </#list>

</#list>
</#if>

<#if items??>
## Items

Name | Mt | Acc | Wt | Crt | Rng | Rank | Uses |
---- | -- | --- | -- | --- | --- | ---- | ---- |
<#list items as item>
${item.getName()} | ${item.power} | ${item.accuracy} | ${item.weight} | ${item.critical} | ${item.weaponRange.getName()} | ${item.weaponRank.getName()} | ${item.maxUses} | 
</#list>
</#if>

<#if chapterData??>
## Army data

<#list chapterData as chapter>

### ${chapter.getName()}

<#list chapter.getArmyData() as unit>
**Character**: ${unit.character.getName()}(${unit.character.offset?string.@hex_4}) <#if unit.character.oldValues["characterClass"]??> → **${unit.character.characterClass.getName()}**</#if>

X: ${unit.getXCoord()}, Y: ${unit.getYCoord()}, Army: ${unit.armyOrigin?string.@hex_4}, Level: ${unit.level}<#if unit.promoted>(P)</#if>,

<#if unit.oldValues["inventory"]??>
Inventory |
--------- |
<#list unit.inventory as item>
**${item.getName()}(${item.offset?string.@hex_2})** |
<#else>
_**Empty**_ |
</#list>
<#else>
Inventory |
--------- |
<#list unit.inventory as item>
${item.getName()}(${item.offset?string.@hex_2}) |
<#else>
*Empty* |
</#list>
</#if>

Unknown1: ${unit.unknown1?string.@hex_2}, Unknown2: ${unit.unknown2?string.@hex_2}, Unknown3: ${unit.unknown3?string.@hex_2}, Unknown4: ${unit.unknown4?string.@hex_2}

--------------

</#list>

</#list>

</#if>
