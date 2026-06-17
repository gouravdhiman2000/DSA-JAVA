public class inheritance {
    public static void main(String[] args) {
        fish shark = new fish();
        shark.eat();

        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);
    }
}

//Super - Parent - Base Class
class Animal{
    String color;
    void eat(){
        System.out.println("Eats");
    }
    void breathe(){
        System.out.println("Breathes");
    }
}

//Derived - Child - Sub Class
class fish extends Animal{
    int fins;
    void swim(){
        System.out.println("Swims in water");
    }
}

//Multi-level inheritance
class Mammals extends Animal{
    int legs;
}

class Dog extends Mammals{
    String breed;
}