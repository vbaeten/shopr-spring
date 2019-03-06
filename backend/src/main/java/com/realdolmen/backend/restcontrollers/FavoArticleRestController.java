package com.realdolmen.backend.restcontrollers;

import com.realdolmen.backend.domain.FavoArticle;
import com.realdolmen.backend.service.FavoArticleService;
import com.realdolmen.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/favoArticle")
public class FavoArticleRestController {
    private final FavoArticleService favoArticleService;
    private final UserService userService;

    public FavoArticleRestController(FavoArticleService favoArticleService, UserService userService) {
        this.favoArticleService = favoArticleService;
        this.userService = userService;
    }

    @GetMapping("/findFavoListByUserId/{userId}")
    public List<FavoArticle> findCurrentFavoListByUserId(@PathVariable Long userId) {
        return favoArticleService.findFavosByUser(userService.findById(userId));
    }

    @PostMapping(path = "/save")
    public void saveFavo(@RequestBody @Valid FavoArticle favoArticle) {
        favoArticleService.save(favoArticle);
    }

    @DeleteMapping("/{favoArticleId}")
    public void deleteById(@PathVariable("favoArticleId") Long favoArticleId) {
        favoArticleService.deleteById(favoArticleId);
    }


}
