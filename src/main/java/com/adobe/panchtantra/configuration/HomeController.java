package com.adobe.panchtantra.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to panchtantra api documentation 
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index() {
        System.out.println("panchtantra-ui.html");
        return "redirect:panchtantra-ui.html";
    }
}
