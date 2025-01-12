package katas.exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderedMap<K, V> {

    private final List<K> keyOrder;
    private final Map<K, V> map;

    /**
     * Implement an OrderedMap data structure that behaves like a regular map (dictionary) but maintains the
     * order of the keys based on their insertion order.
     *
     * Your task is to implement this class without using the SortedMap interface or similar utilities provided
     * by Java libraries.
     *
     * The order should be preserved as the keys are added to the map.
     */
    public OrderedMap() {
        this.keyOrder = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void put(K key, V value) {
        /**
         * Add a key-value pair to the map.
         * If the key already exists, update its value while preserving the order.
         */
        if (!map.containsKey(key)) {
            keyOrder.add(key);
        }
        map.put(key, value);
    }

    public V get(K key) {
        /**
         * Retrieve the value associated with a given key.
         *
         * @param key: The key whose value is to be retrieved.
         * @return: The value associated with the key, or null if the key does not exist.
         */
        return map.get(key);
    }

    public void remove(K key) {
        /**
         * Remove a key-value pair from the map.
         *
         * @param key: The key to be removed.
         */
        if (map.containsKey(key)) {
            map.remove(key);
            keyOrder.remove(key);
        }
    }

    public List<K> keys() {
        /**
         * Return all keys in the order they were added.
         *
         * @return: A list of keys in insertion order.
         */
        return new ArrayList<>(keyOrder);
    }

    public int size() {
        /**
         * Return the number of elements in the map.
         *
         * @return: The size of the map.
         */
        return map.size();
    }

    public void clear() {
        /**
         * Remove all key-value pairs from the map.
         */
        map.clear();
        keyOrder.clear();
    }

    public static void main(String[] args) {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        System.out.println("Keys in order: " + orderedMap.keys());
        System.out.println("Value of 'Two': " + orderedMap.get("Two"));

        orderedMap.remove("Two");
        System.out.println("Keys after removal: " + orderedMap.keys());

        orderedMap.put("Two", 22);
        System.out.println("Keys after re-adding 'Two': " + orderedMap.keys());

        System.out.println("Map size: " + orderedMap.size());

        orderedMap.clear();
        System.out.println("Map size after clearing: " + orderedMap.size());
    }
}
