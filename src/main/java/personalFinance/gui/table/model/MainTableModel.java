package personalFinance.gui.table.model;

import personalFinance.gui.Refresh;
import personalFinance.model.Common;
import personalFinance.settings.Text;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MainTableModel extends AbstractTableModel implements Refresh {

    protected List<? extends Common> date;
    protected List<String> columns;

    public MainTableModel(List<? extends Common> date, String[] columns) {
        this.date = date;
        this.columns = new ArrayList<>(Arrays.asList(columns));
    }

    @Override
    public int getRowCount() {
        return date.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int column) {
        return Text.get(columns.get(column));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object obj = getValueAt(0, columnIndex);
        if (obj == null)
            return Object.class;
        return obj.getClass();
    }

    @Override
    public void refresh() {
        updateDate();
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    public Common getCommonByRow(int row) {
        return date.get(row);
    }

    protected abstract void updateDate();
}