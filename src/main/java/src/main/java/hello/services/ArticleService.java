package src.main.java.hello.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.java.hello.Article;
import src.main.java.hello.Author;
import src.main.java.hello.repositories.ArticleRepo;
import src.main.java.hello.repositories.AuthorRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo repository;

    public List<Article> findAll() {
        return (List<Article>) repository.findAll();
    }

    public void save(Article article) {
        repository.save(article);
    }

    public Optional<Article> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Article article) {
        repository.delete(article);
    }
}

