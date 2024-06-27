package HelloWorld;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {
    private static List<Owner> owners;

    public static void main(String[] args) {
        initData();
        useDefaultOperations();
        System.out.println();
        useStream();
    }

    private static void useDefaultOperations() {
        List<String> findNames = new ArrayList<>();
        List<Cat> findCats = new ArrayList<>();
        for (Owner owner : owners) {
            for (Animal pet : owner.getPets()) {
                if (Cat.class.equals(pet.getClass()) && pet.getColor() == Color.FOXY) {
                    findCats.add((Cat) pet);
                }
            }
        }

        findCats.sort(((o1, o2) -> o2.getAge() - o1.getAge()));

        for (Cat cat : findCats) {
            for (Owner owner : owners) {
                if (owner.getPets().contains(cat)) {
                    findNames.add(owner.getName() + ": " + cat.getName() + " " + cat.getAge());
                    break; // if we found owner we break for optimization
                }
            }
        }

        findNames.forEach(System.out::println);
    }

    private static void useStream() {
        //first variant | add - make string - sort
//        final List<String> findNames = owners.stream()
//                .flatMap(owner -> owner.getPets().stream()
//                .filter(pet -> pet instanceof Cat)
//                .filter(cat -> cat.getColor() == Color.FOXY)
//                .map(cat -> owner.getName() + ": " + cat.getName() + " " + cat.getAge()))
//                .sorted((s1, s2) -> {
//                    int age1 = Integer.parseInt(s1.substring(s1.lastIndexOf(" ") + 1));
//                    int age2 = Integer.parseInt(s2.substring(s2.lastIndexOf(" ") + 1));
//                    return Integer.compare(age2, age1);
//                })
//                .toList();

        // second variant | add - sort - make string

        List<String> findNames = owners.stream()
                .flatMap(owner -> owner.getPets().stream()
                        .filter(pet -> pet instanceof Cat)
                        .filter(cat -> cat.getColor() == Color.FOXY)
                        .map(pet -> new Object() {
                            final Cat cat = (Cat) pet;
                            final String ownerName = owner.getName();
                        }))
                .sorted((o1, o2) -> o2.cat.getAge() - o1.cat.getAge())
                .map(o -> o.ownerName + ": " + o.cat.getName() + " " + o.cat.getAge())
                .toList();

        findNames.forEach(System.out::println);
    }

    private static void initData() {
        final Owner owner1 = new Owner("Oleg");
        owner1.getPets().addAll(List.of(
                new Cat("Baron", Color.BLACK, 3),
                new Cat("Sultan", Color.DARK_GREY, 4),
                new Dog("El'za", Color.WHITE, 0)
        ));

        final Owner owner2 = new Owner("Dima");
        owner2.getPets().addAll(List.of(
                new Cat("Rizhik", Color.FOXY, 7),
                new Cat("Barsik", Color.FOXY, 5),
                new Parrot("Admiral", Color.BLUE, 3)
        ));

        final Owner owner3 = new Owner("Natasha");
        owner3.getPets().addAll(List.of(
                new Cat("Arnold", Color.FOXY, 3),
                new Pig("Pilesos", Color.LIGHT_GREY, 8)
        ));

        final Owner owner4 = new Owner("Pavel");
        owner4.getPets().add(
                new Snake("Ydav", Color.DARK_GREY, 2)
        );

        final Owner owner5 = new Owner("Anton");
        owner5.getPets().addAll(List.of(
                new Cat("Fisher", Color.BLACK, 16),
                new Cat("Zorro", Color.FOXY, 14),
                new Cat("Arnold", Color.FOXY, 3),
                new Cat("Zabilka", Color.DARK_GREY, 1)
        ));

        owners = List.of(owner1, owner2, owner3, owner4, owner5);
    }
}

enum Color {
    WHITE,
    BLACK,
    DARK_GREY,
    LIGHT_GREY,
    FOXY,
    GREEN,
    YELLOW,
    BLUE,
    MAGENTA
}

class Owner {
    private String name;
    private List<Animal> pets = new ArrayList<>();

    public Owner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getPets() {
        return pets;
    }
}

abstract class Animal {
    private String name;
    private Color color;
    private int age;

    public Animal(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }
}

class Cat extends Animal {
    public Cat(String name, Color color, int age) {
        super(name, color, age);
    }
}

class Dog extends Animal {
    public Dog(String name, Color color, int age) {
        super(name, color, age);
    }
}

class Parrot extends Animal {
    public Parrot(String name, Color color, int age) {
        super(name, color, age);
    }
}

class Pig extends Animal {
    public Pig(String name, Color color, int age) {
        super(name, color, age);
    }
}

class Snake extends Animal {
    public Snake(String name, Color color, int age) {
        super(name, color, age);
    }
}