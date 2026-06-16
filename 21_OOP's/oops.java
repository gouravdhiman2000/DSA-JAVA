public class oops {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.color);
        p1.color = "Yellow";
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Gourav";
        System.out.println(myAcc.username);
        //myAcc.password = "abcd"; //error
        myAcc.setPassword("Abcd@19");
        System.out.println(myAcc.setPassword("Abcd@19"));
    }
}

class Pen{
    //properties + functions
    String color;
    int tip;

    void setColor(String newColor){
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

class BankAccount{
    public String username;
    private String password;
    public String setPassword(String pwd){
        return password = pwd;
    }
}