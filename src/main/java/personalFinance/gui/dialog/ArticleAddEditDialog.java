package personalFinance.gui.dialog;

import personalFinance.exception.ModelException;
import personalFinance.gui.MainFrame;
import personalFinance.model.Article;
import personalFinance.model.Common;
import personalFinance.settings.Style;

import javax.swing.*;

public class ArticleAddEditDialog extends AddEditDialog {

    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_TITLE", new JTextField());

        icons.put("LABEL_TITLE", Style.ICON_TITLE);
        icons.put("LABEL_START_AMOUNT", Style.ICON_AMOUNT);
    }

    @Override
    protected void setValues() {
        Article article = (Article) c;
        values.put("LABEL_TITLE", article.getTitle());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        String title = ((JTextField) components.get("LABEL_TITLE")).getText();
        return new Article(title);
    }
}
