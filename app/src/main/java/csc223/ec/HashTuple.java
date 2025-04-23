package csc223.ec;

public class HashTuple {
    String key;
    int value;

    public HashTuple(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
