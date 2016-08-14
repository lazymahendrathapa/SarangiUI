/**                                                                                
 * @(#) LoggerHandler.java 2.0   August 04, 2016
 *
 * Mahendra Thapa
 *
 * Insitute of Engineering
 */

package com.sarangiUI.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerHandler{

    private static LoggerHandler instance;

    private Logger logger;
    private FileHandler fileHandler;
    private SimpleFormatter formatter;

    private final int FILE_SIZE = 1024 * 1024;

    private LoggerHandler(){

        logger = Logger.getLogger("SarangiUILog");
        logger.setLevel(Level.ALL);
        formatter = new SimpleFormatter();
    }

    public static synchronized LoggerHandler getInstance(){

        if(instance == null){
            instance = new LoggerHandler();
        }

        return instance;
    }

    public void loggingSystem(Level level, String logMessage){

        try{

         fileHandler = new FileHandler("src/main/resources/SarangiUI.log",FILE_SIZE,10,true);

        }catch(IOException ex){
            logger.warning("Failed to initilize logger handler");
        }

        logger.addHandler(fileHandler);
        fileHandler.setFormatter(formatter);

        logger.log(level,logMessage);
        fileHandler.close();
    }

    public void setLogLevel(Level level){
        logger.setLevel(level);
    }
}
