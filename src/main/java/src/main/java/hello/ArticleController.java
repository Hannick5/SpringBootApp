package src.main.java.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import src.main.java.hello.services.ArticleService;
import src.main.java.hello.services.AuthorService;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/myarticle")
    public String getMyArticle(Model model) {

        Author aut = new Author("nom", "prenom");
        Article art = new Article("art", "contenu", aut);

        model.addAttribute("art",art);
        return "article";
    }

    @GetMapping("/allarticles")
    public String getAllArticles(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "all_articles";
    }

    @GetMapping("/addauthor")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add_author";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/allauthors";
    }

    @GetMapping("/addarticle")
    public String showAddArticleForm(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("article", new Article());
        return "add_article";
    }

    @PostMapping("/addarticle")
    public String addArticle(@ModelAttribute Article article) {
        articleService.save(article);
        return "redirect:/allarticles";
    }


}
