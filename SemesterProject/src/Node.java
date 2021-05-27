public class Node {
    Node left, right;
    int data;
    public Node(int data){
        this.data = data;
        left = right = null;
    }

    public Node getLeft() {
        return left;
    }

    public int getData() {
        return data;
    }

    public Node getRight() {
        return right;
    }
}
