package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.repositories.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/search")
public class SearchController {
    private ArticleRepository articleRepository;
   /* private GenericRepository<Entity, Long> genericRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity getArticle(@PathVariable Long id) {
        Article article = articleRepository.getOne(id);
        switch (article.getType()) {
            case "game":
                GenericRepository<Game, Long> genericRepository = (GenericRepository<Game, Long>) this.genericRepository;
                return ResponseEntity.ok().body(gameRepository.findById(id));
        }
        return ResponseEntity.noContent().build();
    }*/
}
