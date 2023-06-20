class Node144 {
    int data;
    Node144 next, arb;

    Node144(int data) {
        this.data = data;
        next = arb = null;
    }
}

class LinkedListCopy144 {
    Node144 head;

    // Function to print the linked list
    void printList(Node144 node) {
        Node144 temp = node;
        while (temp != null) {
            Node144 arb = temp.arb;
            int arbData = (arb != null) ? arb.data : -1;
            System.out.println("Data: " + temp.data + ", Random Pointer Data: " + arbData);
            temp = temp.next;
        }
    }

    // Function to clone the linked list
    protected Node144 clone() {
        // Step 1: Create new nodes and insert them between original nodes
        Node144 curr = head;
        while (curr != null) {
            Node144 newNode = new Node144(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Update the arbitrary pointers of the new nodes
        curr = head;
        while (curr != null) {
            curr.next.arb = (curr.arb != null) ? curr.arb.next : null;
            curr = curr.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node144 original = head;
        Node144 cloned = head.next;
        Node144 clonedHead = cloned;

        while (original != null && cloned != null) {
            original.next = original.next.next;
            cloned.next = (cloned.next != null) ? cloned.next.next : null;
            original = original.next;
            cloned = cloned.next;
        }

        return clonedHead;
    }
}

public class ASSIGN144 {
    public static void main(String[] args) {
        LinkedListCopy144 list = new LinkedListCopy144();

        // Creating the linked list
        list.head = new Node144(1);
        list.head.next = new Node144(2);
        list.head.next.next = new Node144(3);
        list.head.next.next.next = new Node144(4);

        // Setting up the arbitrary pointers
        list.head.arb = list.head.next;
        list.head.next.arb = list.head.next.next.next;
        list.head.next.next.arb = list.head.next.next.next;
        list.head.next.next.next.arb = list.head.next;

        // Cloning the linked list
        Node144 clonedHead = list.clone();

        // Printing the cloned list
        list.printList(clonedHead);
    }
}
