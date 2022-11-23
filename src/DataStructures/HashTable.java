package DataStructures;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable<V> {
    private final ArrayList<LinkedList<HashValue<V>>> TABLE = new ArrayList<>();
    private final int TABLE_SIZE;

    public HashTable(int size) {
        this.TABLE_SIZE = size;
        this.populateTable();
    }

    private int calcIndex(String idValue) {
        int index = 0;
        for (int count = 0; count < idValue.length(); count++)
            index += idValue.charAt(count);
        return index % TABLE_SIZE;
    }

    private void populateTable() {
        for (int i = 0; i < TABLE_SIZE; i++)
            TABLE.add(null);
    }

    private boolean keyAlreadyExists(String valueKey) {
        try {
            this.getValue(valueKey);
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }

    public void addValue(V value, String valueKey) {
        int index = this.calcIndex(valueKey);
        HashValue<V> hashValue = new HashValue<>(value, valueKey);

        if (keyAlreadyExists(valueKey)) {
            updateValue(value, valueKey);
            return;
        }

        if (this.TABLE.get(index) == null) {
            LinkedList<HashValue<V>> linkedList = new LinkedList<>();
            this.TABLE.set(index, linkedList);
        }

        LinkedList<HashValue<V>> linkedList = this.TABLE.get(index);
        linkedList.push(hashValue);
    }

    public void updateValue(V value, String valueKey) throws NullPointerException {
        int index = calcIndex(valueKey);
        LinkedList<HashValue<V>> linkedList = this.TABLE.get(index);
        linkedList.stream()
                .filter(h -> valueKey.equals(h.getKey()))
                .findFirst()
                .orElseThrow(NullPointerException::new)
                .setValue(value);
    }

    public V deleteValue(String valueKey) throws NullPointerException, IndexOutOfBoundsException  {
        int tableIndex = calcIndex(valueKey);
        int nodeIndex = 0;

        LinkedList<HashValue<V>> linkedList = TABLE.get(tableIndex);
        V value = this.getValue(valueKey);

        for (int i = 0; i < TABLE.get(tableIndex).size(); i++)
            if (linkedList.get(i).getKey().equals(valueKey))
                nodeIndex = i;

        linkedList.remove(nodeIndex);
        return value;
    }

    public V getValue(String valueKey) throws NullPointerException {
        int index = calcIndex(valueKey);

        HashValue<V> hashValue = TABLE.get(index)
                .stream()
                .filter(h -> valueKey.equals(h.getKey()))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        return hashValue.getValue();
    }
}