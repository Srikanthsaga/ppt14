class Node457 {
    int data;
    Node457 next;

    Node457(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList457 {
    Node457 head;

    // Function to add 1 to the number represented as linked list
    Node457 addOne(Node457 head) {
        // Reverse the linked list
        head = reverseLinkedList(head);

        Node457 current = head;
        int carry = 1;

        // Traverse the reversed list and add 1 to each digit
        while (current != null) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            current = current.next;
        }

        // If carry is still remaining, create a new node and set it as the head
        if (carry > 0) {
            Node457 newNode = new Node457(carry);
            newNode.next = head;
            head = newNode;
        }

        // Reverse the linked list again to restore the original order
        head = reverseLinkedList(head);

        return head;
    }

    // Function to reverse a linked list
    Node457 reverseLinkedList(Node457 head) {
        Node457 prev = null;
        Node457 current = head;

        while (current != null) {
            Node457 next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // Function to display the linked list
    void display(Node457 head) {
        Node457 current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

public class ASSIGN142 {
    public static void main(String[] args) {
        LinkedList457 list = new LinkedList457();
        list.head = new Node457(4);
        list.head.next = new Node457(5);
        list.head.next.next = new Node457(6);

        System.out.print("Input: ");
        list.display(list.head);

        list.head = list.addOne(list.head);

        System.out.print("Output: ");
        list.display(list.head);
    }
}
