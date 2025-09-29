// Enum buat Status dan Gender
enum Status {
    DEAD(0), ALIVE(1);

    private int code;
    Status(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}

enum Gender {
    MALE(0), FEMALE(1);

    private int code;
    Gender(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}

abstract class Animal {
    protected String name;
    protected int age;
    protected String food;
    protected Gender gender;
    protected Status alive;

    public Animal(String name, int age, String food, Gender gender, Status alive) {
        this.name = name;
        this.age = age;
        this.food = food;
        this.gender = gender;
        this.alive = alive;
    }

    public abstract String printSound();

    public boolean isAlive() {
        return alive == Status.ALIVE;
    }

    public String move() {
        return name + " is moving...";
    }

    public String move(int distance) {
        return name + " moves for " + distance + " meters";
    }

    public String printData() {
        return "Name: " + name + 
               ", Age: " + age + 
               ", Food: " + food + 
               ", Gender: " + gender + 
               ", Status: " + (isAlive() ? "Alive" : "Dead");
    }
}
// Child Class Cat
class Cat extends Animal {
    public Cat(String name, int age, String food, Gender gender, Status alive) {
        super(name, age, food, gender, alive);
    }
    
    @Override
    public String printSound() {
        return "Meow!";
    }

    @Override
    public String move(int distance) {
        return "The cat named " + name + " walks for " + distance + " meters";
    }

    @Override
    public String printData() {
        return "[Cat] " + super.printData();
    }
}

// Child Class Dog
class Dog extends Animal {
    public Dog(String name, int age, String food, Gender gender, Status alive) {
        super(name, age, food, gender, alive);
    }

    @Override
    public String printSound() {
        return "Woof!";
    }

    @Override
    public String move(int distance) {
        return "The dog named " + name + " runs for " + distance + " meters";
    }

    @Override
    public String printData() {
        return "[Dog] " + super.printData();
    }
}

// Child Class Duck
class Duck extends Animal {
    public Duck(String name, int age, String food, Gender gender, Status alive) {
        super(name, age, food, gender, alive);
    }

    @Override
    public String printSound() {
        return "Kwek!";
    }

    @Override
    public String move(int distance) {
        return "The duck named " + name + " swims for " + distance + " meters";
    }

    @Override
    public String printData() {
        return "[Duck] " + super.printData();
    }
}

// Child Class Horse
class Horse extends Animal {
    public Horse(String name, int age, String food, Gender gender, Status alive) {
        super(name, age, food, gender, alive);
    }

    @Override
    public String printSound() {
        return "Ihiy!";
    }

    @Override
    public String move(int distance) {
        return "The horse named " + name + " gallops for " + distance + " meters";
    }

    @Override
    public String printData() {
        return "[Horse] " + super.printData();
    }
}

// Main class
public class Geometry {
    public static void main(String[] args) {
        Animal cat = new Cat("Mimi", 2, "Fish", Gender.FEMALE, Status.ALIVE);
        Animal dog = new Dog("Max", 3, "Bone", Gender.MALE, Status.ALIVE);
        Animal duck = new Duck("Stacy", 1, "Grain", Gender.FEMALE, Status.ALIVE);
        Animal horse = new Horse("Thunder", 5, "Grass", Gender.MALE, Status.DEAD);

        System.out.println(cat.printData());
        System.out.println(cat.printSound());
        System.out.println(cat.move(3));

        System.out.println(dog.printData());
        System.out.println(dog.printSound());
        System.out.println(dog.move(10));

        System.out.println(duck.printData());
        System.out.println(duck.printSound());
        System.out.println(duck.move(5));

        System.out.println(horse.printData());
        System.out.println(horse.printSound());
        System.out.println(horse.move(15));
    }
}
