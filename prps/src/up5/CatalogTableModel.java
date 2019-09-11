package up5;


import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CatalogTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<>();
    private List<CameraNode> infoNodes = new ArrayList<>();

    private static final String[] columnNames = new String[]{"Discount", "Seller", "Name", "Price"};
    private static final Class<?>[] columnTypes = new Class[]{String.class, String.class, String.class, Integer.class};

    CatalogTableModel() {
    }

    CatalogTableModel(List<CameraNode> al) {
        setInfoNodes(al);
    }

    private void setInfoNodes(List<CameraNode> phoneNodes) {
        infoNodes = phoneNodes;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return infoNodes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CameraNode phoneNode = infoNodes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return phoneNode.getComp();
            case 1:
                return phoneNode.getCountry();
            case 2:
                return phoneNode.getName();
            case 3:
                return phoneNode.getPrice();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

}
