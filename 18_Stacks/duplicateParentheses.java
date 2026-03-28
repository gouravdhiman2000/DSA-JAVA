import java.util.Stack;

public class duplicateParentheses {
    public static boolean isDuplicate (String str){
        Stack <Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

             //Case 1-> Closing tag
        if(ch == ')'){
            int count = 0;
            while(s.peek()!= '('){
                s.pop();
                count++;
            }
            if(count < 1){
                return true; //Duplicate
            }
            else{
                s.pop(); //Pop opening pair
            }
        }
        //Case 2-> Opening condition
        else{
            s.push(ch);
            }
        }
    return false;
    }
       
    
    public static void main(String[] args) {
        String str1 = "((a+b))"; //true
        String str2 = "(a-b)"; //false
        System.out.println(isDuplicate(str2));
    }
}
