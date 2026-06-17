public class abstraction {
    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        Mustang myhMustang = new Mustang();
        //Animal -> Horse -> Mustang
        
    }
}

abstract class Animal{
    String color;
    Animal(){
        color = "brown";
        System.out.println("Animal constructor called .....");
    }
    void eat(){
        System.out.println("Animal Eats");
    }
    abstract void walk(); //no implementation just idea
}

class Horse extends Animal{
    Horse(){
        System.out.println("Horse constructor called ....");
    }
    void changeColor(){
        color = "dark brown";
    }
    void walk(){
        System.out.println("Walks on 4 legs");
    }
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called ....");
    }
}

class Chicken extends Animal{
    void changeColor(){
        color = "red - black";
    }
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}


