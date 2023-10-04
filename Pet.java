class Pet {
    private String name;
    private String species;
    private double price;

    public Pet(String name, String species, double price) {
        this.name = name;
        this.species = species;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", price=" + price +
                '}';
    }

    public String toCsvString() {
        return name + "," + species + "," + price;
    }
}