package src.main.java.hello;

import jakarta.persistence.*;

@Entity(name = "Article")
public class Article {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    public Article(){

    }

    public Article(String title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
        author.getArticles().add(this);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author.getFirstName() +
                '}';
    }
}
