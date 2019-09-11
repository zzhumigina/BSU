package up5;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.List;

public class CatalogFrame extends JFrame {


    static CameraNode addResult = null;

    private JTable infoPanel = new JTable();
    private JTree tree = new JTree();
    private CatalogTableModel tableModel = null;
    private CatalogTreeModel treeModel = null;

    public CatalogFrame() {
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> openAddDialog());

//        JButton removeButton = new JButton("Remove");
//        removeButton.addActionListener(e -> removeItem());

        tableModel = new CatalogTableModel();
        infoPanel = new JTable(tableModel);
        treeModel = new CatalogTreeModel(new CameraTreeNode("Shop"));
        tree = new JTree(treeModel);
        tree.addTreeSelectionListener(e -> {
            CameraTreeNode node = (CameraTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }

            List<CameraNode> phoneNodes = node.getAllLeaves();
            tableModel = new CatalogTableModel(phoneNodes);
            infoPanel.setModel(tableModel);
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                true,
                new JScrollPane(tree),
                new JScrollPane(infoPanel));
        splitPane.setDividerLocation(200);



        Container c = getContentPane();
        c.setLayout(new GridLayout(1,1));
        JPanel jPanel = new JPanel();
        jPanel.add(splitPane);
        jPanel.add(addButton);
        c.add(jPanel);


        setBounds(100, 100, 550, 500);
        setTitle("Company's catalog");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void openAddDialog() {
        AddDialog addForm = new AddDialog(this);
        addForm.setVisible(true);
    }

    void addNewItem() {
        CameraTreeNode temp, where, insert, root = treeModel.getRoot();

        if (addResult != null) {
            try {
                insert = new CameraTreeNode(addResult.getName(), addResult);
                if ((where = findNode(root, addResult.getName())) != null) {
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                } else if (findNode(root, addResult.getCountry()) != null) {
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getName()),
                            temp = findNode(root, addResult.getCountry()),
                            temp.getChildCount(), false);
                    where = findNode(root, addResult.getName());
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                } else if (findNode(root, addResult.getComp()) != null) {
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getCountry()),
                            temp = findNode(root, addResult.getComp()),
                            temp.getChildCount(), false);
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getName()),
                            temp = findNode(root, addResult.getCountry()),
                            temp.getChildCount());
                    where = findNode(root, addResult.getName());
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                } else {
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getComp()),
                            root,
                            root.getChildCount());
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getCountry()),
                            temp = findNode(root, addResult.getComp()),
                            temp.getChildCount(), false);
                    treeModel.insertNodeInto(new CameraTreeNode(addResult.getName()),
                            temp = findNode(root, addResult.getCountry()),
                            temp.getChildCount());
                    where = findNode(root, addResult.getName());
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                }
            } catch (Exception e) {
                addResult = null;
                return;
            }
        }
        addResult = null;
    }

//    private void removeItem() {
//        TreePath currentSelection = tree.getSelectionPath();
//        if (currentSelection != null) {
//            CameraTreeNode currentNode = (CameraTreeNode) (currentSelection.getLastPathComponent());
//            CameraTreeNode parent = (CameraTreeNode) (currentNode.getParent());
//            if (parent != null) {
//                treeModel.removeNodeFromParent(currentNode);
//                parent.deleteNode(currentNode);
//                List<CameraNode> phoneNodes = parent.getAllLeaves();
//                tableModel = new CatalogTableModel(phoneNodes);
//                infoPanel.setModel(tableModel);
//            }
//        }
//    }

    private CameraTreeNode findNode(CameraTreeNode root, String s) {
        Enumeration e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            CameraTreeNode node = (CameraTreeNode) e.nextElement();
            if (node.toString().equalsIgnoreCase(s)) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
       // CatalogFrame mainClass = new CatalogFrame();
       // mainClass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       // mainClass.setVisible(true);
    }

}
