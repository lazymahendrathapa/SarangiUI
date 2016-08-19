package com.sarangiUI.model;
import org.springframework.web.multipart.MultipartFile;

public class Song{

   private String songName;
   private MultipartFile songFile;
   private String songStatus;
   private String songResult;
   private String songGenre;
   private String songArousal;
   private String songValence;
   private String songError;

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

   public void setSongGenre(String songGenre){
       this.songGenre = songGenre;
   }

   public void setSongArousal(String songArousal){
       this.songArousal = songArousal;
   }

   public void setSongValence(String songValence){
       this.songValence = songValence;
   }

   public void setSongError(String songError){
       this.songError = songError;
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

   public String getSongGenre(){
       return songGenre;
   }

   public String getSongArousal(){
       return songArousal;
   }

   public String getSongValence(){
       return songValence;
   }

   public String getSongError(){
       return songError;
   }
}
