package com.rs.amazonviewer;
import com.rs.amazonviewer.model.*;
import com.rs.makereport.Report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        showMenu();
    }
    public static void showMenu(){
        int exit = 1;

        do{
            System.out.println("Welcome to Amazon Viewer");
            System.out.println("");
            System.out.println("Choose the desired option");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");

            //all action of condition
            System.out.println("Enter a number: ");
            Scanner value = new Scanner(System.in);
            int opc = value.nextInt();
            switch (opc){
                case 0:
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;
                case 2:
                    showSeries();
                    break;
                case 3:
                    showBooks();
                    break;
                case 4:
                    showMagazine();
                    break;
                case 5:
                    makeReport();
                    break;
                case 6:
                    makeReport(new Date());
                    break;
            }
        } while (exit !=0);

    }
    static ArrayList<Movie> movies;
    public  static void showMovies(){
        int exit = 1;
         movies = Movie.makeMoviesList();
        do{
            System.out.println();
            System.out.println(":: MOVIES ::");
            System.out.println();

            for (int i = 0; i < movies.size(); i++) {
                System.out.println(i+1+ ". "+movies.get(i).getTitle()+" Viewed: "+movies.get(i).isViewed());
            }
            System.out.println("0. Return to menu");
            System.out.println();
            // read input
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }
            if(response>0){
                Movie movieSelected = movies.get(response -1);
                movieSelected.setViewed(true);
                //Start to see
                Date dateI = movieSelected.startToSee(new Date());
                for (int i = 0; i<1000; i++){
                    System.out.println("......");
                }
                //End to See
                movieSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("You saw: "+ movieSelected);
                System.out.println("For:" + movieSelected.getDuration()+" milliseconds");

            }


        }while (exit!=0);

    }
    public  static void showSeries(){
        int exit = 1;
        ArrayList<Serie> series = Serie.makeSeriesList();
        do{
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();

            for (int i = 0; i < series.size(); i++) {
                System.out.println(i+1+ ". "+series.get(i).getTitle()+" Viewed: "+series.get(i).isViewed());
            }
            System.out.println("0. Return to menu");
            System.out.println();
            // read input
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }
            Serie serieSelected = series.get(response-1);
            serieSelected.setViewed(true);
            showChapters(series.get(response-1).chapters());


        }while (exit!=0);
    }
    public  static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected){
        int exit = 1;
        do{
            System.out.println();
            System.out.println(":: CHAPTERS ::");
            System.out.println();

            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {
                System.out.println(i+1+ ". "+chaptersOfSerieSelected.get(i).getTitle()+" Viewed: "+chaptersOfSerieSelected.get(i).isViewed());
            }
            System.out.println("0. Return to menu");
            System.out.println();

            // read input
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showSeries();
            }
            Chapter chapterSelected = chaptersOfSerieSelected.get(response -1);
            chapterSelected.setViewed(true);
            Date dateI = chapterSelected.startToSee(new Date());
            for (int i = 0; i < 1000; i++) {
                System.out.println("...............");
            }
            //ended of see
            chapterSelected.stopToSee(dateI,new Date());
            System.out.println();
            System.out.println("You saw: "+ chapterSelected);
            System.out.println("To: "+ chapterSelected.getDuration() +" milliseconds");


        }while (exit!=0);

    }
    public  static void showBooks(){
        int exit = 1;
        ArrayList<Book> books = Book.makeBookList();
        do{
            System.out.println();
            System.out.println(":: BOOKS ::");
            System.out.println();

            for (int i = 0; i < books.size(); i++) {
                System.out.println(i+1+ ". "+books.get(i).getTitle()+" Readed: "+books.get(i).isReaded());
            }
            System.out.println("0. Return to menu");
            System.out.println();
            // read input
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }
            Book bookSelected = books.get(response -1);
            bookSelected.setReaded(true);
            //Start to see
            Date dateI = bookSelected.startToSee(new Date());
            for (int i = 0; i<1000; i++){
                System.out.println("......");
            }
            //End to See
            bookSelected.stopToSee(dateI, new Date());
            System.out.println();
            System.out.println("You saw: "+ bookSelected);
            System.out.println("For:" + bookSelected.getTimeReaded()+" milliseconds");

        }while (exit!=0);
    }
    public  static void showMagazine(){
        int exit = 1;
        ArrayList<Magazine> magazines = Magazine.makeMagazineList();
        do{
            System.out.println();
            System.out.println(":: MAGAZINE ::");
            System.out.println();

            for (int i = 0; i < magazines.size(); i++) {
                System.out.println(i+1+ ". "+magazines.get(i).getTitle()+" Editorial: "+magazines.get(i).getEditorial()+" Edition Date: "+magazines.get(i).getEditionDate());
            }
            System.out.println("0. Return to menu");
            System.out.println();
            // read input
            Scanner sc = new Scanner(System.in);
            int response = Integer.valueOf(sc.nextLine());
            if(response == 0){
                showMenu();
            }

        }while (exit!=0);
    }

    public static  void makeReport(){
        Report report = new Report();
        report.setNameFile("report");
        report.setExtension("txt");
        report.setTitle(":: Views ::");
        String contentReport = "";
        for (Movie movie: movies) {
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();

    }
    public static  void makeReport(Date date){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("report"+dateString);
        report.setExtension("txt");
        report.setTitle(":: Views ::");
        String contentReport = "";
        for (Movie movie: movies) {
            if(movie.getIsViewed()){
                contentReport += movie.toString();
            }
        }
        report.setContent(contentReport);
        report.makeReport();

    }
}
