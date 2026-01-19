import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressBookService service = new AddressBookService();

        System.out.println("Welcome to Address Book");

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter State: ");
        String state = sc.nextLine();

        System.out.print("Enter Zip Code: ");
        String zipCode = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        ContactPerson contact = new ContactPerson(firstName, lastName, address,
                        city, state, zipCode, phone, email);

        service.addContact(contact);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Edit Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {

                System.out.print("Enter new First Name: ");
                String newFirstName = sc.nextLine();

                System.out.print("Enter new Last Name: ");
                String newLastName = sc.nextLine();

                System.out.print("Enter new Phone Number: ");
                String newPhone = sc.nextLine();

                System.out.print("Enter new Email: ");
                String newEmail = sc.nextLine();

                service.editContact(firstName, newFirstName, newLastName,
                        newPhone, newEmail);

                firstName = newFirstName;

            } 
            else if (choice == 2) {
                System.out.println("Enter Name to Delete: ");
                String name = sc.next();
                service.deleteContact(name);
                break; 

            } 
            else if (choice == 3) {
                System.out.println("Everything Up-to-Date...");
                break;

            } 
            else 
                System.out.println("Invalid choice, try again");
        }

        System.out.println("\nFinal Contacts:");
        service.showContacts();

        sc.close();
    }
}
