package dualHashMap;

import java.util.HashMap;

/**
 * 
 * @author Manuel Deaguinaga DualHashMap is an implementation to DualMap that
 *         maintains a one-to-one mapping between keys and value. A DualMap
 *         object should contain a Map from keys to values and a Map from values
 *         to keys. A DualMap cannot contain duplicate keys or duplicate values.
 *
 * @param <K>
 *            key to be associated with the specified value.
 * @param <V>
 *            value to be associated with the specified key
 */
public class DualHashMap<K, V> implements DualMap<K, V> {

	private HashMap<K, V> map;
	private HashMap<V, K> reverseMap;

	/**
	 * DualHashMap constructor calls the superclass
	 */
	public DualHashMap() {
		super();
		map = new HashMap<K, V>();
		reverseMap = new HashMap<V, K>();
	}

	/**
	 * @param K
	 *            key, V value
	 */
	public void put(K key, V value) {
		if (map.containsKey(key)) {
			V vInput = map.get(key);
			map.remove(key);
			reverseMap.remove(vInput);
		}
		if (reverseMap.containsKey(value)) {
			K kInput = reverseMap.get(value);
			reverseMap.remove(value);
			map.remove(kInput);
		}
		map.put(key, value);
		reverseMap.put(value, key);
	}

	/**
	 * @return key
	 */
	public V get(K key) {
		return map.get(key);
	}

	/**
	 * @return value
	 */
	public K reverseGet(V value) {
		return reverseMap.get(value);
	}

	/**
	 * remove(K key, V value)
	 */
	public void remove(K key, V value) {
		map.remove(key);
		reverseMap.remove(value);
	}

}
