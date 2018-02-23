<h1 class="module">ClearLayers</h1>

## Synopsis

Completely remove layers from sections.

## Description

*ClearLayers* removes the layers named after <a href="#layerNames" class="param">layerNames</a> from sections.

## Parameters

<a name="layerNames">

### layerNames

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String[]" class="converter">String[]</a>
</div>
Names of layers to remove.

<a name="documentFilter">

### documentFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Only process document that satisfy this filter.

<a name="sectionFilter">

### sectionFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Process only sections that satisfy this filter.

