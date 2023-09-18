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

<#macro map chapter>
<table class="map">
    <#assign count = 1 />
    <#list 1 .. chapter.height as y>
    <tr>
        <#list 1 .. chapter.width as x>
        <#assign foundUnit = false />
        <#list chapter.getArmyData() as unit>
        <#if unit.getXCoord() == x?index && unit.getYCoord() == y?index>
        <td class="unit"><a href="#${chapter.shortName}-${count}">##{count}</a></td>
        <#assign count = count + 1>
        <#assign foundUnit = true />
        <#break>
        </#if>
        </#list>
        <#if !foundUnit><td></td></#if>
        </#list>
    </tr>
    </#list>
</table>
</#macro>