import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        bfs(root);
        System.out.println("dfspr start");
        dfspr(root);
        System.out.println("dfspr end");
        System.out.println("dfsin start");
        dfsin(root);
        System.out.println("dfsin end");
        System.out.println("dfspo start");
        dfspo(root);
        System.out.println("dfspo end");
    }
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void bfs(Node root) {
        System.out.println("bfs start");
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        System.out.println("bfs end");
    }
    public static void dfspr(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        dfspr(root.left);
        dfspr(root.right);
    }
    public static void dfsin(Node root) {
        if(root == null) {
            return;
        }
        dfsin(root.left);
        System.out.print(root.data + " ");
        dfsin(root.right);
    }
    public static void dfspo(Node root) {
        if(root == null) {
            return;
        }
        dfspo(root.left);
        dfspo(root.right);
        System.out.print(root.data + " ");
    }
}
