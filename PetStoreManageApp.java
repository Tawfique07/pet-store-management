public class PetStoreManageApp {
    public static void main(String[] args) {
        PetStore model = new PetStore("petstore_db.csv");
        PetStoreView view = new PetStoreView();
        PetStoreController controller = new PetStoreController(model, view);

        controller.run();
    }
}