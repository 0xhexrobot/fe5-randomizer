# Fire Emblem 5 Randomizer log

## Randomization details

ROM: Fire Emblem 5 <#if romHeadered>Headered<#else>Headerless</#if> *(${romChecksum})*

Seed: [${"Iron sword"}][${3 + 2}][${"11111101"}][0][0]

### Playable Units options

Randomize bases: <#if randomizeSummary.randomizeBases>**Yes**<#else>No</#if><#if randomizeSummary.randomizeBases>, by <#if randomizeSummary.basesRandomizationType == "variance">**Variance**: **±${randomizeSummary.basesVariance}%**<#elseif randomizeSummary.basesRandomizationType == "redistribute">**Redistribute**: **±${randomizeSummary.basesRedistributeVar}%**</#if></#if>

Randomize growths: <#if randomizeSummary.randomizeGrowths>**Yes**<#else>No</#if><#if randomizeSummary.randomizeGrowths>, by <#if randomizeSummary.growthsRandomizationType == "variance">**Variance**: **±${randomizeSummary.growthsVariance}%**<#elseif randomizeSummary.growthsRandomizationType == "redistribute">**Redistribute**: **±${randomizeSummary.growthsRedistributeVar}%**<#elseif randomizeSummary.growthsRandomizationType == "absolute">**Absolute**: [**${randomizeSummary.growthsAbsoluteMin}%** - **${randomizeSummary.growthsAbsoluteMax}%**]</#if></#if>

<#if units??>
## Units

<#list units as unit>
* [${unit.getName()}](#${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")})
</#list>

<#list units as unit>
### ${unit.getName()}

**Offset:** ${unit.offset?string.@hex_4} **Class:** ${unit.characterClass.getName()} *(${unit.characterClass.offset?string.@hex_2})*

#### Bases

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov | Lead * | Mov * | P Crit |
-- | --- | --- | --- | --- | --- | --- | --- | --- | ------ | ----- | ------ |
<#if unit.oldValues["baseHp"]??>${unit.oldValues["baseHp"]} → **${unit.baseHp}**<#else>${unit.baseHp}</#if> | <#if unit.oldValues["baseAtk"]??>${unit.oldValues["baseAtk"]} → **${unit.baseAtk}**<#else>${unit.baseAtk}</#if> | <#if unit.oldValues["baseMag"]??>${unit.oldValues["baseMag"]} → **${unit.baseMag}**<#else>${unit.baseMag}</#if> | <#if unit.oldValues["baseSkl"]??>${unit.oldValues["baseSkl"]} → **${unit.baseSkl}**<#else>${unit.baseSkl}</#if> | <#if unit.oldValues["baseSpd"]??>${unit.oldValues["baseSpd"]} → **${unit.baseSpd}**<#else>${unit.baseSpd}</#if> | <#if unit.oldValues["baseLck"]??>${unit.oldValues["baseLck"]} → **${unit.baseLck}**<#else>${unit.baseLck}</#if> | <#if unit.oldValues["baseDef"]??>${unit.oldValues["baseDef"]} → **${unit.baseDef}**<#else>${unit.baseDef}</#if> | <#if unit.oldValues["baseBld"]??>${unit.oldValues["baseBld"]} → **${unit.baseBld}**<#else>${unit.baseBld}</#if> | <#if unit.oldValues["baseMov"]??>${unit.oldValues["baseMov"]} → **${unit.baseMov}**<#else>${unit.baseMov}</#if> | <#if unit.oldValues["leadershipStars"]??>${unit.oldValues["leadershipStars"]} → **${unit.leadershipStars}**<#else>${unit.leadershipStars}</#if> | <#if unit.oldValues["movementStars"]??>${unit.oldValues["movementStars"].amount} → **${unit.movementStars.ammount}**<#else>${unit.movementStars.ammount}</#if> | <#if unit.oldValues["counterCritBoost"]??>${unit.oldValues["counterCritBoost"]} → **${unit.counterCritBoost}**<#else>${unit.counterCritBoost}</#if> |

#### Growths

HP | Atk | Mag | Skl | Spd | Lck | Def | Bld | Mov |
-- | --- | --- | --- | --- | --- | --- | --- | --- |
${unit.hpGrowth} | ${unit.atkGrowth} | ${unit.magGrowth} | ${unit.sklGrowth} | ${unit.sklGrowth} | ${unit.spdGrowth} | ${unit.lckGrowth} | ${unit.defGrowth} | ${unit.bldGrowth} | ${unit.movGrowth} |

#### Weapon Proficiency

Weapon | Proficiency | Extra Ranks | Weapon | Proficiency | Extra Ranks |
------ | ----------- | ------------| ------ | ----------- | ------------|
Sword | ${unit.baseSwordLv.amount} | ${unit.baseSwordLv.name} | Fire | ${unit.baseFireLv.amount} | ${unit.baseFireLv.name} |
Lance | ${unit.baseLanceLv.amount} | ${unit.baseLanceLv.name} | Thunder | ${unit.baseThunderLv.amount} | ${unit.baseThunderLv.name} |
Axe | ${unit.baseAxeLv.amount} | ${unit.baseAxeLv.name} | Wind | ${unit.baseWindLv.amount} | ${unit.baseWindLv.name} |
Bow | ${unit.baseBowLv.amount} | ${unit.baseBowLv.name} | Light | ${unit.baseLightLv.amount} | ${unit.baseLightLv.name} |
Staff | ${unit.baseStaffLv.amount} | ${unit.baseStaffLv.name} | Dark | ${unit.baseDarkLv.amount} | ${unit.baseDarkLv.name} |

#### Skills

**Skills1:** *${unit.skills1?string.@hex_2}*, **Skills2:** *${unit.skills2?string.@hex_2}*, **Skills3:** *${unit.skills3?string.@hex_2}*

<#list unit.skills as skill>${skill.getName()}<#sep>, </#list>

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