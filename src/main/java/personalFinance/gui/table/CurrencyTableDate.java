package personalFinance.gui.table;

import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.model.CurrencyTableModel;
import personalFinance.gui.table.render.MainTableCellRender;
import personalFinance.model.Currency;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class CurrencyTableDate extends TableDate {

    private final static String[] columns = new String[]{"TITLE", "CODE", "RATE", "ON", "BASE"};
    private final static ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_CODE, Style.ICON_RATE, Style.ICON_ON, Style.ICON_BASE};

    public CurrencyTableDate(FunctionsHandler handler) {
        super(new CurrencyTableModel(columns),handler, columns, icons);
        init();
    }

    @Override
    protected final void init() {
        for (String column : columns) {
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOfRenderer());
        }
    }

    private class TableCellOnOfRenderer extends MainTableCellRender {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (((Currency) ((CurrencyTableModel) table.getModel()).getCommonByRow(row)).isOn())
                renderer.setForeground(Style.COLOR_ON);
            else
                renderer.setForeground(Style.COLOR_OFF);
            return renderer;
        }
    }
}
