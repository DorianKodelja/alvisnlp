<h1 class="module">YateaExtractor</h1>

## Synopsis

Extract terms from the corpus using the YaTeA term extractor.

## Description

*YateaExtractor* hands the corpus to the [YaTeA](http://search.cpan.org/~thhamon/Lingua-YaTeA) extractor. The corpus is first written in a file in the YaTeA input format. Tokens are annotations in the layer <a href="#wordLayerName" class="param">wordLayerName</a>, their surface form, POS tag and lemma are taken from <a href="#formFeature" class="param">formFeature</a>, <a href="#posFeature" class="param">posFeature</a> and <a href="#lemmaFeature" class="param">lemmaFeature</a> features respectively. If <a href="#sentenceLayerName" class="param">sentenceLayerName</a> is set, then an additional *SENT* marker is added to reinforce sentence boundaries corresponding to annotations in this layer.

The YaTeA is called using the executable set in <a href="#yateaExecutable" class="param">yateaExecutable</a>, it will run as if it is called from directory <a href="#workingDir" class="param">workingDir</a>: the result will be written in the subdirectory named <a href="#corpusName" class="param">corpusName</a>.

## Parameters

<a name="rcFile">

### rcFile

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.streams.SourceStream" class="converter">SourceStream</a>
</div>
Path to the YaTeA configuration file.

<a name="workingDir">

### workingDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.WorkingDirectory" class="converter">WorkingDirectory</a>
</div>
Path to the directory where YaTeA is launched.

<a name="yateaExecutable">

### yateaExecutable

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.ExecutableFile" class="converter">ExecutableFile</a>
</div>
Path to the YaTeA executable file.

<a name="configDir">

### configDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.InputDirectory" class="converter">InputDirectory</a>
</div>


<a name="language">

### language

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>


<a name="localeDir">

### localeDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.InputDirectory" class="converter">InputDirectory</a>
</div>


<a name="outputDir">

### outputDir

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputDirectory" class="converter">OutputDirectory</a>
</div>


<a name="perlLib">

### perlLib

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Contents of the PERLLIB in the environment of Yatea binary.

<a name="postProcessingConfig">

### postProcessingConfig

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.InputFile" class="converter">InputFile</a>
</div>
BioYaTeA option: path to the post-processing file option.

<a name="postProcessingOutput">

### postProcessingOutput

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputFile" class="converter">OutputFile</a>
</div>
BioYaTeA option: path to the result file after post-processing.

<a name="suffix">

### suffix

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>


<a name="testifiedTerminology">

### testifiedTerminology

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.yatea.TestifiedTerminology" class="converter">TestifiedTerminology</a>
</div>


<a name="bioYatea">

### bioYatea

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>


<a name="documentFilter">

### documentFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Only process document that satisfy this filter.

<a name="documentTokens">

### documentTokens

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either to write DOCUMENT special tokens. Not every YaTeA version accepts them.

<a name="formFeature">

### formFeature

<div class="param-level param-level-default-value">Default value: `form`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature containing the word form.

<a name="lemmaFeature">

### lemmaFeature

<div class="param-level param-level-default-value">Default value: `lemma`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature containing the word lemma.

<a name="posFeature">

### posFeature

<div class="param-level param-level-default-value">Default value: `pos`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature containing the word POS tag.

<a name="sectionFilter">

### sectionFilter

<div class="param-level param-level-default-value">Default value: `boolean:and(true, nav:layer:words())`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Process only sections that satisfy this filter.

<a name="sentenceLayerName">

### sentenceLayerName

<div class="param-level param-level-default-value">Default value: `sentences`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the layer containing sentence annotations, sentences are reinforced.

<a name="wordLayerName">

### wordLayerName

<div class="param-level param-level-default-value">Default value: `words`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the layer containing the word annotations.

<a name="yateaDefaultConfig">

### yateaDefaultConfig

<div class="param-level param-level-default-value">Default value: `{}`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.module.types.Mapping" class="converter">Mapping</a>
</div>


<a name="yateaOptions">

### yateaOptions

<div class="param-level param-level-default-value">Default value: `{}`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.module.types.Mapping" class="converter">Mapping</a>
</div>


