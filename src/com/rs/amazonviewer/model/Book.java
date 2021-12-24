package com.rs.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends Publication implements IVisualizable{
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;

    public Book(Builder builder){
        super(builder);
        isbn = builder.isbn;
        readed = builder.readed;
        timeReaded = builder.timeReaded;
    }
    /**
     * clean code
     */
    public static class Builder extends Publication.Builder<Builder> {
        //required parameters
        private String isbn;

        //optional parameters
        private String[] authors;
        private boolean readed;
        private int timeReaded;

        public Builder (String title, int editionDate, String editorial, String isbn){
            super(title, editionDate, editorial);
            this.isbn = isbn;
        }
        public Builder authors(String[] authors){
            this.authors = authors;
            return this;
        }
        public Builder readed(boolean readed){
            this.readed = readed;
            return this;
        }
        public Builder timeReaded(int timeReaded){
            this.timeReaded = timeReaded;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
    public String getIsbn(){
        return isbn;
    }
    public void setTimeReaded(int timeReaded){
        this.timeReaded = timeReaded;
    }
    public int getTimeReaded(){
        return timeReaded;
    }
    public void setReaded(boolean readed){
        this.readed = readed;
    }
    public String isReaded(){
        String visto = "";
        if(readed){
            visto = "Yes";
        }
        else{
            visto = "Not";
        }
        return visto;
    }

    @Override
    public String toString(){
        return  "\n::Book::"+
                "\nTitle: " + getTitle() +
                "\nEditorial: " + getEditorial() +
                "\nEdition Date: "+ getEditionDate()+
                "\nisbn: " + getIsbn();
    }

    @Override
    public Date startToSee(Date dateI){
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF){
        if(dateF.getTime()>dateI.getTime()){
            setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }
        else{
            setTimeReaded(0);
        }
    }

    public static ArrayList<Book> makeBookList(){
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 1; i<=5; i++) {
            books.add(new Book.Builder("Book " +i,(2000+i),"Kemb "+i,"Love "+i).build());
        }

        return books;
    }
}
