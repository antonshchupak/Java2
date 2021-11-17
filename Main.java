package lesson3.task2;

public class Main  {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Jacobs", "89001001010");
        phoneBook.add("Peters", "891001001011");
        phoneBook.add("Peters", "891001001012");
        phoneBook.add("Williams", "891001002020");
        phoneBook.add("Brown", "890001001011");
        phoneBook.add("Brown", "891001054011");

        System.out.println("Jacobs");
        for (String number: phoneBook.get("Jacobs")) {
            System.out.println(" " + number);
        }
        System.out.println("Peters");
        for (String number: phoneBook.get("Peters")) {
            System.out.println(" " + number);
        }
        System.out.println("Williams");
        for (String number: phoneBook.get("Williams")) {
            System.out.println(" " + number);
        }
        System.out.println("Brown");
        for (String number: phoneBook.get("Brown")) {
            System.out.println(" " + number);
        }
    }
}
