package com.rs.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Serie extends Film{
    private int id;
    private int sessionQuantity;
    private ArrayList<Chapter> chapters;

    public  Serie (Builder builder){
        super(builder);
        sessionQuantity = builder.sessionQuantity;
        chapters = builder.chapters;
    }
    /**
     * clean code
     */
    public static class Builder extends Film.Builder<Builder>{
        //optional parameters
        private int sessionQuantity;
        private ArrayList<Chapter> chapters;

        public Builder (String title, String genre, short year){
            super(title,genre,year);
        }
        public Builder sessionQuantity(int sessionQuantity){
            this.sessionQuantity = sessionQuantity;
            return this;
        }
        public Builder chapters(ArrayList<Chapter> chapters){
            this.chapters = chapters;
            return this;
        }
        public Serie build (){
            return new Serie(this);
        }
    }
    public ArrayList<Chapter> chapters(){
        return chapters;
    }
    @Override
    public String toString(){
        return  "\n::SERIE::"+
                "\nTitle: " + getTitle() +
                "\nGenre: " + getGenre() +
                "\nYear: " + getYear() +
                "\n Duration" + getDuration();
    }
    public static ArrayList<Serie> makeSeriesList(){
        ArrayList<Serie> series = new ArrayList<>();
        for (int i = 1; i<=5; i++) {
            series.add(new Serie.Builder("Serie "+i,"Gender "+i,(short) (2017+i)).duration(1200).sessionQuantity(5).chapters(Chapter.makeChaptersList()).build());
        }

        return series;
    }


}
