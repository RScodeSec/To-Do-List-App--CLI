package com.rs.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Publication {
    private int id;

    private String[] authors;

    public Magazine(Builder builder){
        super(builder);
        authors = builder.authors;

    }
    /**
     * clean code
     */
    public static class Builder extends Publication.Builder<Builder> {
        //optional parameters
        private String[] authors;

        public Builder (String title, int editionDate, String editorial){
            super(title, editionDate, editorial);
        }
        public Builder authors (String[] authors){
            this.authors = authors;
            return this;
        }
        public Magazine build (){
            return new Magazine(this);

        }
    }
    public static ArrayList<Magazine> makeMagazineList(){
        ArrayList<Magazine> magazines = new ArrayList<>();
        for (int i = 1; i<=5; i++) {
            magazines.add(new Magazine.Builder("Mazine "+i,(1995+i),"Sal "+i).build());
        }

        return magazines;
    }

}
