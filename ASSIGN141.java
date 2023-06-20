class Node141 {
    int data;
    Node141 next;
    Node141 prev;

    Node141(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class LinkedList141 {
    Node141 head;

    void insert(int data) {
        Node141 newNode = new Node141(data);
        if (head == null) {
            head = newNode;
        } else {
            Node141 current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    Node141 deleteNodeAtPosition(int position) {
        if (head == null)
            return null;

        Node141 current = head;

        // If head needs to be removed
        if (position == 1) {
            head = current.next;
            if (head != null)
                head.prev = null;
            return current;
        }

        // Traverse to the position where the node is to be deleted
        int count = 1;
        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        // If position exceeds the length of the list
        if (current == null)
            return null;

        // Remove the node from the list
        current.prev.next = current.next;
        if (current.next != null)
            current.next.prev = current.prev;

        return current;
    }

    void display() {
        Node141 current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class ASSIGN141 {
    public static void main(String[] args) {
        LinkedList141 list = new LinkedList141();
        list.insert(1);
        list.insert(3);
        list.insert(4);

        System.out.println("Original Linked List:");
        list.display();

        int position = 3;
        Node141 deletedNode = list.deleteNodeAtPosition(position);

        if (deletedNode != null)
            System.out.println("Deleted node with data: " + deletedNode.data);
        else
            System.out.println("Invalid position");

        System.out.println("Linked List after deleting node at position " + position + ":");
        list.display();
    }
}
