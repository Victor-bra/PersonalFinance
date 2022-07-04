package personalFinance.gui.table;

import personalFinance.gui.handler.FunctionsHandler;
import personalFinance.gui.table.model.ArticleTableModel;
import personalFinance.settings.Style;

import javax.swing.*;

public class ArticleTableDate extends TableDate {

    private final static String[] columns = new String[]{"TITLE"};
    private final static ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};

    public ArticleTableDate(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
}
