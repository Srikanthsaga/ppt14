import java.util.Arrays;
import java.util.Stack;

class ListNode147 {
    int val;
    ListNode147 next;

    ListNode147(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListNextGreaterNode147 {
    public int[] nextLargerNodes(ListNode147 head) {
        if (head == null) {
            return new int[0];
        }

        int length = getLength(head);
        int[] answer = new int[length];
        Stack<int[]> stack = new Stack<>();

        ListNode147 curr = head;
        int index = 0;

        while (curr != null) {
            while (!stack.isEmpty() && stack.peek()[1] < curr.val) {
                int[] node = stack.pop();
                answer[node[0]] = curr.val;
            }

            stack.push(new int[]{index, curr.val});
            curr = curr.next;
            index++;
        }

        return answer;
    }

    private int getLength(ListNode147 head) {
        int length = 0;
        ListNode147 curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    public static void main(String[] args) {
        LinkedListNextGreaterNode147 solution = new LinkedListNextGreaterNode147();

        // Example
        ListNode147 head = new ListNode147(2);
        head.next = new ListNode147(1);
        head.next.next = new ListNode147(5);

        int[] result = solution.nextLargerNodes(head);
        System.out.println(Arrays.toString(result));
    }
}
