package DataStructures;

public class HashValue<V> {
    private V value;
    private String key;

    public HashValue(V value, String key) {
        this.value = value;
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
