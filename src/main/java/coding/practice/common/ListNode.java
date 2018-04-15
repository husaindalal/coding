package coding.practice.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListNode<T> {

    T val;
    ListNode<T> next;

    public ListNode(T x) {
        val = x;
        next = null;
    }

    public ListNode(T x, ListNode nx) {
        val = x;
        next = nx;
    }

//    public static ListNode<T> of(T... vals)  {
//
//    }

}
