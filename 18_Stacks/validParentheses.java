import java.util.Stack;

public class validParentheses {
    public static boolean isValid(String str){
        Stack <Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            //Opeinig bracket case
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            //closing bracket case -> "))))) false"
            else{
                if(s.isEmpty()){
                    return false;
                }
                //pair checking condition
                if((s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']')){
                        s.pop();
                }
                else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String str ="({})[]"; //true
        System.out.println(isValid(str));
    }
}
