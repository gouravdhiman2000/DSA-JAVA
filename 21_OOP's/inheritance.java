public class inheritance {
    public static void main(String[] args) {
        fish shark = new fish();
        shark.eat();

        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);

        Bird b1 = new Bird();
        b1.breathe();
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
    void walk(){
        System.out.println("Walk");
    }
}

class Dog extends Mammals{
    String breed;
}

//Hierarchial Inheritance
class Bird extends Animal{
    void fly(){
        System.out.println("Fly");
    }
}