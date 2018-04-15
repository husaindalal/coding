package coding.practice;

import coding.practice.common.ListNode;

public class AddTwoNumbers_2 {

    public static void main(String[] args) {

        ListNode<Integer> list1 = new ListNode<>(9);

        ListNode<Integer> list2 = new ListNode<>(8);


        System.out.println(run(list1, list2));
    }

    private static ListNode<Integer> run(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (size(head1) < size(head2)) {
            return runHelper(head2, head1);
        } else {
            return runHelper(head1, head2);
        }
    }

    //head1 size is larger or equal
    private static ListNode<Integer> runHelper(ListNode<Integer> head1, ListNode<Integer> head2) {
        ListNode<Integer> sentinal = new ListNode<>(0, head1);
        ListNode<Integer> iter = sentinal;

        ListNode<Integer> iter1 = head1;
        ListNode<Integer> iter2 = head2;

        Integer carry = 0;
        while (iter1 != null || iter2 != null) {
            Integer sum = iter1.getVal() + iter2.getVal() + carry;
            iter.setNext(new ListNode<>(sum % 10));
            carry = sum / 10;

            iter1 = iter1.getNext();
            iter2 = iter2.getNext();
            iter = iter.getNext();
        }

        if (carry > 0) {
            iter.setNext(new ListNode<>(carry));

        }

        return sentinal.getNext();
    }

    private static int size(ListNode<Integer> head1) {
        return 0;
    }

}
