import java.util.Queue;
import java.util.Stack;

public class StackQueueCompare {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push("stack_1");
        stack.push("stack_2");
        stack.push("stack_3");

        Object a = stack.pop();    // 맨위 요소 가져오고 제거
        Object b = stack.peek();   // 맨위를 조회만 함

        System.out.println("[Stack Pop a ] "  + a);
        System.out.println("[Stack Peep b ] " + b);

    }

}
