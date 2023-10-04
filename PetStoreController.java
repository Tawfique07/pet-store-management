import java.util.List;

class PetStoreController {
    private PetStore model;
    private PetStoreView view;

    public PetStoreController(PetStore model, PetStoreView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (true) {
            int choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    Pet newPet = view.getPetDetails();
                    model.addPet(newPet);
                    view.displayMessage("Pet added successfully!");
                    break;

                case 2:
                    List<Pet> inventory = model.getInventory();
                    if (inventory.isEmpty()) {
                        view.displayMessage("Inventory is empty.");
                    } else {
                        view.displayInventory(inventory);
                        view.displayMessage("Enter the name of the pet to remove: ");
                        String petNameToRemove = view.getPetDetails().getName();
                        for (Pet pet : inventory) {
                            if (pet.getName().equalsIgnoreCase(petNameToRemove)) {
                                model.removePet(pet);
                                view.displayMessage("Pet removed successfully!");
                                break;
                            }
                        }
                    }
                    break;

                case 3:
                    view.displayInventory(model.getInventory());
                    break;

                case 4:
                    view.displayMessage("Exiting the Pet Store Management System. Goodbye!");
                    System.exit(0);

                default:
                    view.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}