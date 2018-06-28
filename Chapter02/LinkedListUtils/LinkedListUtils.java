package Chapter02.LinkedListUtils;

import java.util.concurrent.ThreadLocalRandom;

public class LinkedListUtils {

    public static ListNode getSimpleLinkedList() {
        ListNode head = new ListNode(12);
        ListNode current = head;

        for (int i = 0; i < 15; i++) {
            int data = ThreadLocalRandom.current().nextInt(0, 35);
            ListNode newNode = new ListNode(data);
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }

    public static ListNode getLinkedListWithDuplicates() {
        int[] contents = new int[]{5, 12, 4, 26, 5, 11, 7, 14, 28, 26, 11, 7, 24, 12};
        ListNode head = new ListNode(2);
        ListNode current = head;
        for(int data : contents){
            ListNode newNode = new ListNode(data);
            current.setNext(newNode);
            current = newNode;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        System.out.print("[ ");
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.print("]");
    }
}
