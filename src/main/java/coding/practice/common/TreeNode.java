package coding.practice.common;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode<T> {
    T val;
    TreeNode left;
    TreeNode right;

    TreeNode(T x) {
        val = x;
        left = null;
        right = null;
    }

}
