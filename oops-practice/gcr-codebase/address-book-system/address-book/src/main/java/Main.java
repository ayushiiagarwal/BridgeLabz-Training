import java.util.Scanner;

public class Main{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("--Welcome to Address Book Program--");

        boolean b = true;

        AddressBookInterface  manager = new AddressBookManager();

        while(b){
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                // UC-1
                case 1:
                    Contact c = manager.createContact();
                    System.out.println(c);
                    System.out.println("Created Successfully!");
                    break;
                
                // UC-2
                case 2:
                    Contact contact = manager.createContact();
                    manager.addContact(contact);
                    break;

                // UC-5
                case 3:
                    manager.addMultipleContacts();
                    break;
                
                // UC-3
                case 4:
                    manager.editContact();
                    break;
                
                // UC-4
                case 5:
                    manager.deleteContacts();
                    break;

                // UC-8
                case 6:
                    manager.searchPersonByCityOrState();
                    break;

                // UC-9
                case 7: 
                    manager.viewPersonByCityOrState();
                    break;
                
                // UC-10
                case 8:
                    manager.countPersonByCityOrState();
                    break;
                
                // UC-11
                case 9:
                    manager.sortContacts();
                    break;

                // UC-12
                case 10:
                    manager.sortContactsByCityStateOrZip();
                    break;
                
                // UC-13
                case 11:
                    manager.writeAddressBookToFile();
                    break;
                
                case 12:
                    manager.readAddressBookFromFile();
                    break;

                case 13:
                    manager.readAddressBookFromCSV();
                    break;
                
                case 14:
                    manager.writeAddressBookToCSV();
                    break;

                case 0:
                    b = false;
                    break;

                default:
                    break;
            
            }
        }
    } 

    private static void displayMenu(){
        System.out.println("\nSelect a number: ");
        System.out.println("1. Create Contact");
        System.out.println("2. Add new Contact");
        System.out.println("3. Add multiple Contacts");
        System.out.println("4. Edit a Contact");
        System.out.println("5. Delete a Contact");
        System.out.println("6. Search a Person by city or state.");
        System.out.println("7. View Persons by city or state.");
        System.out.println("8. Count Persons by city or state.");
        System.out.println("9. Sort Contacts Alphabetically by name.");
        System.out.println("10. Sort Contacts by city/state/zip.");
        System.out.println("11. Write addressbook to file.");
        System.out.println("12. Read addressbook from file.");
        System.out.println("13. Write addressbook to CSV.");
        System.out.println("14. Read addressbook from CSV.");
        System.out.println("0. Exit.");
    }
}