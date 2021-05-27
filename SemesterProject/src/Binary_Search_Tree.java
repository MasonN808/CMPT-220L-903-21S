import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Binary_Search_Tree{
    //initialize variables
    ArrayList<Integer> nodes1 = new ArrayList<Integer>();
    Node root;
    //create constructor
    public Binary_Search_Tree(){
        this.root = null;
    }

    //Inserting new element/new node
    public Node add(Node root, int new_data) {
        //check root exists
        if (root == null) {
            Node new_node = new Node(new_data);
            root = new_node;
            //make root the root
            return root;
        }
        //check to see if root belongs in left subtree or right subtree
        if (root.data > new_data){
            root.left = add(root.left, new_data);
        }
        else if (root.data <= new_data){
            root.right = add(root.right, new_data);
        }
        return root;
    }


    //recursively find the element
    public static Node find_element(Node root, int data){
        if(root == null || data == root.data){
            return root;
        }
        else if(data < root.data){
            return find_element(root.left, data);
        }
        else{
            return find_element(root.right, data);
        }
    }

    public static int find_height(Node root){
        //check to see if root exists, if not height is zero
        if(root == null){
            return 0;
        }
        else {
            //find the maximal height of the left subtree from the root
            int left_height = find_height(root.left);
            //find the maximal height of the right subtree from the root
            int right_height = find_height(root.right);
            //check which is the largest then add 1
            if (left_height > right_height){
                return left_height + 1;
            }
            else{
                return right_height+1;
            }
        }
    }


    //finds smallest element in BST
    public static Node find_smallest(Node root){
        Node cur = root;
        if(cur.left != null){
            cur = cur.left;
            return find_smallest(cur);
        }
        else {
            return cur;
        }
    }
    //finds largest element in BST
    public static Node find_largest(Node root){
        Node cur = root;
        if(cur.right!= null){
            cur = cur.right;
            return find_largest(cur);
        }
        else {
            return cur;
        }
    }


    public int find_NLargest(Node root, int n){
        //reindex
        n = n-1;
        if(n > this.nodes1.size() || n < 0 || root == null){
            //return -1 if n not in index or root is null
            return -1;
        }
        else{
            //not that the inOrder method must be run before the find_NLargest method
            //sort this.nodes1 in descending order
            Collections.sort(this.nodes1,Collections.reverseOrder());
            //get the nth index of this.nodes1
            int temp = this.nodes1.get(n);
            return temp;
        }
    }

    //does left, then root, then right
    public void inOrder(Node root){
        if(root == null){
            return;
        }

        Node cur = root;
        Stack<Node> nodes = new Stack<Node>();
        //terminate when no more nodes to run through
        while(nodes.size() != 0 || cur != null){
            //check if current node is null
            if(cur!= null){
                //push the current node to stack
                nodes.push(cur);
                //now first go to the left child of the current node
                cur = cur.left;
            }
            else{
                //if current node is null, pop previous node from the stack
                Node temp_node = nodes.pop();
                //output the previous node data
                System.out.print(temp_node.data+ " ");
                //append data to arrayList for reference
                this.nodes1.add(temp_node.data);
                //go to the right child instead
                cur = temp_node.right;
            }
        }
    }

    //does root, then left, then right
    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        Stack<Node> nodes = new Stack<Node>();
        nodes.push(root);
        //terminate when no more nodes to run through
        while(nodes.size() != 0){
            Node cur = nodes.pop();
            System.out.print(cur.data+ " ");
            //check if right child of current node is null
            //we go right first since stack is LIFO
            if(cur.right != null){
                //push the right child of current node to stack
                nodes.push(cur.right);
            }
            //check if left child of current node is null
            if(cur.left != null){
                //push the left child of current node to stack
                nodes.push(cur.left);
            }
        }
    }

    public static void printStack(Stack<Node> s){
        if(s.empty()){
            return;
        }
        System.out.print(s.pop().data + " ");
        printStack(s);
    }

    //does left, then right, then root
    public static void postOrder(Node root){
        Stack<Node> nodes1 = new Stack<Node>();
        Stack<Node> nodes2 = new Stack<Node>();
        if(root == null){
            return;
        }
        nodes1.push(root);

        while(nodes1.size() != 0){
            Node cur = nodes1.pop();
            nodes2.push(cur);
            if(cur.left != null){
                nodes1.push(cur.left);
            }
            else if(cur.right != null){
                nodes1.push(cur.right);
            }
            printStack(nodes2);
        }

    }

    //prints the elements in the level of the BST
    public static void getLevel(Node root, int level){
        if(root == null){
            return;
        }
        if (level > 1){
            getLevel(root.left,level -1);
            getLevel(root.right, level-1);
        }
        else{
            System.out.print(root.data + " ");
        }
    }


    public static void getLevel_atIndex(Node root, int level, int index) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        if (level > 1) {
            getLevel(root.left, level - 1);
            getLevel(root.right, level - 1);
        } else {
            nodes.add(root.data);
        }

        System.out.println(nodes.toString());
    }



    public static void breadthFirst(Node root){
        if(root == null) {
            return;
        }
        for(int i = 1; i <= find_height(root); i++){
            getLevel(root, i);
        }
    }

    public static void depthFirst(Node root){
        if(root == null) {
            return;
        }
        else{
            if(root.left != null){

            }
        }
    }



    public static void deleteNode(Node n){

    }

    public static void main(String args[]){
        Binary_Search_Tree bst = new Binary_Search_Tree();
        Node root = new Node(10);
        bst.add(root, 5);
        bst.add(root, 12);
        bst.add(root, 3);
        bst.add(root, 7);
        bst.add(root, 14);
        bst.add(root, 11);

        System.out.println("--------------------");
        System.out.println("Find element in BST: ");
        System.out.println(find_element(root, 5));
        System.out.println("--------------------");
        System.out.println("BST in Inorder: ");
        bst.inOrder(root);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("BST in Preorder: ");
        bst.preOrder(root);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("BST in Postorder: ");
        bst.postOrder(root);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Find height of BST: ");
        System.out.println(bst.find_height(root));
        System.out.println("--------------------");
        System.out.println("Find smallest element in BST: ");
        System.out.println(bst.find_smallest(root).data);
        System.out.println("--------------------");
        System.out.println("Find largest element in BST: ");
        System.out.println(bst.find_largest(root).data);
        System.out.println("--------------------");
        System.out.println("Find Nth largest element in BST: ");
        System.out.println(bst.find_NLargest(root, 2));
        System.out.println("--------------------");
        System.out.println("Get level: ");
        bst.getLevel(root, 2);
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Breadth First Search: ");
        bst.breadthFirst(root);
        System.out.println();
        System.out.println("--------------------");
        //System.out.println("Depth First Search: ");
        //bst.depthFirst(root);
    }
}

