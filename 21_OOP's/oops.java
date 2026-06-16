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
        // Student s2 = new Student("Gourav");
        // System.out.println(s2.name);
        // Student s3= new Student(123);
        // System.out.println(s3.roll);
        s1.name = "Gourav";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1); //Deep Copy
        System.out.println(s2.name);

        s1.marks[2] = 100;
        for(int i=0; i<3; i++){
            System.out.println(s2.marks[i]);
        }

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
    int marks[];
    String password;

    
    //Copy Constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks;
    }

    Student(){ //Non-Parameterized constructor
        marks = new int[3];
       System.out.println("Constructor is called.....");
    }

    //Parameterized Constructor
    Student(String name){
        marks = new int[3];
        this.name = name;
    }

    Student(int roll){
        marks = new int[3];
        this.roll = roll;
    }

}