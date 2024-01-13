import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TreeNode {
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(final char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static TreeNode[] tree;

    static void preOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        result.append(node.value);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    static void inOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, result);
        result.append(node.value);
        inOrderTraversal(node.right, result);
    }

    static void postOrderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.append(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new TreeNode[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new TreeNode(parentValue);
            }

            if (leftValue != '.') {
                tree[leftValue - 'A'] = new TreeNode(leftValue);
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];
            }

            if (rightValue != '.') {
                tree[rightValue - 'A'] = new TreeNode(rightValue);
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }
        br.close();

        StringBuilder preOrderResult = new StringBuilder();
        StringBuilder inOrderResult = new StringBuilder();
        StringBuilder postOrderResult = new StringBuilder();

        preOrderTraversal(tree[0], preOrderResult);
        inOrderTraversal(tree[0], inOrderResult);
        postOrderTraversal(tree[0], postOrderResult);

        System.out.println(preOrderResult);
        System.out.println(inOrderResult);
        System.out.println(postOrderResult);
    }
}
