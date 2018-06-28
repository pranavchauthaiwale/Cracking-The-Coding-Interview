package Chapter02;

import Chapter02.LinkedListUtils.LinkedListUtils;
import Chapter02.LinkedListUtils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class KthToLast {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.getSimpleLinkedList();
        LinkedListUtils.printLinkedList(head);
        int k = 120;
        int result = getKthToLastElement(head, k);
        System.out.println("K is " + k);
        System.out.println("Result 1 is: " + result);
        result = getKthToLastElement2(head, k);
        System.out.println("Result 2 is: " + result);
        result = getKthToLastElement3(head, k);
        System.out.println("Result 3 is: " + result);
    }

    public static int getKthToLastElement(ListNode head, int k) {
        if (head == null || k <= 0) {
            //Assuming that every element in the linked list is non negative
            return -1;
        }

        // Two pass method. In first pass identifying the length of list.
        // Then, in the second pass identifying the Kth element
        int length = 0;
        ListNode currenetElement = head;
        while (currenetElement != null) {
            currenetElement = currenetElement.getNext();
            length++;
        }

        int index = length - k;
        if (index < 0) {
            return -1;
        }

        currenetElement = head;
        for (int i = 1; i <= index; i++) {
            currenetElement = currenetElement.getNext();
        }
        return currenetElement.getData();
    }

    private static int getKthToLastElement2(ListNode head, int k){
        // Using arraylist to store all references of ListNodes
        if(head == null || k <= 0){
            return -1;
        }
        int length = 0;
        List<ListNode> list = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null){
            list.add(currentNode);
            currentNode = currentNode.getNext();
            length++;
        }
        int index = length - k;
        if(index < 0){
            return -1;
        }
        return list.get(index).getData();
    }

    private static int getKthToLastElement3(ListNode head, int k){
        // using two pointers with single pass

        if(head == null || k <= 0){
            return -1;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;

        for(int i = 1; i < k; i++){
            if(fastPointer != null){
                fastPointer = fastPointer.getNext();
            }
        }
        if(fastPointer == null){
            return -1;
        }
        while(fastPointer.getNext() != null){
            fastPointer = fastPointer.getNext();
            slowPointer = slowPointer.getNext();
        }
        return slowPointer.getData();
    }
}
