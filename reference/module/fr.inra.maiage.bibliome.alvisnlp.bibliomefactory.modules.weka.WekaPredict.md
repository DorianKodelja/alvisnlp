<h1 class="module">WekaPredict</h1>

## Synopsis

Classifies elements with a Weka classifier.

## Description

*WekaPredict* applies the classifier loaded from <a href="#classifier" class="param">classifier</a> on elements specified by <a href="#examples" class="param">examples</a>.

## Parameters

<a name="classifierFile">

### classifierFile

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.io.File" class="converter">File</a>
</div>
Serialized classifier file. This file must be generated by <a href="../module/TrainingElementClassifier" class="module">TrainingElementClassifier</a> with the same <a href="#relationDefinition" class="param">relationDefinition</a>.

<a name="examples">

### examples

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Elements to classify. This expression is evaluated as a list of elements with the corpus as the context element.

<a name="predictedClassFeatureKey">

### predictedClassFeatureKey

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature where to write the class prediction.

<a name="relationDefinition">

### relationDefinition

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.weka.RelationDefinition" class="converter">RelationDefinition</a>
</div>
Specification of example attributes and class.

<a name="evaluationFile">

### evaluationFile

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.streams.TargetStream" class="converter">TargetStream</a>
</div>
File where to write evaluation results, if actual classes are available.
