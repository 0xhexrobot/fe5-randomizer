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
${unit.baseHp} | ${unit.baseAtk} | ${unit.baseMag} | ${unit.baseSkl} | ${unit.baseSpd} | ${unit.baseLck} | ${unit.baseDef} | ${unit.baseBld} | ${unit.baseMov} | ${unit.leadershipStars} | ${unit.movementStars.ammount} | ${unit.counterCritBoost} |

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