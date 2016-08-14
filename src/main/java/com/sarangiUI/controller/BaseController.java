package com.sarangiUI.controller;

import com.sarangiUI.model.Song;
import com.sarangiUI.logger.LoggerHandler;
import java.util.logging.Level;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {

        LoggerHandler logger = LoggerHandler.getInstance();

       @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        logger.loggingSystem(Level.INFO,"Home page is loaded");

        return mv;

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView setSong(WebRequest req) {

        Song song = new Song();
        song.setSongName(req.getParameter("songFile"));

        logger.loggingSystem(Level.INFO,song.getSongName()+" is successfully uploaded");

        ModelAndView mv = new ModelAndView();
        mv.addObject("song",song);
        mv.setViewName("index");

        return mv;

    }
}
