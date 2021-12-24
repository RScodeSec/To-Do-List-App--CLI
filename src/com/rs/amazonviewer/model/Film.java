package com.rs.amazonviewer.model;

public class Film {
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean viewed;

    protected Film(Builder<?> builder){
        title = builder.title;
        genre = builder.genre;
        creator = builder.creator;
        duration = builder.duration;
        year = builder.year;
        viewed = builder.viewed;
    }

    /**
     * Clean code
     * Builder Pattern
     */
    public static class Builder<T extends Builder<T>>{
        //Required parameters
        private String title;
        private String genre;
        private short year;

        //optional parameters
        private String creator;
        private int duration;
        private boolean viewed;

       public Builder (String title, String genre, short year){
            this.title = title;
            this.genre = genre;
            this.year = year;
        }


        public T creator (String creator){
            this.creator = creator;
            return (T) this;
        }
        public T duration (int duration){
            this.duration = duration;
            return (T) this;
        }
        public T viewed (boolean viewed){
            this.viewed = viewed;
            return (T) this;
        }
        public Film build (){
            return new Film(this);
        }

    }
    public void setViewed( boolean viewed){
        this.viewed = viewed;
    }
    public void setTimeViewed( int duration){
        this.duration = duration;
    }

    public int getDuration(){
        return duration;
    }

    public String getTitle(){
        return title;
    }
    public String getGenre(){
        return genre;
    }

    public short getYear(){
        return year;
    }
    public String isViewed(){
        String visto = "";
        if(viewed){
            visto = "Yes";
        }
        else{
            visto = "Not";
        }
        return visto;
    }
    public boolean getIsViewed(){
        return viewed;
    }


    public  void showData(){
       System.out.println("Title " + title);
       System.out.println("Genre " + genre);
       System.out.println("Year " + year);
   }
}
