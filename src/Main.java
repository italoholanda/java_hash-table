import DataStructures.HashTable;

class User {
    private String name;
    private int age;

    public User (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        HashTable<User> hashTable = new HashTable<>(16);

        User robert = new User("robert");
        User john = new User("john");
        User ana = new User("ana");

        hashTable.addValue(robert, robert.getName());
        hashTable.addValue(john, john.getName());

        try {
            System.out.println(hashTable.getValue("robert").getName());
            System.out.println(hashTable.getValue("john").getName());
            hashTable.updateValue(ana, "john");
            System.out.println(hashTable.getValue("john").getName());
            hashTable.deleteValue("john");
            System.out.println(hashTable.getValue("john").getName());
        } catch (NullPointerException nee) {
            System.out.println("Warning: Tried to access a null value on HashTable");
        } catch (IndexOutOfBoundsException ior) {
            System.out.println("Warning: Tried to delete an out of range index");
        }
    }
}