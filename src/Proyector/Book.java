package Proyector;
import java.util.*;

public class Book {
    private String ISBN;
    private String title;
    private String author;
    private Date publishDate = new Date();
    private Boolean isAvailable;

    public void bookCreator(String ISBN, String title, String author, Date publishDate, Boolean isAvailable) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isAvailable = isAvailable;
    }
    //Gege gato de mierda vas a caer
    public String getISBN() {
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public Boolean getAvailable() {
        return isAvailable;
    }
    //Puro setter padrino
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
