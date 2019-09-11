package up5;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CameraTreeNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 1L;

    private String nodeName;
    private CameraNode nodeValue = null;
    private List<CameraTreeNode> nodes = new ArrayList<>();
    private boolean isLeafNode = false;


    CameraTreeNode(String name) {
        nodeName = name;
    }

    CameraTreeNode(String name, CameraNode value) {
        nodeName = name;
        nodeValue = value;
        isLeafNode = true;
    }

    void addNode(CameraTreeNode node) {
        nodes.add(node);
    }

//    boolean deleteNode(CameraTreeNode node) {
//        boolean isExist = false;
//        for (int i = 0; i < nodes.size(); ++i)
//            if (nodes.get(i).toString().compareToIgnoreCase(node.toString()) == 0) {
//                nodes.remove(i);
//                isExist = true;
//            }
//        return isExist;
//    }

    List<CameraNode> getAllLeaves() {
        List<CameraNode> leaves = new ArrayList<>();
        Deque<CameraTreeNode> deque = new ArrayDeque<>();

        deque.push(this);
        CameraTreeNode temp;
        while (!deque.isEmpty()) {
            temp = deque.removeFirst();
            if (temp.isLeafNode) {
                leaves.add(temp.getNodeValue());
            } else {
                for (int i = 0; i < temp.nodes.size(); ++i) {
                    deque.push(temp.nodes.get(i));
                }
            }
        }

        return leaves;
    }

    private CameraNode getNodeValue() {
        return nodeValue;
    }

    List<CameraTreeNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return nodeName;
    }

}
