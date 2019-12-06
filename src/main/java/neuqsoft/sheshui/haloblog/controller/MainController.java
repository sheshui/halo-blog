package neuqsoft.sheshui.haloblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sheshui
 */
@Controller
public class MainController {

    @GetMapping
    public String mainPage(){
        return "redirect:/admin/index.html";
    }
}
