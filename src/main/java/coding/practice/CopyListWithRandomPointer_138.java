package coding.practice;

public class CopyListWithRandomPointer_138 {

    //TODO
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(10);

        System.out.println(copy(head));
    }

    private static RandomListNode copy(RandomListNode head) {
        //create copy nodes next to original nodes
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode node = new RandomListNode(iter.label);
            node.next = iter.next;
            iter.next = node;

            iter = iter.next;
        }

        //copy random pointers
        iter = head;
        while (iter != null) {
            iter.next.random = iter.random.next;

            iter = iter.next.next;
        }

        //split the nodes and return copy head
        RandomListNode copy = head.next;
        RandomListNode cIter = copy;
        iter = head;
        while (iter != null) {
            cIter.next = cIter.next.next;
            cIter = cIter.next;

            iter.next = iter.next.next;
            iter = iter.next;
        }


        return copy;


    }


    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
            next = null;
            random = null;
        }
    }
}
