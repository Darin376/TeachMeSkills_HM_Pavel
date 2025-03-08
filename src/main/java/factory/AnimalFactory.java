package factory;

public class AnimalFactory {

    public Animal createAnimal(String animalType) {
        switch (animalType) {
            case "Dog":
                return new Dog();
            case "Cat":
                return new Cat();
            default:
                throw new IllegalArgumentException("Invalid animal type: " + animalType);
        }
    }
}
