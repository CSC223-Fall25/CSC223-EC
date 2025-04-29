package csc223.ec;
import java.util.ArrayList;

public class MyHashTable {
    ArrayList<HashTuple>[] table;
    int capacity;
    
    public MyHashTable(int capacity) {
        this.table = new ArrayList[capacity];
        this.capacity = capacity;

        //initialize the arraylists
        for (int i=0; i< capacity; i++) {
            this.table[i] = new ArrayList<HashTuple>();
        }
    }

    public MyHashTable() {
        this.table = new ArrayList[10];
        this.capacity = 10;

        //initialize the arraylists
        for (int i=0; i< capacity; i++) {
            this.table[i] = new ArrayList<HashTuple>();
        }
    }


    //Inserts or updates a key-value pair. (Doesn't return anything)
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

    //Retrieves the value associated with the key, or null if not found. (If not found returns -Max int)
    public int get(String key) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        for (HashTuple tuple : this.table[index]) {
            if (tuple.key.equals(key)) {
                return tuple.value;
            }
        }
        //return -max value instead of null
        return -Integer.MAX_VALUE;
    } 

    //Deletes the key and its associated value. (Doesn't return anything)
    public void remove(String key) {
        int index = Math.abs(key.hashCode()) % this.capacity;
        if (!this.containsKey(key)) {
            System.out.println("Error, Key does not exist");
            return;
        }

        //search for item and delete it.
        ArrayList<HashTuple> bucket = this.table[index];
        for (int idx = 0; idx < bucket.size(); idx++) {
            if (bucket.get(idx).key.equals(key)) {
                bucket.remove(idx);
                return;
            }
        }
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
    public int size() {
        int numPairs = 0;
        for (int bucketIdx = 0; bucketIdx < this.table.length; bucketIdx++) {
            ArrayList<HashTuple> bucket = this.table[bucketIdx];
            numPairs += bucket.size();
        }
        return numPairs;
    }

}
