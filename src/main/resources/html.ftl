<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>Fire Emblem 5 randomizer log</title>
	    <#if cssStyle??><style type="text/css">${cssStyle}</style></#if>
	</head>
	<body>
	    <h1>Fire Emblem 5 Randomizer log</h1>
		
		<section>
			<h2>Randomization details</h2>
			<p>
			ROM: ${romName} <#if romHeadered>
			Headered
			<#else>
			Headerless
			</#if> <i>(${romChecksum})</i>
			</p>
			
			<p>Seed: [${seed[0].getName()}][${seed[1].getName()}][${seed[2].getName()}][${seed[3].getName()}][${seed[4].getName()}][${seed[5].getName()}]</p>
					
			<p>
				Randomize bases: <#if summary.randomizeBases><b>Yes</b><#else>No</#if>
				<#if summary.randomizeBases>, by <#if summary.basesRandomizationType == "variance">
				<b>Variance</b>: <b>±${summary.basesVariance}%</b>
				<#elseif summary.basesRandomizationType == "redistribute">
				<b>Redistribute</b>: <b>±${summary.basesRedistributeVar}%</b></#if></#if>
			</p>
			
			<p>
				Randomize growths: <#if summary.randomizeGrowths><b>Yes</b><#else>No</#if>
				<#if summary.randomizeGrowths>, by <#if summary.growthsRandomizationType == "variance">
				<b>Variance</b>: <b>±${summary.growthsVariance}%</b>
				<#elseif summary.growthsRandomizationType == "redistribute">
				<b>Redistribute</b>: <b>±${summary.growthsRedistributeVar}%</b>
				<#elseif summary.growthsRandomizationType == "absolute">
				<b>Absolute</b>: [<b>${summary.growthsAbsoluteMin}%</b> - <b>${summary.growthsAbsoluteMax}%</b>]</#if></#if>
			</p>
			
			<p>
				Randomize playable unit classes: <#if summary.randomizePlayableUnitClasses>
				<b>Yes</b>, Exclude healers: <#if summary.excludeHealers><b>Yes</b><#else>No</#if>
				, Exclude thieves: <#if summary.excludeThieves><b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize movement stars: <#if summary.randomizeMovStars>
				<b>Yes</b>, Exclude units with zero stars: <#if summary.movStarsExcludeZero>
				<b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize leadership stars: <#if summary.randomizeLeadershipStars>
				<b>Yes</b>, Exclude units with zero stars: <#if summary.leadershipExcludeZero>
				<b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize skills: <#if summary.randomizeSkills>
				<b>Yes</b>, Max skill count: ${summary.maxSkillCount}
				<#else>No</#if>
			</p> 
			
			<p>
				Randomize enemy classes: <#if summary.randomizeEnemyUnitClasses>
				<b>Yes</b>, Exclude bosses: <#if summary.randomizeEnemyUnitClassesExcludeBosses>
				<b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Add enemy inventory: <#if summary.enemiesAddExtraInventory>
				<b>Yes</b>, Max new items: ${summary.enemiesMaxExtraInventoryCount}
				<#else>No</#if>
			</p>
			
			<p>
				Randomize enemy movement stars: <#if summary.randomizeEnemyMovStars>
				<b>Yes</b>, Exclude units with zero stars: <#if summary.enemyMovStarsExcludeZero>
				<b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize enemy leadership stars: <#if summary.randomizeEnemyLeadershipStars>
				<b>Yes</b>, Exclude units with zero stars: <#if summary.enemyLeadershipExcludeZero>
				<b>Yes</b><#else>No</#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize Boss skills: <#if summary.randomizeBossSkills>
				<b>Yes</b>, Max skill count: ${summary.maxBossSkillCount}<#else> No</#if>
				, Randomize Enemy skills: <#if summary.randomizeEnemySkills>
				<b>Yes</b>, Max skill count: ${summary.maxEnemySkillCount}<#else>No</#if>
			</p>
			
			<p>Nerf Ballistae: <#if summary.nerfBallistae><b>Yes</b><#else>No</#if></p>
			
			<p>Randomize items:</p>
			<ul>
				<#if summary.randomizeWpnsMight><li>Might: <b>±${summary.wpnsMightDelta}</b></li></#if>
				<#if summary.randomizeWpnsAccuracy><li>Accuracy <b>±${summary.wpnsAccuracyDelta}</b></li></#if>
				<#if summary.randomizeWpnsWeight><li>Weight <b>±${summary.wpnsWeightDelta}</b></li></#if>
				<#if summary.randomizeWpnsCritical><li>Critical <b>±${summary.wpnsCriticalDelta}</b></li></#if>
				<#if summary.randomizeWpnsMaxUses><li>Max uses</li></#if>
				<#if summary.randomizeWpnsCost><li>Cost</li></#if>
				<#if summary.wpnsAddBladeEffect>
				<li>
					Add Blade effect, chance: <b>${summary.wpnsBladeEffectChance}%</b>, available effects: <#list summary.wpnsAvailableBladeEffectsList as effect>
					<b>${effect.getName()}</b><#sep>, <#else>None</#list>
				</li>
				</#if>
				<#if summary.wpnsAddStatBonus><li>Add stat bonus, chance: <b>${summary.wpnsStatBonusChance}%</b></li></#if>
				<#if summary.wpnsAddWeaponSkill>
				<li>	
					Add weapon skill: chance: <b>${summary.wpnsSkillChance}%</b>, allow multiple skills: <#if summary.wpnsAllowMultipleWeaponSkills>
					<b>Yes</b><#else>No</#if>
				</li>	
				</#if>
				<#if summary.wpnsExcludeIronWeapons><li>Exclude Iron weapons</li></#if>
			</ul> 
			
			<#if summary.wpnsIncreaseUses || summary.wpnsDowngradeWindTome || summary.wpnsRemoveWeaponsPrfLocks>
			<p>Other item options:</p>
			<ul>
				<#if summary.wpnsIncreaseUses><li>Weapon increase uses</li></#if>
				<#if summary.wpnsDowngradeWindTome><li>Downgrade Wind tome</li></#if>
				<#if summary.wpnsRemoveWeaponsPrfLocks><li>Remove Prf locks</li></#if>
			</ul>
			</#if>
			
			<p>
				Randomize rewards: <#if summary.randomizeRewards>
				<b>Yes</b>, randomization type: ${summary.rewardsRandomizationType}
				<#if summary.rewardsRandomizationType != "shuffle">
				, Safe scrolls: <#if summary.rewardsSafeScrolls>
				<b>Yes</b><#else>No</#if>
				, Safe Knight Proofs: <#if summary.rewardsSafeKnightProofs>
				<b>Yes</b><#else>No</#if></#if>
				<#else>No</#if>
			</p>
			
			<p>
				Randomize shop items: <#if summary.randomizeShops>
				<b>Yes</b>, randomization type: ${summary.shopsRandomizationType}
				<#else>No</#if>
				<#if summary.shopsRandomizationType != "replace">
				, maintain item count: <#if summary.shopsMaintainItemCount><b>Yes</b><#else>No</#if></#if>
			</p>
			
			<p>
				Randomize Scrolls: <#if summary.randomizeScrolls>
				<b>Yes</b>, randomization type: ${summary.scrollsRandomizationType}
				<#else>No</#if>
			</p>
			
			<#if summary.lilMansterRenamePugi>
			<p>Lil' Manster</p>
			<p>Rename <i>Voulge</i> to <i><b>Pugi</b></i></p>
			</#if>
			
			<#if summary.projectExileRenamePugi>
			<p>Project Exile</p>
			<p>Rename <i>Bhuj</i> to <i><b>Pugi</b></i></p>
			</#if>
		</section>		
		<section>
			<#if units??>
			<h2>Units</h2>
			
			<ul>
				<#list units as unit>
				<li>
					<a href="#${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")}">${unit.getName()}</a>
				</li>
				</#list>
			</ul>
			
			<#list units as unit>
			<h3 id="${unit.getName()?replace(" ", "-")?replace("(", "")?replace(")", "")}">${unit.getName()}</h3>
			
			<p>
				<b>Class:</b> <#if unit.oldValues["characterClass"]??>
				${unit.oldValues["characterClass"].getName()} <i>(${unit.oldValues["characterClass"].offset?string.@hex_2})</i> -> <b>${unit.characterClass.getName()} <i>(${unit.characterClass.offset?string.@hex_2})</i></b>
				<#else>${unit.characterClass.getName()} <i>(${unit.characterClass.offset?string.@hex_2})</i></#if>
			</p>
			
			<h4>Bases</h4>
			<table>
				<tr>
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
					<td>
						<#if unit.oldValues["baseHp"]??>
						${unit.oldValues["baseHp"]} -> <b>${unit.baseHp}</b>
						<#else>
						${unit.baseHp}</#if>
					</td>
					<td>
						<#if unit.oldValues["baseAtk"]??>
						${unit.oldValues["baseAtk"]} -> <b>${unit.baseAtk}</b>
						<#else>
						${unit.baseAtk}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseMag"]??>
						${unit.oldValues["baseMag"]} -> <b>${unit.baseMag}</b>
						<#else>
						${unit.baseMag}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseSkl"]??>
						${unit.oldValues["baseSkl"]} -> <b>${unit.baseSkl}</b>
						<#else>
						${unit.baseSkl}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseSpd"]??>
						${unit.oldValues["baseSpd"]} -> <b>${unit.baseSpd}</b>
						<#else>
						${unit.baseSpd}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseLck"]??>
						${unit.oldValues["baseLck"]} -> <b>${unit.baseLck}</b>
						<#else>
						${unit.baseLck}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseDef"]??>
						${unit.oldValues["baseDef"]} -> <b>${unit.baseDef}</b>
						<#else>
						${unit.baseDef}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseBld"]??>
						${unit.oldValues["baseBld"]} -> <b>${unit.baseBld}</b>
						<#else>
						${unit.baseBld}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["baseMov"]??>
						${unit.oldValues["baseMov"]} -> <b>${unit.baseMov}</b>
						<#else>
						${unit.baseMov}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["leadershipStars"]??>
						${unit.oldValues["leadershipStars"]} -> <b>${unit.leadershipStars}</b>
						<#else>
						${unit.leadershipStars}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["movementStars"]??>
						${unit.oldValues["movementStars"].amount} -> <b>${unit.movementStars.amount}</b>
						<#else>
						${unit.movementStars.amount}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["counterCritBoost"]??>
						${unit.oldValues["counterCritBoost"]} -> <b>${unit.counterCritBoost}</b>
						<#else>
						${unit.counterCritBoost}
						</#if>
					</td>
				</tr>
			</table>
			
			<#if unit.hasRandomBases()><p><i>(Random bases)</i></p></#if>
			
			<h4>Growths</h4>
			
			<table>
				<tr>
					<th>HP</th>
					<th>Atk</th>
					<th>Mag</th>
					<th>Skl</th>
					<th>Spd</th>
					<th>Lck</th>
					<th>Def</th>
					<th>Bld</th>
					<th>Mov</th>
				</tr>
				<tr>
					<td>
						<#if unit.oldValues["hpGrowth"]??>
						${unit.oldValues["hpGrowth"]} -> <b>${unit.hpGrowth}</b>
						<#else>
						${unit.hpGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["atkGrowth"]??>
						${unit.oldValues["atkGrowth"]} -> <b>${unit.atkGrowth}</b>
						<#else>
						${unit.atkGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["magGrowth"]??>
						${unit.oldValues["magGrowth"]} -> <b>${unit.magGrowth}</b>
						<#else>
						${unit.magGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["sklGrowth"]??>
						${unit.oldValues["sklGrowth"]} -> <b>${unit.sklGrowth}</b>
						<#else>
						${unit.sklGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["spdGrowth"]??>
						${unit.oldValues["spdGrowth"]} -> <b>${unit.spdGrowth}</b>
						<#else>
						${unit.spdGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["lckGrowth"]??>
						${unit.oldValues["lckGrowth"]} -> <b>${unit.lckGrowth}</b>
						<#else>
						${unit.lckGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["defGrowth"]??>
						${unit.oldValues["defGrowth"]} -> <b>${unit.defGrowth}</b>
						<#else>
						${unit.defGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["bldGrowth"]??>
						${unit.oldValues["bldGrowth"]} -> <b>${unit.bldGrowth}</b>
						<#else>
						${unit.bldGrowth}
						</#if>
					</td>
					<td>
						<#if unit.oldValues["movGrowth"]??>
						${unit.oldValues["movGrowth"]} -> <b>${unit.movGrowth}</b>
						<#else>
						${unit.movGrowth}
						</#if>
					</td>
				</tr>
			</table>
			
			<h4>Weapon Proficiency</h4>
			
			<table>
				<tr>
					<th>Weapon</th>
					<th>Proficiency</th>
					<th>Extra Ranks</th>
					<th>Weapon</th>
					<th>Proficiency</th>
					<th>Extra Ranks</th>
				</tr>
				<tr>
					<td>Sword</td>
					<td>
						<#if unit.oldValues["baseSwordLv"]??>
						${unit.oldValues["baseSwordLv"]} -> <b>${unit.baseSwordLv.amount}</b>
						<#else>
						${unit.baseSwordLv.amount}
						</#if>
					</td>
					<td>${unit.baseSwordLv.name}</td>
					<td>Fire</td>
					<td>
						<#if unit.oldValues["baseFireLv"]??>
						${unit.oldValues["baseFireLv"]} -> <b>${unit.baseFireLv.amount}</b>
						<#else>
						${unit.baseFireLv.amount}
						</#if>
					</td>
					<td>${unit.baseFireLv.name}</td>
				</tr>
				<tr>
					<td>Lance</td>
					<td>
						<#if unit.oldValues["baseLanceLv"]??>
						${unit.oldValues["baseLanceLv"]} -> <b>${unit.baseLanceLv.amount}</b>
						<#else>
						${unit.baseLanceLv.amount}
						</#if>
					</td>
					<td>${unit.baseLanceLv.name}</td>
					<td>Thunder</td>
					<td>
						<#if unit.oldValues["baseThunderLv"]??>
						${unit.oldValues["baseThunderLv"]} -> <b>${unit.baseThunderLv.amount}</b>
						<#else>
						${unit.baseThunderLv.amount}
						</#if>
					</td>
					<td>${unit.baseThunderLv.name}</td>
				</tr>
				<tr>
					<td>Axe</td>
					<td>
						<#if unit.oldValues["baseAxeLv"]??>
						${unit.oldValues["baseAxeLv"]} -> <b>${unit.baseAxeLv.amount}</b>
						<#else>
						${unit.baseAxeLv.amount}
						</#if>
					</td>
					<td>${unit.baseAxeLv.name}</td>
					<td>Wind</td>
					<td>
						<#if unit.oldValues["baseWindLv"]??>
						${unit.oldValues["baseWindLv"]} -> <b>${unit.baseWindLv.amount}</b>
						<#else>
						${unit.baseWindLv.amount}
						</#if>
					</td>
					<td>${unit.baseWindLv.name}</td>
				</tr>
				<tr>
					<td>Bow</td>
					<td>
						<#if unit.oldValues["baseBowLv"]??>
						${unit.oldValues["baseBowLv"]} -> <b>${unit.baseBowLv.amount}</b>
						<#else>
						${unit.baseBowLv.amount}
						</#if>
					</td>
					<td>${unit.baseBowLv.name}</td>
					<td>Light</td>
					<td>
						<#if unit.oldValues["baseLightLv"]??>
						${unit.oldValues["baseLightLv"]} -> <b>${unit.baseLightLv.amount}</b>
						<#else>
						${unit.baseLightLv.amount}
						</#if>
					</td>
					<td>${unit.baseLightLv.name}</td>
				</tr>
				<tr>
					<td>Staff</td>
					<td>
						<#if unit.oldValues["baseStaffLv"]??>
						${unit.oldValues["baseStaffLv"]} -> <b>${unit.baseStaffLv.amount}</b>
						<#else>
						${unit.baseStaffLv.amount}
						</#if>
					</td>
					<td>${unit.baseStaffLv.name}</td>
					<td>Dark</td>
					<td>
						<#if unit.oldValues["baseDarkLv"]??>
						${unit.oldValues["baseDarkLv"]} -> <b>${unit.baseDarkLv.amount}</b>
						<#else>
						${unit.baseDarkLv.amount}
						</#if>
					</td>
					<td>${unit.baseDarkLv.name}</td>
				</tr>
			</table>
			
			<h4>Skills</h4>
			<#list unit.comparedSkills>
			<ul>
				<#items as skillDiff>
				<li>${skillDiff.key.getName()} (${skillDiff.value})</li>
				</#items>
			</ul>
			
			</#list>
			
			</#list>
			</#if>
			
		</section>
		<section>
			<#if items??>
			<h2>Items</h2>
			<table>
				<tr>
					<th>Name</th>
					<th>Mt</th>
					<th>Acc</th>
					<th>Wt</th>
					<th>Crt</th>
					<th>Rng</th>
					<th>Rank</th>
					<th>Uses</th>
					<th>Skills</th>
					<th>Blade Eff</th>
					<th>Cost per use</th>
					<th>Stat bonus</th>
				</tr>		
				<#list items as item>
				<tr>
					<td>${item.getName()}</td>
					<td>
						<#if item.oldValues["power"]??>
						${item.oldValues["power"]} -> <b>${item.power}</b>
						<#else>
						${item.power}
						</#if>
					</td>
					<td>
						<#if item.oldValues["accuracy"]??>
						${item.oldValues["accuracy"]} -> <b>${item.accuracy}</b>
						<#else>
						${item.accuracy}
						</#if>
					</td>
					<td>
						<#if item.oldValues["weight"]??>
						${item.oldValues["weight"]} -> <b>${item.weight}</b>
						<#else>
						${item.weight}
						</#if>
					</td>
					<td>
						<#if item.oldValues["critical"]??>
						${item.oldValues["critical"]} -> <b>${item.critical}</b>
						<#else>
						${item.critical}
						</#if> 
					</td>
					<td>
						<#if item.oldValues["weaponRange"]??>
						${item.olValues["weaponRange"].getName()} -> <b>${item.weaponRange.getName()}</b>
						<#else>
						${item.weaponRange.getName()}
						</#if>
					</td>
					<td>
						<#if item.oldValues["weaponRank"]??>
						${item.oldValues["weaponRank"].getName()} -> <b>${item.weaponRank.getName()}</b>
						<#else>
						${item.weaponRank.getName()}
						</#if>
					</td>
					<td>
						<#if item.oldValues["maxUses"]??>
						${item.oldValues["maxUses"]} -> <b>${item.maxUses}</b>
						<#else>
						${item.maxUses}
						</#if>
					</td>
					<td>
						<#list item.comparedSkills>
						<ul>
							<#items as skillDiff>
							<li>${skillDiff.key.getName()} (${skillDiff.value})</li>
							</#items>
						</ul>
						</#list>
					</td>
					<td>
						<#if item.oldValues["weaponBladeEffect"]??>
						${item.oldValues["weaponBladeEffect"].getName()} -> <b>${item.weaponBladeEffect.getName()}</b>
						<#else>
						${item.weaponBladeEffect.getName()}
						</#if>
					</td>
					<td>
						<#if item.oldValues["costPerUse"]??>
						${item.oldValues["costPerUse"]} -> <b>${item.costPerUse}</b>
						<#else>
						${item.costPerUse}
						</#if>
					</td>
					<td>
						<#if item.oldValues["weaponStatBonus"]??>
						${item.oldValues["weaponStatBonus"].getName()} -> <b>${item.weaponStatBonus.getName()}</b>
						<#else>
						${item.weaponStatBonus.getName()}
						</#if>
					</td>				
				</tr>
				</#list>
			</table>
			</#if>
		</section>
		<section>
			<h2>Scrolls</h2>
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
					<td>
						<#if scroll.modified>
						<b>${scroll.getName()}</b>
						<#else>
						${scroll.getName()}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["hp"]??>
						${scroll.oldValues["hp"]} -> <b>${scroll.hp}</b>
						<#else>
						${scroll.hp}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["atk"]??>
						${scroll.oldValues["atk"]} -> <b>${scroll.atk}</b>
						<#else>
						${scroll.atk}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["mag"]??>
						${scroll.oldValues["mag"]} -> <b>${scroll.mag}</b>
						<#else>
						${scroll.mag}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["skl"]??>
						${scroll.oldValues["skl"]} -> <b>${scroll.skl}</b>
						<#else>
						${scroll.skl}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["spd"]??>
						${scroll.oldValues["spd"]} -> <b>${scroll.spd}</b>
						<#else>
						${scroll.spd}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["lck"]??>
						${scroll.oldValues["lck"]} -> <b>${scroll.lck}</b>
						<#else>
						${scroll.lck}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["def"]??>
						${scroll.oldValues["def"]} -> <b>${scroll.def}</b>
						<#else>
						${scroll.def}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["bld"]??>
						${scroll.oldValues["bld"]} -> <b>${scroll.bld}</b>
						<#else>
						${scroll.bld}
						</#if>
					</td>
					<td>
						<#if scroll.oldValues["mov"]??>
						${scroll.oldValues["mov"]} -> <b>${scroll.mov}</b>
						<#else>
						${scroll.mov}
						</#if>
					</td>
				</tr>
				</#list>
			</table>			
		</section>
		<section>
			<#if summary.randomizeRewards>
			<h2>Rewards</h2>
			<h3>Event rewards</h3>
			<ul>
				<#list eventRewards as event>
				<li>${event.getName()} <#if event.isModified()>-> <b>${event.item.getName()}</b></#if></li>
				</#list>
			</ul>
			
			<h3>Chest rewards</h3>
			<ul>
				<#list chestRewards as chest>
				<li>${chest.getName()} <#if chest.isModified()>-> <b>${chest.item.getName()}</b></#if></li>
				</#list>
			</ul>
			
			<h3>House rewards</h3>
			<ul>
				<#list houseRewards as house>
				<li>${house.getName()} <#if house.isModified()>-> <b>${house.item.getName()}</b></#if></li>
				</#list>
			</ul>
			
			</#if>
			
			<h2>Shops</h2>
			<#list shops as shop>
			<table>
				<tr>
					<th>${shop.getName()}</th>
				</tr>
				<#list shop.comparedItems as itemDiff>
				<tr>
					<td>
						${itemDiff.key.getName()} ${itemDiff.key.totalCost} (${itemDiff.value})
					</td>
				</tr>
				</#list>
			</table>
			</#list>
		</section>
		<section>
			<#if chapterData??>
			<h2>Army data</h2>
			
			<#list chapterData as chapter>
			
			<h3>${chapter.getName()}</h3>
			
			<#list chapter.getArmyData() as unit>
			<p>
				<b>Character</b>: ${unit.character.getName()}(${unit.character.offset?string.@hex_4}) <#if unit.character.oldValues["characterClass"]??> -> <b>${unit.character.characterClass.getName()}</b></#if>
			</p>
			
			<p>
				X: ${unit.getXCoord()}, Y: ${unit.getYCoord()}, Army: ${unit.armyOrigin?string.@hex_4}, Level: ${unit.level}<#if unit.autoLeveled>(A)</#if>,		
			</p>
			
			<p>Inventory</p>
			<#list unit.comparedInventory>
			<ul>
				<#items as itemDiff>
				<li>${itemDiff.key.getName()} (${itemDiff.value})</li>
				</#items>
			</ul>
			<#else>
			<p><i>Empty</i></p>
			</#list>
			
			<p>Unknown1: ${unit.unknown1?string.@hex_2}, Unknown2: ${unit.unknown2?string.@hex_2}, Unknown3: ${unit.unknown3?string.@hex_2}, Unknown4: ${unit.unknown4?string.@hex_2}</p>
			
			<p>--------------</p>
			
			</#list>
			
			</#list>
			
			</#if>
		
		</section>
	</body>
</html>