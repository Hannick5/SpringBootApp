package src.main.java.hello.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import src.main.java.hello.Article;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Long> {

}
