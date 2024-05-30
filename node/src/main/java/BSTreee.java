public class BSTreee {
    static class Node {
        int data;
        Node left, right;
        // hello
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    public BSTreee() {
        root = null;
    }
    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        }
        return root;
    }
    public Node search(Node root, int data) {
        if (root == null) {
            System.out.println("Not Found : " + data);
            return null;
        }
        if (root.data == data) {
            System.out.println("Found : " + root.data);
            return root;
        }
        if (root.data > data) {
            return search(root.left, data);
        }
        return search(root.right, data);
    }
    public Node delete(Node root, int data) {
        if (root == null) {
            System.out.println("Not Found : " + data);
        }
        if (root.data > data) {
            root.left = delete(root.left, data);
        }
        if (root.data < data) {
            root.right = delete(root.right, data);
        }
        else {
            if (root.right == null) {
                System.out.println("Delete : " + root.data);
                return root.left;
            }
            else if (root.left == null) {
                System.out.println("Delete : " + root.data);
                return root.right;
            }
            System.out.println("Delete : " + root.data);
            root = root.right;
        }

        return root;
    }

    public static void main(String[] args) {
        BSTreee tree = new BSTreee();
        tree.root = tree.insert(tree.root, 10);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 1);
        printRootValue(tree.root);
        tree.search(tree.root, 6);
        tree.search(tree.root, 11);
        tree.delete(tree.root, 6);
        printRootValue(tree.root);
        tree.delete(tree.root, 5);
        printRootValue(tree.root);
    }
    public static void printRootValue(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        printRootValue(root.left);
        printRootValue(root.right);
    }
}
