package pl.camp.it.tree;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    private Node coreNode;
    private final Map<Integer,Node> nodes = new HashMap<>();

    public void add(int value){
        if(nodes.size()==0){
            this.coreNode= new Node(value);
            nodes.put(value,this.coreNode);
        }
        else {
            addNotCore(value);
        }

    }

    private void addNotCore(int value){
        Node actualNode = coreNode;
        int way=0;
        boolean flag=true;

        while (flag) {
            if (value < actualNode.getValue()) {
                way = 1;
            } else if (value > actualNode.getValue()) {
                way = 2;
            }
            else way = 0;

            switch (way) {
                case 1:
                    if (actualNode.getLeft() != null) {
                        actualNode = actualNode.getLeft();
                    }
                    else {
                        Node nowynode = new Node(value, actualNode);
                        nodes.put(value,nowynode);
                        actualNode.setLeft(nowynode);
                        flag = false;
                    }
                    break;
                case 2:
                    if (actualNode.getRight() != null) {
                        actualNode = actualNode.getRight();
                    }
                    else {
                        Node nowynode = new Node(value, actualNode);
                        actualNode.setRight(nowynode);
                        this.nodes.put(value,nowynode);
                        flag=false;
                    }
                    break;
                default:
                    flag=false;
                    break;
            }
        }
    }

    public boolean contains(int value){
        return nodes.containsKey(value);
    }

    public int max(){
        if(nodes.size()!=0) {
            Node actualNode = coreNode;
            if (actualNode.getRight() != null) {
                while (actualNode.getRight() != null){
                    actualNode=actualNode.getRight();
                }
                return actualNode.getValue();
            } else return coreNode.getValue();
        }
        else return 0;
    }

    public int min(){
        if(nodes.size()!=0) {
            Node actualNode = coreNode;
            if (actualNode.getLeft() != null) {
                while (actualNode.getLeft() != null){
                    actualNode=actualNode.getLeft();
                }
                return actualNode.getValue();
            } else return coreNode.getValue();
        }
        else return 0;
    }

    public Node getCoreNode() {
        return coreNode;
    }

    public Map<Integer, Node> getNodes() {
        return nodes;
    }
}
