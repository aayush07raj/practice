import java.util.LinkedList;
import java.util.Queue;

public class tree {


    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data= data;
            this.left=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
                idx++;
                if(nodes[idx] == -1){
                    return null;
                }

                 Node newNode = new Node(nodes [idx]);
                 newNode.left =buildTree(nodes);
                 newNode.right=buildTree(nodes);

                 return newNode;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        
        preOrder(root.left);
        System.out.println(root.data+" ");
        preOrder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.data+" ");
    }


    public static void levelOrder(Node root){
        if(root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null) {
                System.out.println();
                //queue empty
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data+" ");
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }



    public static void main(String args[]){
        int nodes[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preOrder(root);
    }
}