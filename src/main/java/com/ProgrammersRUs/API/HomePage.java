package com.ProgrammersRUs.API;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Braedy Thebus on 31/10/2015.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Index()
    {
        return "Welcome to the home page of the Jewellery Store";
    }

}
