<#macro numDiff oldValue newValue>
<#assign diff = newValue - oldValue>
<strong>${newValue}</strong>
<#if diff gt 0><ins>+${diff}</ins><#else><del>${diff}</del></#if>
</#macro>

<#macro wpnSkillDiff name oldValue newValue>
<#assign diff = newValue - oldValue />
${name}: <strong>${newValue}</strong>
<#if diff gt 0><ins>+${diff}</ins><#else><del>${diff}</del></#if>
</#macro>

<#macro skillDiff skill value>
<#if value gt 0>
<ins><li>${skill.getName()}</li></ins>
<#elseif value lt 0>
<del><li>${skill.getName()}</li></del>
<#else>
<li>${skill.getName()}</li>
</#if>
</#macro>
