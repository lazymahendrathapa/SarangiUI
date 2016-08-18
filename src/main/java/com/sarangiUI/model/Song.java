package com.sarangiUI.model;
import org.springframework.web.multipart.MultipartFile;

public class Song{

   private String songName;
   private MultipartFile songFile;
   private String songStatus;
   private String songResult;


   public void setSongName(String songName){
       this.songName = songName;
   }

   public void setSongFile(MultipartFile songFile){
       this.songFile = songFile;
   }

   public void setSongStatus(String songStatus){
       this.songStatus = songStatus;
   }

   public void setSongResutl(String songResult){
       this.songResult = songResult;
   }


   public String getSongName(){
       return songName;
   }

   public MultipartFile getSongFile(){
       return songFile;
   }

   public String getSongStatus(){
       return songStatus;
   }

   public String getSongResult(){
       return songResult;
   }
}
