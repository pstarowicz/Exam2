package pl.camp.it.tree;

public class App {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(4);
       System.out.println(tree.getCoreNode());
       System.out.println(tree.getNodes().get(5).getRight());
        System.out.println(tree.getNodes().get(5).getLeft());
        System.out.println(tree.contains(7));
        System.out.println(tree.min());
        System.out.println(tree.max());

    }
}
