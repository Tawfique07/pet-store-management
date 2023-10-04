import java.util.List;
import java.util.Scanner;

class PetStoreView {
    private Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nPet Store Management System");
        System.out.println("1. Add a Pet");
        System.out.println("2. Remove a Pet");
        System.out.println("3. View Inventory");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Pet getPetDetails() {
        scanner.nextLine();  // Consume the newline character
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine();
        System.out.print("Enter pet species: ");
        String species = scanner.nextLine();
        System.out.print("Enter pet price: ");
        double price = scanner.nextDouble();
        return new Pet(name, species, price);
    }

    public void displayInventory(List<Pet> inventory) {
        System.out.println("\nInventory:");
        for (Pet pet : inventory) {
            System.out.println(pet.getName() + " (" + pet.getSpecies() + ") - $" + pet.getPrice());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
