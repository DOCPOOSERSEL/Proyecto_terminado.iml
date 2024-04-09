package Proyector;

import java.util.Date;

public class Transaction {

    private String transactionID;
    private String type;
    private User client = new User();
    private Book borrowedBook = new Book();
    private Date borrowDate = new Date();

    public void createNewTransaction(String transactionID, String type, User client, Book borrowedBook, Date borrowDate) {
        this.transactionID = transactionID;
        this.type = type;
        this.client = client;
        this.borrowedBook = borrowedBook;
        this.borrowDate = borrowDate;
    }

    //geterrrrrrrrzzzzzz

    public String getTransactionID() {
        return transactionID;
    }

    public String getType() {
        return type;
    }

    public User getClient() {
        return client;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

}
