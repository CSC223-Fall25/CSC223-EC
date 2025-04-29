package csc223.ec;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyHashTableTest {
    MyHashTable testHashTable;

        @BeforeEach
        void setup(){
            this.testHashTable = new MyHashTable(5);
        }


        @Test
        void testPut(){
            testHashTable.put("Elliot", 10);
            assertEquals(10, testHashTable.get("Elliot"));
        }

        @Test
        void testGet(){
            testHashTable.put("Sultan", 15);
            assertEquals(15, testHashTable.get("Sultan"));
        }

        @Test
        void testRemove(){
            testHashTable.put("Alvin", 20);
            assertTrue(testHashTable.containsKey("Alvin"));
            testHashTable.remove("Alvin");
            assertFalse(testHashTable.containsKey("Alvin"));
        }

        @Test
        void testContainsKey(){
            testHashTable.put("Jacob", 30);
            assertTrue(testHashTable.containsKey("Jacob"));
        }

        @Test
        void testSize(){
            testHashTable.put("Elliot", 10);
            testHashTable.put("Sultan", 15);
            testHashTable.put("Alvin", 20);
            testHashTable.put("Jacob", 30);
            assertEquals(4, testHashTable.size());
            testHashTable.remove("Jacob");
            assertEquals(3, testHashTable.size());
        }



}