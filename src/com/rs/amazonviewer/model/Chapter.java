package com.rs.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Chapter extends Movie {
    private int id;
    private int sessionNamber;

    public Chapter(Builder builder){
        super(builder);
        this.sessionNamber = builder.sessionNamber;
    }

    /**
     * clean code
     */
    public static class Builder extends Movie.Builder{
        //optional parameters
        private int sessionNamber;

        public Builder(String title, String genre, short year){
            super(title,genre,year);
        }

        public Builder sessionNamber (int sessionNamber){
            this.sessionNamber = sessionNamber;
            return this;
        }

        public Chapter build (){
            return new Chapter(this);
        }
    }
    public int getSessionNamber(){
        return sessionNamber;
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
    @Override
    public String toString(){
        return  "\n::CHAPTER::"+
                "\nTitle: " + getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\nDuration: " + getSessionNamber();
    }
    public static ArrayList<Chapter> makeChaptersList(){
        ArrayList<Chapter> chapters = new ArrayList<>();
        for (int i = 1; i<=5; i++) {
            chapters.add(new Chapter.Builder("Chapter "+i,"Gender "+i,(short) (2017+i)).sessionNamber(45).build());
        }
        return chapters;
    }
}
