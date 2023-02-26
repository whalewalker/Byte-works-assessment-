package com.byteworks.teradata;

public class CustomMap<K, V> {
    private final int DEFAULT_CAPACITY = 16;
    private Entry<K, V>[] entries;
    private int size;

    public CustomMap() {
        entries = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                return entries[i].getValue();
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (entries[i].getKey().equals(key)) {
                entries[i].setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            if (size == entries.length) {
                resize();
            }
            entries[size++] = new Entry<>(key, value);
        }
    }

    private void resize() {
        int newCapacity = entries.length * 2;
        Entry<K, V>[] newEntries = new Entry[newCapacity];
        System.arraycopy(entries, 0, newEntries, 0, entries.length);
        entries = newEntries;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

