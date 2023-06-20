class ListNode145 {
    int val;
    ListNode145 next;

    ListNode145(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListOddEven145 {
    public ListNode145 oddEvenList(ListNode145 head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode145 oddHead = head;
        ListNode145 evenHead = head.next;
        ListNode145 oddTail = oddHead;
        ListNode145 evenTail = evenHead;

        ListNode145 curr = evenHead.next;
        int index = 3;

        while (curr != null) {
            if (index % 2 == 1) {
                oddTail.next = curr;
                oddTail = oddTail.next;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
            }

            curr = curr.next;
            index++;
        }

        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }

    public static void main(String[] args) {
        LinkedListOddEven145 solution = new LinkedListOddEven145();

        // Example
        ListNode145 head = new ListNode145(1);
        head.next = new ListNode145(2);
        head.next.next = new ListNode145(3);
        head.next.next.next = new ListNode145(4);
        head.next.next.next.next = new ListNode145(5);

        ListNode145 result = solution.oddEvenList(head);
        printList(result);
    }

    // Helper method to print the linked list
    private static void printList(ListNode145 head) {
        ListNode145 curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
