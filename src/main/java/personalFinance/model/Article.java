package personalFinance.model;

import personalFinance.exception.ModelException;
import personalFinance.saveLoad.SaveData;

public class Article extends Common {
    private String title;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Article(String title) throws ModelException {
        if (title.length() == 0)
            throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
    }

    @Override
    public String getValueFormCombobox() {
        return title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public void postEdit(SaveData sd) {
        for (Transaction t : sd.getTransactions())
            if (t.getArticle().equals(sd.getOldCommon())) t.setArticle(this);
    }
}
