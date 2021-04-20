import java.util.ArrayList;
import java.util.Scanner;

public class Binary_Search_Tree {
    //initialize variable
    private ArrayList<Integer> nodes; //A set of nodes where order matters and first element is the base parent node
    private int length; //Node length
    private int parent;
    //create constructor
    public Binary_Search_Tree(ArrayList<Integer> n){
        this.nodes = n;
        this.parent = n.get(0);
        this.length = n.size();
    }
    //Inserting new element/new node
    public void insert(int new_node){
        this.nodes.add(new_node);
    }
    //custom input method
    public static void custom_input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of ArrayList");
        int n = scan.nextInt();
        ArrayList<Integer> sample_nodes = new ArrayList<Integer>(n);
        for ( int i = 0; i < n; i++) {
            System.out.println("Enter element in Array (Order Matters)");
            sample_nodes.add(scan.nextInt());
        }
        System.out.println("Sample ArrayList: " + sample_nodes);
        scan.close();
    }
    public static void main(String args[]){
        //custom_input();
    }

}
