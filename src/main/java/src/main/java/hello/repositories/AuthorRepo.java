package src.main.java.hello.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import src.main.java.hello.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {

}
