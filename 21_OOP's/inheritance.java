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

        Cat c1 = new Cat();
        c1.legs = 4;
        c1.mewwo();
        System.out.println(c1.legs);
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

class shark extends fish{
    void predator(){
        System.out.println("Shark is Predator");
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
    void bauuu(){
        System.out.println("bhauuuuu");
    }
}

class Cat extends Mammals{
    void mewwo(){
        System.out.println("Meewooo");
    }
}

class Human extends Mammals{
    void speak(){
        System.out.println("Speaks");
    }
}

//Hierarchial Inheritance
class Bird extends Animal{
    void fly(){
        System.out.println("Fly");
    }
}

class Peacock extends Bird{
    
}