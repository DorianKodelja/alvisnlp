<h1 class="module">Word2Vec</h1>

## Synopsis

Computes word embeddings using the [CONTES/Gensis](https://github.com/ArnaudFerre/CONTES) implementation.

**This module is experimental.**

## Description

Computes word embeddings using the [CONTES/Gensis](https://github.com/ArnaudFerre/CONTES) implementation.

## Parameters

<a name="contesDir">

### contesDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.InputDirectory" class="converter">InputDirectory</a>
</div>
Root directory of CONTES.

<a name="jsonFile">

### jsonFile

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputFile" class="converter">OutputFile</a>
</div>
File where to write embeddings as a JSON object.

<a name="workers">

### workers

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Integer" class="converter">Integer</a>
</div>
Use this many worker threads to train the model (=faster training with multicore machines).

<a name="txtFile">

### txtFile

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputFile" class="converter">OutputFile</a>
</div>
File where to write embeddings as a table.

<a name="vectorFeature">

### vectorFeature

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the feature where to store embeddings of each token. If this parameter is not set, then embeddings are not stored in any feature.

<a name="documentFilter">

### documentFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Only process documents that satisfy this filter.

<a name="formFeature">

### formFeature

<div class="param-level param-level-default-value">Default value: `form`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature to use as word form.

<a name="minCount">

### minCount

<div class="param-level param-level-default-value">Default value: `0`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Integer" class="converter">Integer</a>
</div>
Ignore all words with total frequency lower than this parameter.

<a name="sectionFilter">

### sectionFilter

<div class="param-level param-level-default-value">Default value: `boolean:and(true, boolean:and(nav:layer:sentences(), nav:layer:words()))`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Process only sections that satisfy this filter.

<a name="sentenceLayer">

### sentenceLayer

<div class="param-level param-level-default-value">Default value: `sentences`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the layer containing sentence annotations.

<a name="tokenLayer">

### tokenLayer

<div class="param-level param-level-default-value">Default value: `words`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the layer containing token annotations.

<a name="vectorSize">

### vectorSize

<div class="param-level param-level-default-value">Default value: `200`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Integer" class="converter">Integer</a>
</div>
The dimensionality of the feature vectors. Often effective between 100 and 300.

<a name="windowSize">

### windowSize

<div class="param-level param-level-default-value">Default value: `2`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Integer" class="converter">Integer</a>
</div>
The maximum distance between the current and predicted word within a sentence.

