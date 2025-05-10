package factory;

public class RannerFabric {
    public static void main(String[] args) {

        AnimalFactory factory = new AnimalFactory();

        Dog dog;
        dog = (Dog) factory.createAnimal("Dog");
        dog.voice();

        factory.createAnimal("Dog").voice();

        Animal animal;


        animal =factory.createAnimal("Dog");
        animal.voice();

        animal =factory.createAnimal("Cat");
        animal.voice();
    }
}
