package personalFinance.gui.table.render;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHeaderIconRender extends DefaultTableCellRenderer {

    private final JLabel label;

    public TableHeaderIconRender(ImageIcon icon) {
        super();
        label = new JLabel(icon);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer();
        Component render = tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setFont(render.getFont());
        label.setForeground(render.getForeground());
        label.setBorder(((JComponent) render).getBorder());
        label.setText("" + value);
        return label;
    }
}
