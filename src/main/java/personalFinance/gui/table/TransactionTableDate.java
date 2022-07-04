package personalFinance.gui.table;

import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.model.TransactionTableModel;
import personalFinance.gui.table.render.MainTableCellRender;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransactionTableDate extends TableDate {

    private final static String[] columns = new String[]{"DATE", "ACCOUNT", "ARTICLE", "AMOUNT", "NOTICE"};
    private final static ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ARTICLE, Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransactionTableDate(FunctionsHandler handler) {
        super(new TransactionTableModel(columns), handler, columns, icons);
        init();
    }

    public TransactionTableDate(FunctionsHandler handler, int count) {
        super(new TransactionTableModel(columns, count), handler, columns, icons);
        init();
    }

    @Override
    protected final void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRenderer());
    }

    private class TableCellAmountRenderer extends MainTableCellRender {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if ((value.toString()).contains("-"))
                renderer.setForeground(Style.COLOR_EXP);
            else
                renderer.setForeground(Style.COLOR_INCOME);
            return renderer;
        }
    }
}
