package DSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class maxHeightofBinaryTree {
    public int maxDepth(TreeNode root) {


        if(root == null)
        {
            return 0;
        }
        int lheight = maxDepth(root.left);
        System.out.println(lheight);
        int rheight = maxDepth(root.right);
        System.out.println(rheight);

        return Math.max(lheight,rheight)+1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        maxHeightofBinaryTree mm = new maxHeightofBinaryTree();
        mm.maxDepth(root);

    }
}
