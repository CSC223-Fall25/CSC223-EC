package csc223.ec;
import java.util.ArrayList;
import csc223.ec.HashTuple;

public class MyHashTable {
    ArrayList<HashTuple>[] table;
    int capacity;
    
    public MyHashTable() {
        this.table = new ArrayList[10];
        this.capacity = 10;
    }


    //Inserts or updates a key-value pair.
    public void put(String key, Integer value) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        if (!containsKey(key)) {
            this.table[index].add(new HashTuple(key,value));
        }
        else {
            //search to find correct tuple
            for (HashTuple tuple : this.table[index]) {
                if (tuple.key.equals(key)) {
                    tuple.value = value;
                }
            }
        }
    
        
    }

    //Retrieves the value associated with the key, or null if not found.
    public int get(String key) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        for (HashTuple tuple : this.table[index]) {
            if (tuple.key.equals(key)) {
                return tuple.value;
            }
        }
        //fix this idk what to return
        return -1;
    } 

    //Deletes the key and its associated value.
    public void remove(String key) {

    }

    //Returns true if the key exists, false otherwise.
    public boolean containsKey(String key) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        if (this.table[index] == null) {
            return false;
        }

        //because of seperate chaining have to search through list
        for (int i = 0; i<this.table[index].size(); i++) {
            if (this.table[index].get(i).key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    //Returns the number of key-value pairs in the table.
    public void size() {

    }

}
