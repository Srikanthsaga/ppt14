class Node143 {
    int data;
    Node143 next;
    Node143 bottom;

    Node143(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

class LinkedListFlattening143 {
    Node143 head;

    // Function to merge two sorted linked lists
    Node143 mergeLists(Node143 a, Node143 b) {
        // If one of the lists is empty, return the other list
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node143 result;

        // Choose the smaller value as the head of the merged list
        if (a.data <= b.data) {
            result = a;
            result.bottom = mergeLists(a.bottom, b);
        } else {
            result = b;
            result.bottom = mergeLists(a, b.bottom);
        }

        return result;
    }

    // Function to flatten the linked list
    Node143 flatten(Node143 head) {
        // Base case: If the list is empty or there is only one node
        if (head == null || head.next == null)
            return head;

        // Recursively flatten the next node
        head.next = flatten(head.next);

        // Merge the current list with the flattened next node
        head = mergeLists(head, head.next);

        // Return the merged list
        return head;
    }

    // Function to display the linked list using the bottom pointer
    void display(Node143 head) {
        Node143 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.bottom;
        }
        System.out.println();
    }
}

public class ASSIGN143 {
    public static void main(String[] args) {
        LinkedListFlattening143 list = new LinkedListFlattening143();

        // Creating the linked list
        list.head = new Node143(5);
        list.head.next = new Node143(10);
        list.head.next.next = new Node143(19);
        list.head.next.next.next = new Node143(28);

        list.head.bottom = new Node143(7);
        list.head.bottom.bottom = new Node143(8);
        list.head.bottom.bottom.bottom = new Node143(30);

        list.head.next.bottom = new Node143(20);

        list.head.next.next.bottom = new Node143(22);
        list.head.next.next.next.bottom = new Node143(35);

        list.head.next.next.next.bottom.bottom = new Node143(40);
        list.head.next.next.next.bottom.bottom.bottom = new Node143(45);

        list.head = list.flatten(list.head);

        list.display(list.head);
    }
}
