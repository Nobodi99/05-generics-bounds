package ohm.softa.a05.collections;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/**
 * A simple list containing just a few basic methods
 * Inherits the Iterable interface to ease the handling (e.g. extended for-loop)
 *
 * @param <T> type of the items which will be saved in the list
 */
public interface SimpleList<T> extends Iterable<T> {

	/**
	 * Add a given object to the back of the list.
	 *
	 * @param o item to add
	 */
	void add(T o);

	void remove(T o);

	/**
	 * @param clazz Class instance to solve the instantiation problem
	 */
	default void addDefault(Class<T> clazz) {
		try {
			/* better solution would be to use Google Guava to get a type token
			and use this token to create a new instance
			because we didn't include a reference to Guava this is the easiest way to create new instance of T */
			this.add(clazz.getDeclaredConstructor().newInstance());
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 *
	 * @param filter SimpleFilter instance to determine which elements should be included
	 * @return a new, filtered list
	 */
	@SuppressWarnings("unchecked")
	default SimpleList<T> filter(SimpleFilter<T> filter) {
		SimpleList<T> result;
		try {
			result = getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			result = new SimpleListImpl<>();
		}

		for (T o : this) {
			if (filter.include(o)) {
				result.add(o);
			}
		}
		return result;
	}

	/**
	 * @param transform
	 * @param <R>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default <R> SimpleList<R> map(Function<? super T,? extends R> transform) {
		SimpleList<R> result;
		try {
			result = getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			result = new SimpleListImpl<>();
		}
		for (T t : this) {
			result.add(transform.apply(t));
		}
		return result;
	}
}
