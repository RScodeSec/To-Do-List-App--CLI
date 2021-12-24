package com.rs.amazonviewer.model;

import java.util.Date;

public class Publication {
    private String title;
    private int editionDate;
    private String editorial;
    private String[] authors;

    public Publication(Builder builder){
        title = builder.title;
        editionDate = builder.editionDate;
        editorial = builder.editorial;
        authors = builder.authors;
    }
    /**
     * clean code
     */
    public static class Builder <T extends Builder<T>>{
        //required parameters
        private String title;
        private int editionDate;
        private String editorial;

        //optional parameters
        private String[] authors;

        public Builder(String title, int editionDate, String editorial){
            this.title = title;
            this.editionDate = editionDate;
            this.editorial = editorial;
        }
        public T authors (String[] authors){
            this.authors = authors;
            return (T) this;
        }
        public Publication build(){
            return new Publication(this);
        }

    }

    public String getTitle(){
        return title;
    }
    public String getEditorial(){
        return editorial;
    }
    public int getEditionDate(){
        return editionDate;
    }
}
