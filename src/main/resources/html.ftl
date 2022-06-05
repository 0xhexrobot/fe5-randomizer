<#import "htmlMacros.ftl" as m>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Fire Emblem 5 randomizer log</title>
        <#if cssStyle??><style type="text/css">${cssStyle}</style></#if>
    </head>
    <body>
        <section id="header-section">
            <h1>Fire Emblem 5 Randomizer log</h1>

            <h2 id="index">Index</h2>
            <ul>
                <li><a href="#randomization-details">Randomization details</a></li>
                <li><a href="#units">Units</a></li>
                <li><a href="#portrait-palettes">Portrait palettes</a></li>
                <li><a href="#items">Items</a></li>
                <li><a href="#scrolls">Scrolls</a></li>
                <li><a href="#rewards">Rewards</a></li>
                <li><a href="#shops">Shops</a></li>
                <li><a href="#army-data">Army data</a></li>
            </ul>
        </section>
        <section id="summary-section">
            <h2 id="randomization-details">Randomization details</h2>

            <p>ROM: ${romName} <#if romHeadered>Headered<#else>Headerless</#if> <em>(${romChecksum})</em></p>

            <p>Seed: [${seed[0].getName()}][${seed[1].getName()}][${seed[2].getName()}][${seed[3].getName()}][${seed[4].getName()}][${seed[5].getName()}]</p>
            
            <#if summary.randomizeBases>
            <p>
                <em>Randomize bases</em> by
                <#if summary.basesRandomizationType == "variance">
                 <em>Variance</em>: <strong>±${summary.basesVariance}%</strong>
                <#elseif summary.basesRandomizationType == "redistribute">
                 <em>Redistribute</em>: <strong>±${summary.basesRedistributeVar}%</strong></#if>
            </p>
            </#if>
            
            <#if summary.randomizeGrowths>
            <p>
                <em>Randomize growths</em> by
                <#if summary.growthsRandomizationType == "variance">
                 <em>Variance</em>: <strong>±${summary.growthsVariance}%</strong>
                <#elseif summary.growthsRandomizationType == "redistribute">
                 <em>Redistribute</em>: <strong>±${summary.growthsRedistributeVar}%</strong>
                <#elseif summary.growthsRandomizationType == "absolute">
                 <em>Absolute</em>: <strong>[${summary.growthsAbsoluteMin}% - ${summary.growthsAbsoluteMax}%]</strong></#if>
            </p>
            </#if>
            
            <#if summary.randomizePlayableUnitClasses>
            <p>
                <em>Randomize playable unit classes</em>
                , <em>Exclude healers</em>: <strong><#if summary.excludeHealers>Yes<#else>No</#if></strong>
                , <em>Exclude thieves</em>: <strong><#if summary.excludeThieves>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.randomizeMovStars>
            <p>
                Randomize movement stars
                , Exclude units with zero stars: <strong><#if summary.movStarsExcludeZero>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.randomizeLeadershipStars>
            <p>
                Randomize leadership stars
                , Exclude units with zero stars: <strong><#if summary.leadershipExcludeZero>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.randomizeSkills>
            <p>
                Randomize skills
                , Max skill count: <strong>${summary.maxSkillCount}</strong>
            </p>
            </#if>
            
            <#if summary.randomizeEnemyUnitClasses>
            <p>
                Randomize enemy classes
                , Exclude bosses: <strong><#if summary.randomizeEnemyUnitClassesExcludeBosses>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.enemiesAddExtraInventory>
            <p>
                Add enemy inventory
                , add up to <strong>${summary.enemiesMaxExtraInventoryCount}</strong> items
            </p>
            </#if>
            
            <#if summary.randomizeEnemyMovStars>
            <p>
                Randomize enemy movement stars
                , Exclude units with zero stars: <strong><#if summary.enemyMovStarsExcludeZero>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.randomizeEnemyLeadershipStars>
            <p>
                Randomize enemy leadership stars
                , exclude units with zero stars: <strong><#if summary.enemyLeadershipExcludeZero>Yes<#else>No</#if></strong>
            </p>
            </#if>
            
            <#if summary.randomizeBossSkills>
            <p>Randomize Boss skills, max skill count: <strong>${summary.maxBossSkillCount}</strong></p>
            </#if>
            
            <#if summary.randomizeEnemySkills>
            <p>
                Randomize Enemy skills, max skill count: <strong>${summary.maxEnemySkillCount}</strong>
            </p>
            </#if>
            
            <#if summary.nerfBallistae><p>Nerf Ballistae</p></#if>
            
            <#if summary.randomizeWpnsMight
            || summary.randomizeWpnsAccuracy
            || summary.randomizeWpnsWeight
            || summary.randomizeWpnsCritical
            || summary.randomizeWpnsMaxUses
            || summary.randomizeWpnsCost
            || summary.wpnsAddBladeEffect
            || summary.wpnsAddStatBonus
            || summary.wpnsAddWeaponSkill>
            <p>Randomize items</p>
            <ul>
                <#if summary.randomizeWpnsMight><li>Might: <strong>±${summary.wpnsMightDelta}</strong></li></#if>
                <#if summary.randomizeWpnsAccuracy><li>Accuracy <strong>±${summary.wpnsAccuracyDelta}</strong></li></#if>
                <#if summary.randomizeWpnsWeight><li>Weight <strong>±${summary.wpnsWeightDelta}</strong></li></#if>
                <#if summary.randomizeWpnsCritical><li>Critical <strong>±${summary.wpnsCriticalDelta}</strong></li></#if>
                <#if summary.randomizeWpnsMaxUses><li>Max uses</li></#if>
                <#if summary.randomizeWpnsCost><li>Cost</li></#if>
                <#if summary.wpnsAddBladeEffect && summary.wpnsAvailableBladeEffects gt 0>
                <li>
                    Add Blade effect, chance: <strong>${summary.wpnsBladeEffectChance}%</strong>, available effects: <#list summary.wpnsAvailableBladeEffectsList as effect>
                    <strong>${effect.getName()}</strong><#sep>, <#else>None</#list>
                </li>
                </#if>
                <#if summary.wpnsAddStatBonus><li>Add stat bonus, chance: <strong>${summary.wpnsStatBonusChance}%</strong></li></#if>
                <#if summary.wpnsAddWeaponSkill>
                <li>
                    Add weapon skill, chance: <strong>${summary.wpnsSkillChance}%</strong>
                    , allow multiple skills: <strong><#if summary.wpnsAllowMultipleWeaponSkills>Yes<#else>No</#if></strong>
                </li>
                </#if>
                <#if summary.wpnsExcludeIronWeapons
                && (summary.randomizeWpnsMight
	            || summary.randomizeWpnsAccuracy
	            || summary.randomizeWpnsWeight
	            || summary.randomizeWpnsCritical
	            || summary.randomizeWpnsMaxUses
	            || summary.randomizeWpnsCost
	            || summary.wpnsAddBladeEffect
	            || summary.wpnsAddStatBonus
	            || summary.wpnsAddWeaponSkill)><li>Exclude Iron weapons</li></#if>
            </ul>
            </#if>
            
            <#if summary.wpnsIncreaseUses || summary.wpnsDowngradeWindTome || summary.wpnsRemoveWeaponsPrfLocks>
            <p>Other item options:</p>
            <ul>
                <#if summary.wpnsIncreaseUses><li>Weapon increase uses</li></#if>
                <#if summary.wpnsDowngradeWindTome><li>Downgrade Wind tome</li></#if>
                <#if summary.wpnsRemoveWeaponsPrfLocks><li>Remove Prf locks</li></#if>
            </ul>
            </#if>
            
            <#if summary.randomizeRewards>
            <p>
                Randomize rewards,
                randomization type: <strong>${summary.rewardsRandomizationType}</strong>,
                <#if summary.rewardsRandomizationType != "shuffle">
                Safe scrolls: <strong><#if summary.rewardsSafeScrolls>Yes<#else>No</#if></strong>,
                Safe Knight Proofs: <strong><#if summary.rewardsSafeKnightProofs>Yes<#else>No</#if></strong>
                </#if>
            </p>
            </#if>
            
            <#if summary.randomizeShops>
            <p>
                Randomize shop items,
                randomization type: <strong>${summary.shopsRandomizationType}</strong>,
                <#if summary.shopsRandomizationType != "replace">
                maintain item count: <strong><#if summary.shopsMaintainItemCount>Yes<#else>No</#if></strong>
                </#if>
            </p>
            </#if>
            
            <#if summary.randomizeScrolls>
            <p>
                Randomize Scrolls, randomization type: <strong>${summary.scrollsRandomizationType}</strong>
            </p>
            </#if>

            <#if summary.shufflePalettes>
            <p>Shuffle palettes</p>
            </#if>
            
            <#if summary.lilMansterRenamePugi>
            <p>Lil' Manster: rename <em>Voulge</em> to <strong>Pugi</strong></p>
            </#if>
            
            <#if summary.projectExileRenamePugi>
            <p>Project Exile: rename <em>Bhuj</em> to <strong>Pugi</strong></p>
            </#if>
        </section>
        <section id="units-section">
            <h2 id="units">Units</h2>
            <ul>
                <#list units as unit>
                <li>
                    <a href="#${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")}">${unit.getName()}</a>
                </li>
                </#list>
            </ul>
            
            <#list units as unit>
            <section>
                <h3 id="${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")}">${unit.getName()}</h3>
                <em>Class</em> 
                <p>
                    <#if unit.oldValues["characterClass"]??>
                    <strong>${unit.characterClass.getName()}</strong><del>${unit.oldValues["characterClass"].getName()}</del>
                    <#else>
                    ${unit.characterClass.getName()}
                    </#if>
                </p>
                <em>Weapon Proficiency</em>
                <#if unit.getUsedOrUsesWeapons()>
                <ul>
                    <#if unit.oldValues["baseSwordLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Sword" oldValue=unit.oldValues["baseSwordLv"] newValue=unit.baseSwordLv.amount />
                    </li>
                    <#elseif unit.baseSwordLv.amount gt 0>
                    <li>Sword: ${unit.baseSwordLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseLanceLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Lance" oldValue=unit.oldValues["baseLanceLv"] newValue=unit.baseLanceLv.amount />
                    </li>
                    <#elseif unit.baseLanceLv.amount gt 0>
                    <li>Lance: ${unit.baseLanceLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseAxeLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Axe" oldValue=unit.oldValues["baseAxeLv"] newValue=unit.baseAxeLv.amount />
                    </li>
                    <#elseif unit.baseAxeLv.amount gt 0>
                    <li>Axe: ${unit.baseAxeLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseBowLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Bow" oldValue=unit.oldValues["baseBowLv"] newValue=unit.baseBowLv.amount />
                    </li>
                    <#elseif unit.baseBowLv.amount gt 0>
                    <li>Bow: ${unit.baseBowLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseStaffLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Staff" oldValue=unit.oldValues["baseStaffLv"] newValue=unit.baseStaffLv.amount />
                    </li>
                    <#elseif unit.baseStaffLv.amount gt 0>
                    <li>Staff: ${unit.baseStaffLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseFireLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Fire" oldValue=unit.oldValues["baseFireLv"] newValue=unit.baseFireLv.amount />
                    </li>
                    <#elseif unit.baseFireLv.amount gt 0>
                    <li>Fire: ${unit.baseFireLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseThunderLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Thunder" oldValue=unit.oldValues["baseThunderLv"] newValue=unit.baseThunderLv.amount />
                    </li>
                    <#elseif unit.baseThunderLv.amount gt 0>
                    <li>Thunder: ${unit.baseThunderLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseWindLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Wind" oldValue=unit.oldValues["baseWindLv"] newValue=unit.baseWindLv.amount />
                    </li>
                    <#elseif unit.baseWindLv.amount gt 0>
                    <li>Wind: ${unit.baseWindLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseLightLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Light" oldValue=unit.oldValues["baseLightLv"] newValue=unit.baseLightLv.amount />
                    </li>
                    <#elseif unit.baseLightLv.amount gt 0>
                    <li>Light: ${unit.baseLightLv.amount}</li>
                    </#if>
                    <#if unit.oldValues["baseDarkLv"]??>
                    <li>
                        <@m.wpnSkillDiff name="Dark" oldValue=unit.oldValues["baseDarkLv"] newValue=unit.baseDarkLv.amount />
                    </li>
                    <#elseif unit.baseDarkLv.amount gt 0>
                    <li>Dark: ${unit.baseDarkLv.amount}</li>
                    </#if>
                </ul>
                <#else>
                <p>--</p>
                </#if>
                <em>Bases/Growths<#if unit.hasRandomBases()><sup>* Has random bases</sup></#if></em>
                <table>
                    <tr>
                        <th>Stat</th>
                        <th>HP</th>
                        <th>Atk</th>
                        <th>Mag</th>
                        <th>Skl</th>
                        <th>Spd</th>
                        <th>Lck</th>
                        <th>Def</th>
                        <th>Bld</th>
                        <th>Mov</th>
                        <th>Lead *</th>
                        <th>Mov *</th>
                        <th>P Crit</th>
                    </tr>
                    <tr>
                        <th>Bases</th>
                        <td>
                            <#if unit.oldValues["baseHp"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseHp"] newValue=unit.baseHp />
                            <#else>
                            ${unit.baseHp}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseAtk"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseAtk"] newValue=unit.baseAtk />
                            <#else>
                            ${unit.baseAtk}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseMag"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseMag"] newValue=unit.baseMag />
                            <#else>
                            ${unit.baseMag}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseSkl"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseSkl"] newValue=unit.baseSkl />
                            <#else>
                            ${unit.baseSkl}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseSpd"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseSpd"] newValue=unit.baseSpd />
                            <#else>
                            ${unit.baseSpd}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseLck"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseLck"] newValue=unit.baseLck />
                            <#else>
                            ${unit.baseLck}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseDef"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseDef"] newValue=unit.baseDef />
                            <#else>
                            ${unit.baseDef}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseBld"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseBld"] newValue=unit.baseBld />
                            <#else>
                            ${unit.baseBld}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["baseMov"]??>
                            <@m.numDiff oldValue=unit.oldValues["baseMov"] newValue=unit.baseMov />
                            <#else>
                            ${unit.baseMov}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["leadershipStars"]??>
                            <@m.numDiff oldValue=unit.oldValues["leadershipStars"] newValue=unit.leadershipStars />
                            <#else>
                            ${unit.leadershipStars}
                            </#if>
                        </td>
                        <td><#if unit.oldValues["movementStars"]??>
                            <@m.numDiff oldValue=unit.oldValues["movementStars"].amount newValue=unit.movementStars.amount />
                            <#else>
                            ${unit.movementStars.amount}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["counterCritBoost"]??>
                            <@m.numDiff oldValue=unit.oldValues["counterCritBoost"] newValue=unit.counterCritBoost />
                            <#else>
                            ${unit.counterCritBoost}
                            </#if>
                        </td>
                    </tr>
                    <tr>
                        <th>Growths %</th>
                        <td>
                            <#if unit.oldValues["hpGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["hpGrowth"] newValue=unit.hpGrowth /> 
                            <#else>
                            ${unit.hpGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["atkGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["atkGrowth"] newValue=unit.atkGrowth />
                            <#else>
                            ${unit.atkGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["magGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["magGrowth"] newValue=unit.magGrowth />
                            <#else>
                            ${unit.magGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["sklGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["sklGrowth"] newValue=unit.sklGrowth />
                            <#else>
                            ${unit.sklGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["spdGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["spdGrowth"] newValue=unit.spdGrowth />
                            <#else>
                            ${unit.spdGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["lckGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["lckGrowth"] newValue=unit.lckGrowth />
                            <#else>
                            ${unit.lckGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["defGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["defGrowth"] newValue=unit.defGrowth />
                            <#else>
                            ${unit.defGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["bldGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["bldGrowth"] newValue=unit.bldGrowth />
                            <#else>
                            ${unit.bldGrowth}
                            </#if>
                        </td>
                        <td>
                            <#if unit.oldValues["movGrowth"]??>
                            <@m.numDiff oldValue=unit.oldValues["movGrowth"] newValue=unit.movGrowth />
                            <#else>
                            ${unit.movGrowth}
                            </#if>
                        </td>
                        <td>--</td>
                        <td>--</td>
                        <td>--</td>
                    </tr>
                </table>
                                
                <em>Skills</em>
                
                <#list unit.comparedSkills?filter(skillDiff -> !skillDiff.key.unknown)>
                <ul>
                    <#items as skillDiff>
                    <@m.skillDiff skill=skillDiff.key value=skillDiff.value />
                    </#items>
                </ul>
                <#else>
                <p>--</p>
                </#list>
            </section>
                
            </#list>
        </section>
        <section id="palettes-section">
            <h2 id="portrait-palettes">Portrait palettes</h2>
            <#list portraitPalettes>
            <ul>
                <#items as palette>
                <li>
                    <span>${palette.label}<span>(${palette.offset?string.@hex_2})</span>:</span>
                    <table>
                        <#if palette.modified>
                        <tr>
                            <th>New</th>
                            <#list palette.palette as i>
                            <td style="background-color: #${i.toRgbString()};"></td>
                            </#list>
                        </tr>
                        <tr>
                            <th>Old</th>
                            <#list palette.oldPalette as i>
                            <td style="background-color: #${i.toRgbString()};"></td>
                        </#list>
                        </tr>
                        <#else>
                        <tr>
                            <#list palette.palette as i>
                            <td style="background-color: #${i.toRgbString()};"></td>
                            </#list>
                        </tr>
                        </#if>
                    </table>
                </li>
                </#items>
            </ul>
            </#list>
        </section>
        <section id="items-section">
            <h2 id="items">Items</h2>
            <#list items?filter(item -> item.modified)>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Mt</th>
                    <th>Acc</th>
                    <th>Wt</th>
                    <th>Crt</th>
                    <th>Rank</th>
                    <th>Uses</th>
                    <th>Skills</th>
                    <th>Blade Eff</th>
                    <th>Cost per use</th>
                    <th>Stat bonus</th>
                </tr>        
                <#items as item>
                <tr>
                    <td>${item.getName()}</td>
                    <td>
                        <#if item.oldValues["power"]??>
                        <@m.numDiff oldValue=item.oldValues["power"] newValue=item.power />
                        <#else>
                        ${item.power}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["accuracy"]??>
                        <@m.numDiff oldValue=item.oldValues["accuracy"] newValue=item.accuracy />
                        <#else>
                        ${item.accuracy}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["weight"]??>
                        <@m.numDiff oldValue=item.oldValues["weight"] newValue=item.weight />
                        <#else>
                        ${item.weight}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["critical"]??>
                        <@m.numDiff oldValue=item.oldValues["critical"] newValue=item.critical />
                        <#else>
                        ${item.critical}
                        </#if> 
                    </td>
                    <td>
                        <#if item.oldValues["weaponRank"]??>
                        <strong>${item.weaponRank.shortName}</strong><del>${item.oldValues["weaponRank"].shortName}</del>
                        <#else>
                        ${item.weaponRank.shortName}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["maxUses"]??>
                        <@m.numDiff oldValue=item.oldValues["maxUses"] newValue=item.maxUses />
                        <#else>
                        ${item.maxUses}
                        </#if>
                    </td>
                    <td>
                        <#list item.comparedSkills>
                        <ul>
                            <#items as skillDiff>
                            <#if skillDiff.value gt 0>
                            <ins><li>${skillDiff.key.getName()}</li></ins>
                            <#elseif skillDiff.value lt 0>
                            <del><li>${skillDiff.key.getName()}</li></del>
                            <#else>
                            <li>${skillDiff.key.getName()}</li>
                            </#if>
                            </#items>
                        </ul>
                        <#else>
                        --
                        </#list>
                    </td>
                    <td>
                        <#if item.oldValues["weaponBladeEffect"]??>
                        <strong>${item.weaponBladeEffect.getName()}</strong>
                        <#else>
                        ${item.weaponBladeEffect.getName()}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["costPerUse"]??>
                        <@m.numDiff oldValue=item.oldValues["costPerUse"] newValue=item.costPerUse />
                        <#else>
                        ${item.costPerUse}
                        </#if>
                    </td>
                    <td>
                        <#if item.oldValues["weaponStatBonus"]??>
                        <strong>${item.weaponStatBonus.getName()}</strong>
                        <#else>
                        ${item.weaponStatBonus.shortName}
                        </#if>
                    </td>                
                </tr>
                </#items>
            </table>
            <#else>
            <p>No changes</p>
            </#list>
        </section>
        <section id="scrolls-section">
            <h2 id="scrolls">Scrolls</h2>
            <table>
                <tr>
                    <th>Scroll name</th>
                    <th>Hp</th>
                    <th>Atk</th>
                    <th>Mag</th>
                    <th>Skl</th>
                    <th>Spd</th>
                    <th>Lck</th>
                    <th>Def</th>
                    <th>Bld</th>
                    <th>Mov</th>
                </tr>
                <#list scrolls as scroll>
                <tr>
                    <td>${scroll.getName()}</td>
                    <td>
                        <#if scroll.oldValues["hp"]??>
                        <@m.numDiff oldValue=scroll.oldValues["hp"] newValue=scroll.hp />
                        <#else>
                        ${scroll.hp}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["atk"]??>
                        <@m.numDiff oldValue=scroll.oldValues["atk"] newValue=scroll.atk />
                        <#else>
                        ${scroll.atk}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["mag"]??>
                        <@m.numDiff oldValue=scroll.oldValues["mag"] newValue=scroll.mag />
                        <#else>
                        ${scroll.mag}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["skl"]??>
                        <@m.numDiff oldValue=scroll.oldValues["skl"] newValue=scroll.skl />
                        <#else>
                        ${scroll.skl}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["spd"]??>
                        <@m.numDiff oldValue=scroll.oldValues["spd"] newValue=scroll.spd />
                        <#else>
                        ${scroll.spd}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["lck"]??>
                        <@m.numDiff oldValue=scroll.oldValues["lck"] newValue=scroll.lck />
                        <#else>
                        ${scroll.lck}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["def"]??>
                        <@m.numDiff oldValue=scroll.oldValues["def"] newValue=scroll.def />
                        <#else>
                        ${scroll.def}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["bld"]??>
                        <@m.numDiff oldValue=scroll.oldValues["bld"] newValue=scroll.bld />
                        <#else>
                        ${scroll.bld}
                        </#if>
                    </td>
                    <td>
                        <#if scroll.oldValues["mov"]??>
                        <@m.numDiff oldValue=scroll.oldValues["mov"] newValue=scroll.mov />
                        <#else>
                        ${scroll.mov}
                        </#if>
                    </td>
                </tr>
                </#list>
            </table>            
        </section>
        <section id="rewards-section">
            <#if summary.randomizeRewards>
            <h2 id="rewards">Rewards</h2>
            <h3>Event rewards</h3>
            <ul>
                <#list eventRewards as reward>
                <li>
                    <#if reward.isModified()>
                    <del>${reward.getName()}</del> -> <ins>${reward.item.getName()}</ins>
                    <#else>
                    <span>${reward.getName()}</span>
                    </#if>
                </li>
                </#list>
            </ul>
            
            <h3>Chest rewards</h3>
            <ul>
                <#list chestRewards as reward>
                <li>
                    <#if reward.isModified()>
                    <del>${reward.getName()}</del> -> <ins>${reward.item.getName()}</ins>
                    <#else>
                    <span>${reward.getName()}</span>
                    </#if>
                </li>
                </#list>
            </ul>
            
            <h3>House rewards</h3>
            <ul>
                <#list houseRewards as reward>
                <li>
                    <#if reward.isModified()>
                    <del>${reward.getName()}</del> -> <ins>${reward.item.getName()}</ins>
                    <#else>
                    <span>${reward.getName()}</span>
                    </#if>
                </li>
                </#list>
            </ul>
            
            </#if>
        </section>
        <section id="shops-section">
            <h2 id="shops">Shops</h2>
            <#list shops as shop>
            <section>
                <div>${shop.getName()}</div>
                <div>
                    <#list shop.comparedItems>
                    <ul>
                        <#items as itemDiff>
                        <#if itemDiff.value gt 0>
                        <ins><li>${itemDiff.key.getName()}<em>${itemDiff.key.totalCost}</em></li></ins>
                        <#elseif itemDiff.value lt 0>
                        <del><li>${itemDiff.key.getName()}<em>${itemDiff.key.totalCost}</em></li></del>
                        <#else>
                        <li>${itemDiff.key.getName()}<em>${itemDiff.key.totalCost}</em></li>
                        </#if>
                        </#items>
                    </ul>
                    </#list>
                </div>
            </section>
            </#list>
        </section>
        <section id="army-data-section">
            <h2 id="army-data">Army data</h2>
            <#list chapterData>
            <ul>
                <#items as chapter>
                <li><a href="#${chapter.shortName}">${chapter.getName()}</a></li>
                </#items>
            </ul>
            </#list>
            <#list chapterData as chapter>
            <h3 id="${chapter.shortName}">${chapter.getName()}</h3>
            <@m.map chapter=chapter />
            <#list chapter.getArmyData() as unit>
            <section>
	            <div id="${chapter.shortName}-${unit?index+1}"><p><strong>#${unit?index+1}</strong></p></div>
	            <div>
	               <em>${unit.character.getName()}</em>
	               <p>
	                   <#if unit.character.oldValues["characterClass"]??>
	                    <strong>${unit.character.characterClass.getName()}</strong><del>${unit.character.oldValues["characterClass"].getName()}</del>
	                    <#else>
	                    ${unit.character.characterClass.getName()}
	                    </#if>
	               </p>
	            </div>
	            <div>
	               <p>Lv<strong>${unit.level}<#if unit.autoLeveled>*</#if></strong></p>
	            </div>
	            <div>
	               <#list unit.comparedInventory>
	                <ul>
	                    <#items as itemDiff>
	                    <#if itemDiff.value gt 0>
	                    <ins><li>${itemDiff.key.getName()}</li></ins>
	                    <#elseif itemDiff.value lt 0>
	                    <del><li>${itemDiff.key.getName()}</li></del>
	                    <#else>
	                    <li>${itemDiff.key.getName()}</li>
	                    </#if>
	                    </#items>
	                </ul>
	                <#else>
	                <p>--</p>
	                </#list>
	            </div>
            </section>
            </#list>
            </#list>
        </section>
    </body>
</html>