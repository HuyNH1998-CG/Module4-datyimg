package Bid.Controller;

import Bid.Model.Comment;
import Bid.Service.CommentI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class mainController {
    @Autowired
    CommentI commentI;


    @GetMapping("/home")
    public ModelAndView home(@ModelAttribute("comments") Comment comment) {
        ModelAndView modelAndView = new ModelAndView("/test");
        return modelAndView;
    }

    @PostMapping("/comment")
    public ModelAndView comment(@ModelAttribute("comments") Comment comment) {
        commentI.save(comment);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
}
