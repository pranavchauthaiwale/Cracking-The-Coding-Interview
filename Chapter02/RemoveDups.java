package Chapter02;

import Chapter02.LinkedListUtils.LinkedListUtils;
import Chapter02.LinkedListUtils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getLinkedListWithDuplicates();
        LinkedListUtils.printLinkedList(head);
        removeDuplicatesFromLinkedList(head);
        System.out.println("After removing duplicates : ");
        LinkedListUtils.printLinkedList(head);
    }

    private static void removeDuplicatesFromLinkedList(ListNode head) {
        if (head == null) {
            return;
        }
        Set<Integer> elements = new HashSet<>();
        ListNode currentNode = head;
        ListNode previousNode = head;
        while (currentNode != null) {
            int data = currentNode.getData();
            if (elements.add(data)) {
                previousNode = currentNode;
            } else {
                previousNode.setNext(currentNode.getNext());
            }
            currentNode = currentNode.getNext();
        }
    }
}
