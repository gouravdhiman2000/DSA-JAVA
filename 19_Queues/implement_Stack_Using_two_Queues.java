import java.util.*;

public class implement_Stack_Using_two_Queues {

    static class Stack {

        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push -> O(1)
        public static void add(int data) {

            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // Pop -> O(n)
        public static int pop() {

            if (isEmpty()) {
                System.out.println("Stack Empty");
                return -1;
            }

            int top = -1;

            // Case 1
            if (!q1.isEmpty()) {

                while (!q1.isEmpty()) {

                    top = q1.remove();

                    if (q1.isEmpty()) {
                        break;
                    }

                    q2.add(top);
                }
            }

            // Case 2
            else {

                while (!q2.isEmpty()) {

                    top = q2.remove();

                    if (q2.isEmpty()) {
                        break;
                    }

                    q1.add(top);
                }
            }

            return top;
        }

        // Peek -> O(n)
        public static int peek() {

            if (isEmpty()) {
                System.out.println("Stack Empty");
                return -1;
            }

            int top = -1;

            // Case 1
            if (!q1.isEmpty()) {

                while (!q1.isEmpty()) {

                    top = q1.remove();
                    q2.add(top);
                }
            }

            // Case 2
            else {

                while (!q2.isEmpty()) {

                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack();

        st.add(1);
        st.add(2);
        st.add(3);

        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}