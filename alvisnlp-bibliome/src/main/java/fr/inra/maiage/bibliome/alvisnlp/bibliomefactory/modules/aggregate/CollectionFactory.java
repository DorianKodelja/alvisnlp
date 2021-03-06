/*
Copyright 2016, 2017 Institut National de la Recherche Agronomique

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/


package fr.inra.maiage.bibliome.alvisnlp.bibliomefactory.modules.aggregate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public enum CollectionFactory {
	LIST {
		@Override
		<T> Collection<T> createCollection() {
			return new ArrayList<T>();
		}
	},
	
	SET {
		@Override
		<T> Collection<T> createCollection() {
			return new LinkedHashSet<T>();
		}
	},
	
	ORDERED {
		@Override
		<T> Collection<T> createCollection() {
			return new TreeSet<T>();
		}
	};
	
	abstract <T> Collection<T> createCollection();
}
