public class superKeyword {
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("Animal constructor is called ...");
    }
}

class Horse extends Animal{
    Horse(){
        // super.color = "brown"; //accessing the properties of immediate parent class
        super(); //It will call animal class constructor immediate parent class
        System.out.println("Horse Constructor is called ...");
    }
}
