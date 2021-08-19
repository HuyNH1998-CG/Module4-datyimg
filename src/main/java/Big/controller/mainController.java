package Big.controller;

import Big.model.comments;
import Big.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@Controller
public class mainController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(size = 5) Pageable pageable) {
        Page<comments> list = commentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("comment",new comments());
        modelAndView.addObject("date",new Date());
        modelAndView.addObject("comments",list);
        return modelAndView;
    }
    @GetMapping("/like/{id}")
    public ModelAndView like(@PathVariable Long id){
        commentService.like(id);
        return new ModelAndView("redirect:/home");
    }
    @PostMapping("/comment")
    public ModelAndView comment(@ModelAttribute comments comments){
        commentService.save(comments);
        return new ModelAndView("redirect:/home");
    }
}
