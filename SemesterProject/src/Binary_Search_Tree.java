


import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Binary_Search_Tree{
    //initialize variables
    ArrayList<Integer> nodes1 = new ArrayList<>();
    Node root;
    //create constructor
    public Binary_Search_Tree(){
        this.root = null;
    }

    /**
     * Adds/Inserts a new node to the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @param  new_data the data/number to be attached to the new node
     * @return      the added node
     */
    //Inserting new element/new node
    public Node add(Node root, int new_data) {
        //check root exists
        if (root == null) {
            root = new Node(new_data);
            //make root the root
            return root;
        }
        //check to see if root belongs in left subtree or right subtree
        if (root.data > new_data){
            root.left = add(root.left, new_data);
        }
        else if (root.data < new_data){
            root.right = add(root.right, new_data);
        }
        return root;
    }

    /**
     * Searches for the node that has our desired data
     * @param  root  the root of the Binary Search Tree
     * @param  data  the data of the node to be found
     * @return      the found node
     */
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

    /**
     * Finds the height of the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @return      returns 0 if root does not exist or returns the height of the Binary Search Tree
     */
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

    /**
     * Finds the Node with the smallest element in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @return      null if root does not exist or return node with smallest element
     */
    //finds smallest element in BST
    public static Node find_smallest(Node root){
        if (root == null){
            return null;
        }
        Node cur = root;
        //search through the left most branches until current node is null
        if(cur.left != null){
            cur = cur.left;
            return find_smallest(cur);
        }
        else {
            return cur;
        }
    }

    /**
     * Finds the node with the largest element in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @return      null if root does not exist or the node with the largest element
     */
    //finds largest element in BST
    public static Node find_largest(Node root){
        if(root == null){
            return null;
        }
        Node cur = root;
        //search through the right most branches until current node is null
        if(cur.right!= null){
            cur = cur.right;
            return find_largest(cur);
        }
        else {
            return cur;
        }
    }

    /**
     * Finds the nth largest element in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @param  n the index of the nth largest element
     * @return      -1 if the root does not exist or the nth largest int element
     */
    public int find_NLargest(Node root, int n){
        if (root == null){
            return -1;
        }
        //reindex
        n = n-1;
        if(n > this.nodes1.size() || n < 0){
            //return -1 if n not in index or root is null
            return -1;
        }
        else{
            //not that the inOrder method must be run before the find_NLargest method
            //sort this.nodes1 in descending order
            Collections.sort(this.nodes1,Collections.reverseOrder());
            //get the nth index of this.nodes1
            return this.nodes1.get(n);
        }
    }

    /**
     * Uses the in-order search method to search through all the nodes in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     */
    //does left, then root, then right
    public void inOrder(Node root){
        if(root == null){
            return;
        }

        Node cur = root;
        Stack<Node> nodes = new Stack<>();
        //terminate when no more nodes to run through
        while(!nodes.isEmpty() || cur != null){
            //check if current node is null
            if(cur!= null){
                //push the current node to stack
                nodes.push(cur);
                //now first go to the left child of the current node
                cur = cur.left;
            }
            else{
                //if current node is null, pop previous node from the stack
                Node temp = nodes.pop();
                //output the previous node data
                System.out.print(temp.data+ " ");
                //append data to arrayList for reference
                this.nodes1.add(temp.data);
                //go to the right child instead
                cur = temp.right;
            }
        }
    }

    /**
     * Uses the pre-order search method to search through all the nodes in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     */
    //does root, then left, then right
    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        //terminate when no more nodes to run through
        while(!nodes.isEmpty()){
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

    //used to printStacks; used in postOder(Node n)
    public static void printStack(Stack<Node> s){
        if(s.empty()){
            return;
        }
        System.out.print(s.pop().data + " ");
        printStack(s);
    }

    /**
     * Uses the post-order search method to search through all the nodes in the Binary Search Tree
     * @param  root  the root of the Binary Search Tree
     * @return      the printed elements using post-order
     */
    //does left, then right, then root
    public static void postOrder(Node root){
        //Use this stack as a temporary storage unit; will be of size = 0 when successfully terminated
        Stack<Node> nodes1 = new Stack<Node>();
        //use this stack to keep track of what has been searched
        Stack<Node> nodes2 = new Stack<Node>();
        //check root exists
        if(root == null){
            return;
        }
        //check root node first
        nodes1.push(root);
        //run until nodes1 is empty
        while(nodes1.size() != 0){
            //pop the node
            Node cur = nodes1.pop();
            //push to permanent stack, nodes2
            nodes2.push(cur);
            if(cur.left != null){
                nodes1.push(cur.left);
            }
            if(cur.right != null){
                nodes1.push(cur.right);
            }
        }
        //print the permanent stack
        printStack(nodes2);
    }

    /**
     * Gets the nodes' elements on the specified level
     * @param  root  the root of the Binary Search Tree
     * @param  level  the level of the tree in the range [0, height of BST]
     * @return      the printed elements on the level
     */
    //prints the elements in the level of the BST
    public static void getLevel(Node root, int level){
        //check if root is null
        if(root == null){
            return;
        }
        if (level > 1){
            //recursively go through each level of the tree, until you reach the base case (level = 1)
            getLevel(root.left,level -1);
            getLevel(root.right, level-1);
        }
        else{
            System.out.print(root.data + " ");
        }
    }

    /**
     * Uses the Breadth First search method
     * @param  root  the root of the Binary Search Tree
     * @return      the printed elements using Breadth First Search
     */
    //Searches iteratively from left to right on each level of the Tree
    public static void breadthFirst(Node root){
        //check if root exists
        if(root == null) {
            return;
        }
        //print out the nodes on each level and print nodes from left to right
        for(int i = 1; i <= find_height(root); i++){
            getLevel(root, i);
        }
    }

    /**
     * Uses the Depth First search method
     * @param  root  the root of the Binary Search Tree
     * @return       the printed elements using the Depth First method
     */
    //Searches from top to bottom and left to right
    public static void depthFirst(Node root){
        //check if root exists
        if(root == null) {
            return;
        }
        Stack<Node> nodes = new Stack<Node>();
        nodes.push(root);

        while(nodes.size() != 0){
            //pop root node and assign to current node
            Node cur = nodes.pop();
            //push right child if right child exists
            if(cur.right != null){
                nodes.push(cur.right);
            }
            //push left child if left child exists
            if(cur.left != null){
                nodes.push(cur.left);
            }
            //print the current node's data
            System.out.print(cur.data + " ");
        }
    }


    /**
     * Gets the nodes' elements on the specified level
     * @param  root  the root of the Binary Search Tree
     * @param  n  the node to be removed
     * @return      the Binary Search Tree after deletion of node n
     */
    public void deleteNode(Node root, Node n){
        //check if root is in BST
        if(root == null){
            return;
        }
        //see if Node n is in the BST
        for(int i : this.nodes1){
            if(n.data != i){
                return;
            }
        }
        //if()
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
        System.out.println("Depth First Search: ");
        bst.depthFirst(root);
    }
}

