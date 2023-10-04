import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PetStore {
    private List<Pet> inventory;
    private String databaseFileName;

    public PetStore(String databaseFileName) {
        this.databaseFileName = databaseFileName;
        inventory = new ArrayList<>();
        loadInventory();
    }

    public void addPet(Pet pet) {
        inventory.add(pet);
        saveInventory();
    }

    public void removePet(Pet pet) {
        inventory.remove(pet);
        saveInventory();
    }

    public List<Pet> getInventory() {
        return inventory;
    }

    private void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    String species = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    Pet pet = new Pet(name, species, price);
                    inventory.add(pet);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading inventory from the database file.");
        }
    }

    private void saveInventory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFileName))) {
            for (Pet pet : inventory) {
                writer.write(pet.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving inventory to the database file.");
        }
    }
}
