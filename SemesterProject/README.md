#Binary Search Tree Project (Marist College: CMPT220)
The Binary Search Tree class allows the user to add nodes to the tree, manipulate its structure, delete nodes from the tree,
retrieve its height, and etc.

##Node Class:
````
Node n = new Node();

n.left => left child

n.right => right child
````

##Binary Search Tree Class
````
Binary_Search_Tree BST = new Binary_Search_Tree();

//adds new node from a a Node/root to Binary Tree with new_data integer appended to new node
BST.add(Node root, int new_data);

//finds the node in the tree from the root node that has the identical data
BST.find_element(Node root, int data);

//finds the height of the tree
BST.find_height(Node root);

//returns the node with the smallest data value
BST.find_smallest(Ndoe root);

//returns the node with the largest data value
BST.find_largest(Node root);

//returns the value appended to the node that is the Nth largest value in the tree
BST.find_NLargest(Node root, int N);

//prints all nodes.data values on the specified level of the tree
BST.getLevel(Node root, int level);

//prints the list of nodes.data values using in-order search
BST.inOrder(Node root);

//prints the list of nodes.data values using pre-order search
BST.preOrder(Node root);

//printst the lsit of nodes.data values using post-oder search
BST.postOrder(Node root);

//prints list of nodes using breadth-first search
BST.breadthFirst(Node root);

//prints list of nodes using depth-first search
BST.depthFirst(Node root);
````

