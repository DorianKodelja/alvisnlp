<h1 class="module">XMIExport</h1>

## Synopsis

Writes the corpus in XMI format using the AlvisNLP/ML proxy filesystem.

**This module is experimental.**

## Description

*XMIExport* writes a file for each document in <a href="#outDir" class="param">outDir</a> in the XMI format using the AlvisNLP/ML proxy filesystem.

Files written by this module can be read by <a href="../module/XMIImport" class="module">XMIImport</a>

## Parameters

<a name="outDir">

### outDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputDirectory" class="converter">OutputDirectory</a>
</div>
Directory where to write XMI files.

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

