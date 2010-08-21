/*
 * Copyright 2010 Jan Ouwens
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.jqno.equalsverifier.util;

/**
 * Instantiates and populates objects of a given class. {@link ClassAccessor}
 * can create two different instances of T, which are guaranteed not to be
 * equal to each other, and which contain no null values.
 * 
 * @param <T> A class.
 *
 * @author Jan Ouwens
 */
public class ClassAccessor<T> {
	private final Class<T> type;
	private final Instantiator<T> instantiator;
	private final PrefabValues prefabValues;

	/**
	 * Factory method.
	 * 
	 * @param <T> The class on which {@link ClassAccessor} operates.
	 * @param type The class on which {@link ClassAccessor} operates. Should be
	 * 			the same as T.
	 * @param prefabValues Prefabricated values with which to fill instantiated
	 * 			objects.
	 * @return A {@link ClassAccessor} for T.
	 */
	public static <T> ClassAccessor<T> of(Class<T> type, PrefabValues prefabValues) {
		return new ClassAccessor<T>(type, prefabValues);
	}
	
	/**
	 * Private constructor. Call {@link #of(Class, PrefabValues)} instead.
	 */
	private ClassAccessor(Class<T> type, PrefabValues prefabValues) {
		this.type = type;
		this.instantiator = Instantiator.of(type);
		this.prefabValues = prefabValues;
	}
	
	/**
	 * Getter.
	 */
	public Class<T> getType() {
		return type;
	}
	
	/**
	 * Getter.
	 */
	public PrefabValues getPrefabValues() {
		return prefabValues;
	}
	
	/**
	 * Returns an instance of T that is not equal to the instance of T returned
	 * by {@link #getSecondObject()}.
	 *  
	 * @return An instance of T.
	 */
	public T getFirstObject() {
		return getFirstAccessor().get();
	}

	/**
	 * Returns an {@link ObjectAccessor} for {@link #getFirstObject()}.
	 * 
	 * @return An {@link ObjectAccessor} for {@link #getFirstObject()}.
	 */
	public ObjectAccessor<T> getFirstAccessor() {
		ObjectAccessor<T> result = buildObjectAccessor();
		result.scramble(prefabValues);
		return result;
	}
	
	/**
	 * Returns an instance of T that is not equal to the instance of T returned
	 * by {@link #getFirstObject()}.
	 *  
	 * @return An instance of T.
	 */
	public T getSecondObject() {
		return getSecondAccessor().get();
	}

	/**
	 * Returns an {@link ObjectAccessor} for {@link #getSecondObject()}.
	 * 
	 * @return An {@link ObjectAccessor} for {@link #getSecondObject()}.
	 */
	public ObjectAccessor<T> getSecondAccessor() {
		ObjectAccessor<T> result = buildObjectAccessor();
		result.scramble(prefabValues);
		result.scramble(prefabValues);
		return result;
	}
	
	private ObjectAccessor<T> buildObjectAccessor() {
		T object = instantiator.instantiate();
		return ObjectAccessor.of(object);
	}
}