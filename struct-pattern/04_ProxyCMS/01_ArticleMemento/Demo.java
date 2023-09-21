import java.util.ArrayList;
import java.util.List;

class ArticleFormatter {
    private String content;
    private int fontSize;
    private String fontType;

    public ArticleFormatter(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void addContent(String moreContent) {
        this.content += moreContent;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public ArticleMemento saveArticleState() {
        return new ArticleMemento(content, fontSize, fontType);
    }

    public void restoreArticleState(ArticleMemento memento) {
        content = memento.getContent();
        fontSize = memento.getFontSize();
        fontType = memento.getFontType();
    }

    public void displayArticle() {
        System.out.println("Article \ncontent=" + content + "\nfontSize=" + fontSize + "\nfontType=" + fontType + "\n");
    }
}

class ArticleMemento {
    private String content;
    private int fontSize;
    private String fontType;

    public ArticleMemento(String content, int fontSize, String fontType) {
        this.content = content;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    public String getContent() {
        return content;
    }

    public int getFontSize() {
        return fontSize;
    }

    public String getFontType() {
        return fontType;
    }
}

class ArticleCaretaker {
    List<ArticleMemento> articleMementos = new ArrayList<ArticleMemento>();

    public void addArticleMemento(ArticleMemento memento) {
        articleMementos.add(memento);
    }

    public ArticleMemento getArticleMemento(int index) {
        return articleMementos.get(index);
    }
}

public class Demo {
    public static void main(String[] args) {
        ArticleFormatter article = new ArticleFormatter("This is a demo article to test memento design pattern.", 12,
                "Arial");
        System.out.println("ORIGINAL:");
        article.displayArticle();
        ArticleCaretaker caretaker = new ArticleCaretaker();
        caretaker.addArticleMemento(article.saveArticleState());

        // Updates
        article.addContent(" This more content for testing.");
        article.setFontSize(14);
        System.out.println("UPDATE:");
        article.displayArticle();
        caretaker.addArticleMemento(article.saveArticleState());

        article.setFontType("Times New Roman");
        System.out.println("UPDATE:");
        article.displayArticle();
        caretaker.addArticleMemento(article.saveArticleState());

        // Restore
        article.restoreArticleState(caretaker.getArticleMemento(0));
        System.out.println("Restoring...");
        article.displayArticle();
    }
}
