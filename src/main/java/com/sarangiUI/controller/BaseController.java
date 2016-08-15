package com.sarangiUI.controller;

import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

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
    public ModelAndView setSong(MultipartHttpServletRequest request) {

        MultipartFile file = request.getFile("file");
        Song song = new Song();
        song.setSongName(file.getOriginalFilename());
        song.setSongFile(file);

        logger.loggingSystem(Level.INFO,song.getSongName()+" is successfully uploaded");

        String rootPath = "src/main/resources";

        File dir = new File(rootPath + File.separator + "tmpFiles");

        if(!dir.exists())
            dir.mkdirs();

        File serverFile = new File(dir.getAbsolutePath() + File.separator + song.getSongName());

        try {

            byte[] bytes = file.getBytes();

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

            stream.write(bytes);
            stream.close();

            logger.loggingSystem(Level.INFO,"Sever File location = " + serverFile.getAbsolutePath());
            song.setSongStatus("SUCCESS");

        } catch (Exception e) {

            logger.loggingSystem(Level.SEVERE,"Error in copying the file");
            song.setSongStatus("FAILURE");
        }


        ModelAndView mv = new ModelAndView();
        mv.addObject("song",song);
        mv.setViewName("index");

        return mv;

    }
}
