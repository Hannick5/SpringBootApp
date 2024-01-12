package src.main.java.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import src.main.java.hello.Article;
import src.main.java.hello.Author;
import src.main.java.hello.repositories.ArticleRepo;
import src.main.java.hello.repositories.AuthorRepo;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepo authorRepository;
    private final ArticleRepo articleRepository;

    @Autowired
    public DataInitializer(AuthorRepo authorRepository, ArticleRepo articleRepository) {
        this.authorRepository = authorRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insérer des auteurs
        Author author1 = new Author("John", "Doe");
        Author author2 = new Author("Jane", "Smith");
        authorRepository.save(author1);
        authorRepository.save(author2);

        // Insérer des articles
        Article article1 = new Article("Article 1", "Content 1", author1);
        Article article2 = new Article("Article 2", "Content 2", author2);
        articleRepository.save(article1);
        articleRepository.save(article2);
    }
}