/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class TreeNode
{
    int val;
    TreeNode left,right;
    TreeNode(int key)
    {
        val=key;
    }
    
}
class Pair
{
    TreeNode node;
    int value;
    Pair(TreeNode node,int value)
    {
        this.node=node;
        this.value=value;
    }
}

public class Main
{
	public static void main(String[] args) {
	    TreeNode tree1=new TreeNode(1);
	    tree1.left=new TreeNode(2);
	    tree1.right=new TreeNode(3);
	    tree1.left.left=new TreeNode(4);
	    tree1.left.right=new TreeNode(5);
	    tree1.right.left=new TreeNode(6);
	    tree1.right.right=new TreeNode(7);
          
        ArrayList<Integer>preOrder=new ArrayList<Integer>();
        ArrayList<Integer>inOrder=new ArrayList<Integer>();
        ArrayList<Integer>postOrder=new ArrayList<Integer>();

         Stack<Pair>stk=new Stack<>();
         stk.push(new Pair(tree1,1));
          
         while(!stk.isEmpty())
         {
             Pair temp=stk.peek();
             int k=temp.value;
            if(k==1)
            {
                preOrder.add(temp.node.val);
                temp.value++;
                if(temp.node.left!=null)
                 {
                     stk.push(new Pair(temp.node.left,1));
                 }
            }
            else if(k==2)
            {
                inOrder.add(temp.node.val);
                temp.value++;
                if(temp.node.right!=null)
                {
                    stk.push((new Pair(temp.node.right,1)));
                }
                }
            else 
            {
                postOrder.add(temp.node.val);
                stk.pop();
            }
         }
          
          for(int num:postOrder)
            System.out.print(num+" ");
          
          
          
	} 
}
