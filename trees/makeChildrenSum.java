/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class TreeNode 
{
    int  val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class Main
{
    public static void makeSumEqual(TreeNode root)
    {
        if(root==null) return ;
        int child=0;
        if(root.left!=null) child+=root.left.val;
        if(root.right!=null) child+=root.right.val;
        
        if(child >=root.val)
        {
            root.val=child;
        }
        else 
        {
            if(root.left!=null) root.left.val=root.val;
            if(root.right!=null) root.right.val=root.val;
        }
        
        makeSumEqual(root.left);
        makeSumEqual(root.right);
        
        
        int total=0;
         if(root.left!=null) total+=root.left.val;
         if(root.right!=null) total+=root.right.val;
         if(root.left!=null || root.right!=null ) root.val=total;
         
        
    }
	public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(35);
        root.right = new TreeNode(10);
        
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(2);
        
        makeSumEqual(root);
        printTree(root);

		
	}
	
	public static void printTree(TreeNode root)
	{
	     List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
        }
          for (List<Integer> l : result) {
            System.out.println(l);
        }
	}
	
}
