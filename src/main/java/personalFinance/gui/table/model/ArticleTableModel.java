package personalFinance.gui.table.model;

import personalFinance.model.Article;
import personalFinance.saveLoad.SaveData;

public class ArticleTableModel extends MainTableModel {

    private static final int TITLE = 0;

    public ArticleTableModel(String[] columns) {
        super(SaveData.getInstance().getArticles(), columns);
    }

    @Override
    protected void updateDate() {
        date = SaveData.getInstance().getArticles();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (date.isEmpty()) return null;
        Article article = (Article) date.get(row);
        switch (column) {
            case TITLE:
                return article.getTitle();
        }
        return null;
    }
}
