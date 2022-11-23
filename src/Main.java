import DataStructures.HashTable;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws Exception {
        HashTable<String> hashTable = new HashTable<String>(16);
        hashTable.addValue("Macacos", "Macacos");
        hashTable.addValue("Macacos", "Macacos");

        try {
            System.out.println(hashTable.getValue("Macacos"));
            System.out.println(hashTable.deleteValue("Macacos"));
            System.out.println(hashTable.getValue("Macacos"));
        } catch (NullPointerException nee) {
            System.out.println("Warning: Tried to access a null value on HashTable");
        } catch (IndexOutOfBoundsException ior) {
            System.out.println("Warning: Tried to delete an out of range index");
        }
    }
}