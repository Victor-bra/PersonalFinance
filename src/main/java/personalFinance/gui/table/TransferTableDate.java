package personalFinance.gui.table;

import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.model.TransactionTableModel;
import personalFinance.gui.table.model.TransferTableModel;
import personalFinance.gui.table.render.MainTableCellRender;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransferTableDate extends TableDate {

    private final static String[] columns = new String[]{"DATE", "FROM_ACCOUNT", "TO_ACCOUNT", "FROM_AMOUNT", "TO_AMOUNT", "NOTICE"};
    private final static ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ACCOUNT,
            Style.ICON_AMOUNT, Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransferTableDate(FunctionsHandler handler) {
        super(new TransferTableModel(columns), handler, columns, icons);
        init();
    }

    @Override
    protected final void init() {
        getColumn(Text.get("FROM_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_EXP));
        getColumn(Text.get("TO_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_INCOME));
    }

    private class TableCellAmountRenderer extends MainTableCellRender {

        private final Color color;

        public TableCellAmountRenderer(Color color) {
            this.color = color;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            renderer.setForeground(color);
            return renderer;
        }
    }
}
