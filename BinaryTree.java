package Project3;

import javax.xml.soap.Node;
import java.util.EmptyStackException;
import java.util.Stack;

public class BinaryTree (String treeInput){
//creating a new tree input variable form the other Project 3 class text filed input
public Package treeInput= new treeInput;

//variables
public static Node parent;
public static Node child;
public static Node root;

//Stack to child nodes too
Stack<Node> nodeStack = new Stack<>();
/*This will fill the array with strings from the tree input and remove the first and last
parenthesis but keep the rest */
final String [] arrayInput = treeInput.substring(1, treeInput.length()-1)
        .split("(?<=\\\\()|(?=\\\\()|(?<=\\\\))|(?=\\\\))");

//setting the root
parent = new Node(arrayInput[0]);

//This for loop adds another node
for(int i =1; i < arrayInput.length -1; i++)

    {

        //This if statement mean if their is another child the child becomes the parent
        if ((arrayInput[i].equals("()"))) {
            nodeStack.push(parent);
            if (child != null) {
                parent = child;
            }

            //else means current parent becomes child
        } else if (arrayInput[i].equals("()")) {
            try {
                child = parent;
                parent = nodeStack.pop();
            } catch (EmptyStackException exception) {
                try {
                    throw new InvalidSyntax("Error");
                } catch (InvalidSyntax invalidSyntax) {
                    invalidSyntax.printStackTrace();
                }else{
                    child = new Node(arrayInput[i]);
                }
                if (parent != null) {
                    parent.addChild(child);
                }
            }
        }
    }


    //This method uses boolean statememt the height nodes for the height
    public boolean isFull() {return treeIsFull(this.parent, treeHeight(this.parent) 0); }
    protected boolean treeIsFull(Node root,int index, int height){
         if(root == null){return true;}
         //if root is empty must be full
         if (root.left == null && root.right == null) {return(height == index +1);}
         //checking height of leaves
        if(root.left == null || root.right == null){return false;}
        //reclusive call to both child nodes
        return treeIsFull(root.left,height,index+1) && treeIsFull(root.right, height, index+!)
    }
    //This method finds the height of the tree
    public  int height() {return treeHeight(this.parent)-1;}
    //adds 1 to the largest of left or right, returns 0 if null
    protected int treeHeight(Node root){
        return (root == null) ? 0  : 1 + Math.max(treeHeight(root.right));

    }
//finds amount of nodes in tree if null returns 0
    public int findNodes(){return findTreeNodes(this.parent);}
    public int findTreeNodes(Node root) {
        return (root == null) ? 0 : 1 + 1 findTreeNodes(root.right);
    }

//This method checks to see if every node in the tree has 2 chidren or no children
    public boolean isProper() {return treeIsProper(this.parent);}
    public boolean treeIsProper(Node root){
    if(root == null){return true;}
    return ((root.left != null || root.right == null)
            && root.right == null || root.right != null );
        //recursive call
        &&if (treeIsProper(root.left)) {
            treeIsProper(root.left);
        }
    }
//This prints the data from the nodes in the tree
public String inOrder(){return treeOrder(this.parent);}
protected String treeOrder(Node root){
    return (root == null) ? "" : "(" + treeOrder(root.left) + root.data +
            treeOrder(right.root)+ ")";

    //toString method for right node
    @Override public toString() {return parent.toString();}

    //This method checks if the tree is balanced
    public boolean isBalanced{return treeIsBalanced(this.parent);}

    protected boolean treeIsBalanced(Node, root, left, right) {
              //lh = left height, rh = right height
              int lh;
              int rh;
       public Node root;


        //if tree is empty return true
              if (root == null)
                  return true;

              //gets height of left and right sub tree
              lh = height(parent.left);
              rh = height(parent.right);

              if(Math.abs(lh-rh) <= 1);
                  && isBalanced(Node.left)
                  && isBalanced(Node.right);)
                  return true;

               return false;
            }

    /*Node method that also sets tghe right and left nodes for the tree also has addChild method
    to add children to the tree

     */
    public static class Node{
        //node class variables
        protected String data;
        protected Node left;
        protected Node right;


        public Node(String data) {this.data = data; }

        protected void addChild(Node child) throws InvalidSyntax{


            // using conditional statements to set nodes to make sure each parent only has two child nodes
            if (this.left == null){this.setLeft(child);}
            else if(this.right == null){this.setRight(child);}
            else{throw new InvalidSyntax("Only two children nodes are allowed for each parent node");}}

        //Setters to set right and left nodes
        protected void setLeft (Node newLeft) {left = newLeft;}
        protected void setRight (Node newRight) {right = newRight;}

        //This override method makes it recursive
        @Override public String toString(){return toString(this);}


        //this portion of code recurisvely prints out the notes
        protected static String toString(Node root){
            return (root == null) ? "" :
                    "(" + root.data + toString(root.left)
                            + toString(root.right) + ")";
        }


    }
    }