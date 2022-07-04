package personalFinance.gui.table;

import personalFinance.gui.Refresh;
import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.menu.TablePopupMenu;
import personalFinance.gui.table.model.MainTableModel;
import personalFinance.gui.table.render.MainTableCellRender;
import personalFinance.gui.table.render.TableHeaderIconRender;
import personalFinance.settings.Style;
import personalFinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TableDate extends JTable implements Refresh {

    private final FunctionsHandler handler;
    private final TablePopupMenu popup;
    private final ImageIcon[] icons;
    private final String[] columns;

    public TableDate(MainTableModel model, FunctionsHandler handler, String[] columns, ImageIcon[] icons) {
        super(model);
        this.handler = handler;
        this.popup = new TablePopupMenu(handler);
        this.columns = columns;
        this.icons = icons;

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);
        setFont(Style.FONT_TABLE);
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);

        setAutoCreateRowSorter(true);
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(handler);
        addKeyListener(handler );

        for (int i = 0; i < columns.length; i++)
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRender(icons[i]));

        MainTableCellRender renderer = new MainTableCellRender();
        setDefaultRenderer(String.class, renderer);

        setComponentPopupMenu(popup);
    }

    @Override
    public JPopupMenu getComponentPopupMenu() {
        Point p = getMousePosition();
        if(p!= null){
            int row = rowAtPoint(p);
            if (isRowSelected(row))
                return super.getComponentPopupMenu();
            else
                return null;
        }
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();
        ((MainTableModel) getModel()).refresh();
        for (int i = 0; i < columns.length; i++)
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRender(icons[i]));
        if (selectedRow != -1 && selectedRow < getRowCount()) {
            setRowSelectionInterval(selectedRow, selectedRow);
            requestFocus();
        }
        init();
    }

    protected void init() {
    }

    public FunctionsHandler getFunctionHandler() {
        return handler;
    }
}