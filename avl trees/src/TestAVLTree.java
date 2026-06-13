public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<String> searchTree = new AVLTree<>();

        String[] dataset = {
                "apple", "apricot", "banana", "blueberry", "blackberry",
                "cherry", "cranberry", "cantaloupe", "date", "dragonfruit",
                "elderberry", "fig", "grapefruit", "grape", "guava",
                "honeydew", "kiwi", "lemon", "lime", "mango",
                "nectarine", "orange", "papaya", "peach", "pear",
                "pineapple", "plum", "pomegranate", "raspberry", "strawberry",
                "tangerine", "watermelon"
        };

        for (String word : dataset) {
            searchTree.insert(word);
        }

        System.out.println("\nAVL Tree Structure:");
        searchTree.printAsciiTree();

        searchTree.traceSearch("raspberry");
        searchTree.printNodeBalances();
        System.out.println("Is AVL tree? " + AVLTree.isAVL(searchTree.getnodes()));
    }
}
