package com.rs.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends Film implements IVisualizable{
    private int id;
    private int timeViewed;

   public Movie (Builder builder){
       super(builder);
       this.timeViewed = builder.timeViewed;
   }

    /**
     * Clean code
     * Builder Pattern
     */
   public static class Builder  extends Film.Builder<Builder>{
       //optional parameters
       private int timeViewed;
       public Builder(String title, String genre, short year){
           super(title,genre,year);
       }

        public Builder timeViewed (int timeViewed){
            this.timeViewed = timeViewed;
            return this;
        }
       public Movie build (){
           return new Movie(this);

       }
   }


    @Override
    public String toString(){
       return  "\n::MOVIE::"+
               "\nTitle: " + getTitle() +
               "\nGenre: " + getGenre() +
               "\nYear: " + getYear();
    }
    @Override
    public Date startToSee(Date dateI){
       return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF){
       if(dateF.getTime()>dateI.getTime()){
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
       }
       else{
           setTimeViewed(0);
       }
    }
    public static ArrayList<Movie> makeMoviesList(){
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 1; i<=5; i++) {
            movies.add(new Movie.Builder("Movie "+i,"Genero "+i,(short) (2017 +i)).build());
        }


        return movies;
    }



}
