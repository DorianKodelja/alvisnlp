<h1 class="module">RDFProjector</h1>

## Synopsis

Projects OBO terms and synonyms on sections.

**This module is experimental.**

## Description

*RDFProjector* reads <a href="#source" class="param">source</a> SKOS terminologies or OWL ontologies and searches for class and concept labels in sections.

The parameters <a href="#allowJoined" class="param">allowJoined</a>, <a href="#allUpperCaseInsensitive" class="param">allUpperCaseInsensitive</a>, <a href="#caseInsensitive" class="param">caseInsensitive</a>, <a href="#ignoreDiacritics" class="param">ignoreDiacritics</a>, <a href="#joinDash" class="param">joinDash</a>, <a href="#matchStartCaseInsensitive" class="param">matchStartCaseInsensitive</a>, <a href="#skipConsecutiveWhitespaces" class="param">skipConsecutiveWhitespaces</a>, <a href="#skipWhitespace" class="param">skipWhitespace</a> and <a href="#wordStartCaseInsensitive" class="param">wordStartCaseInsensitive</a> control the matching between the section and the entry keys.

The <a href="#subject" class="param">subject</a> parameter specifies which text of the section should be matched. There are two options:
  
* the entries are matched on the contents of the section, <a href="#subject" class="param">subject</a> can also control if matches boundaries coincide with word delimiters;
* the entries are matched on the feature value of annotations of a given layer separated by a whitespace, in this way entries can be searched against word lemmas for instance.



*RDFProjector* creates an annotation for each matched entry and adds these annotations to the layer named <a href="#targetLayerName" class="param">targetLayerName</a>. The created annotations will have the feature <a href="#uriFeatureName" class="param">uriFeatureName</a> containing the URI of the matched class or concept. *RDFProjector* may also map property object values into features specified by <a href="#labelFeatures" class="param">labelFeatures</a>.

## Parameters

<a name="source">

### source

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.streams.SourceStream" class="converter">SourceStream</a>
</div>
Path to the source SKOS/OWL files.

<a name="targetLayerName">

### targetLayerName

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Name of the layer that contains the match annotations.

<a name="uriFeatureName">

### uriFeatureName

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String" class="converter">String</a>
</div>
Feature where to store the entry URI.

<a name="constantAnnotationFeatures">

### constantAnnotationFeatures

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.module.types.Mapping" class="converter">Mapping</a>
</div>
Constant features to add to each annotation created by this module

<a name="trieSink">

### trieSink

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.OutputFile" class="converter">OutputFile</a>
</div>
Serialization is not supported.

<a name="trieSource">

### trieSource

<div class="param-level param-level-optional">Optional
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.util.files.InputFile" class="converter">InputFile</a>
</div>
Serialization is not supported.

<a name="allUpperCaseInsensitive">

### allUpperCaseInsensitive

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows case substitution on all characters in words that are all upper case.

<a name="allowJoined">

### allowJoined

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows arbitrary suppression of whitespace characters in the subject. For instance, the contents *aminoacid* matches the entry *amino acid*.

<a name="caseInsensitive">

### caseInsensitive

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows case substitutions on all characters.

<a name="documentFilter">

### documentFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Only process document that satisfy this filter.

<a name="ignoreDiacritics">

### ignoreDiacritics

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows dicacritics substitutions on all characters. For instance the contents *acide amine* matches the entry *acide aminé*.

<a name="joinDash">

### joinDash

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either to treat dash characters (-) as whitespace characters if <a href="#allowJoined" class="param">allowJoined</a> is `true`. For instance, the contents *aminoacid* matches the entry *amino-acid*.

<a name="labelFeatures">

### labelFeatures

<div class="param-level param-level-default-value">Default value: `{rdfs-label=rdfs:label, skos-prefLabel=skos:prefLabel}`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.module.types.Mapping" class="converter">Mapping</a>
</div>
Mapping from feature names to property URIs. This parameter indicates the properties of the entry to record in features.

<a name="labelURIs">

### labelURIs

<div class="param-level param-level-default-value">Default value: `rdfs:label,skos:prefLabel,skos:altLabel,skos:hiddenLabel,skos:notation,oboInOwl:hasExactSynonym,oboInOwl:hasRelatedSynonym,oboInOwl:hasSynonym`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String[]" class="converter">String[]</a>
</div>
RDF properties whose object values that represent entry keys.

<a name="matchStartCaseInsensitive">

### matchStartCaseInsensitive

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows case substitution on the first character of the entry key.

<a name="multipleEntryBehaviour">

### multipleEntryBehaviour

<div class="param-level param-level-default-value">Default value: `all`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.trie.MultipleEntryBehaviour" class="converter">MultipleEntryBehaviour</a>
</div>
Specifies the behavious of *RDFProjector* if <a href="#dictFile" class="param">dictFile</a> contains several entries with the same key.

<a name="prefixes">

### prefixes

<div class="param-level param-level-default-value">Default value: `{}`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.module.types.Mapping" class="converter">Mapping</a>
</div>
Specify URI prefixes to be used in <a href="#resourceTypeURIs" class="param">resourceTypeURIs</a>, <a href="#labelURIs" class="param">labelURIs</a>, and <a href="#labelFeatures" class="param">labelFeatures</a>

<a name="resourceTypeURIs">

### resourceTypeURIs

<div class="param-level param-level-default-value">Default value: `owl:Class,skos:Concept`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.String[]" class="converter">String[]</a>
</div>
Type of RDF resources that represent an entry.

<a name="sectionFilter">

### sectionFilter

<div class="param-level param-level-default-value">Default value: `true`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.core.corpus.expressions.Expression" class="converter">Expression</a>
</div>
Process only sections that satisfy this filter.

<a name="skipConsecutiveWhitespaces">

### skipConsecutiveWhitespaces

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows insertion of consecutive whitespace characters in the subject. For instance, the contents *amino  acid* matches the entry *amino acid*.

<a name="skipWhitespace">

### skipWhitespace

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows arbitrary insertion of whitespace characters in the subject. For instance, the contents *amino acid* matches the entry *aminoacid*.

<a name="subject">

### subject

<div class="param-level param-level-default-value">Default value: `WORD`
</div>
<div class="param-type">Type: <a href="../converter/fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.trie.Subject" class="converter">Subject</a>
</div>
Specifies the contents to match.

<a name="wordStartCaseInsensitive">

### wordStartCaseInsensitive

<div class="param-level param-level-default-value">Default value: `false`
</div>
<div class="param-type">Type: <a href="../converter/java.lang.Boolean" class="converter">Boolean</a>
</div>
Either the match allows case substitution on the first character of words.

