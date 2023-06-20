class ListNode146 {
    int val;
    ListNode146 next;

    ListNode146(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListRotateLeft146 {
    public ListNode146 rotateLeft(ListNode146 head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = getLength(head);
        k = k % length; // Adjust k to handle cases where k > length

        if (k == 0) {
            return head;
        }

        ListNode146 newHead = head;
        ListNode146 curr = head;

        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        newHead = curr.next;
        curr.next = null;

        curr = newHead;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;

        return newHead;
    }

    private int getLength(ListNode146 head) {
        int length = 0;
        ListNode146 curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        return length;
    }

    public static void main(String[] args) {
        LinkedListRotateLeft146 solution = new LinkedListRotateLeft146();

        // Example
        ListNode146 head = new ListNode146(2);
        head.next = new ListNode146(4);
        head.next.next = new ListNode146(7);
        head.next.next.next = new ListNode146(8);
        head.next.next.next.next = new ListNode146(9);
        int k = 3;

        ListNode146 result = solution.rotateLeft(head, k);
        printList(result);
    }

    // Helper method to print the linked list
    private static void printList(ListNode146 head) {
        ListNode146 curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
