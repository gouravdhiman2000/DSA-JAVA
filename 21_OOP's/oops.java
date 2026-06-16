public class oops {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Gourav";
        System.out.println(myAcc.username);
        //myAcc.password = "abcd"; //error
        myAcc.setPassword("Abcd@19");
        System.out.println(myAcc.setPassword("Abcd@19"));

        Student s1 = new Student();
        Student s2 = new Student("Gourav");
        System.out.println(s2.name);
        Student s3= new Student(123);
        System.out.println(s3.roll);

    }
}

class Pen{
    //properties + functions
    private String color;
    private int tip;

    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }

    void setColor(String newColor){
        this.color = newColor;
    }

    void setTip(int newTip){
        this.tip = newTip;
    }
}

class BankAccount{
    public String username;
    private String password;
    public String setPassword(String pwd){
        return password = pwd;
    }
}

class Student{
    String name;
    int roll;

    Student(){ //Non-Parameterized constructor
       System.out.println("Constructor is called.....");
    }

    //Parameterized Constructor
    Student(String name){
        this.name = name;
    }

    Student(int roll){
        this.roll = roll;
    }
}