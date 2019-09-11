package up5;


import javax.swing.tree.DefaultTreeModel;

public class CatalogTreeModel extends DefaultTreeModel{
    private static final long serialVersionUID = 1L;

    private CameraTreeNode root;

    CatalogTreeModel(CameraTreeNode root) {
        super(root);
        this.root = root;
    }

    @Override
    public CameraTreeNode getRoot() {
        return root;
    }

    void insertNodeInto(CameraTreeNode child, CameraTreeNode parent, int i,boolean f) {
        insertNodeInto(child, parent, i);
        parent.addNode(child);
    }


}
