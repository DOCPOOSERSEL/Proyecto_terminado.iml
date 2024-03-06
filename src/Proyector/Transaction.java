package Proyector;

import java.util.Date;

public class Transaction {

    private String transactionID;
    private String type;
    private Client client = new Client();
    private Book borrowedBook = new Book();
    private Date borrowDate = new Date();

    public void createNewTransaction(String transactionID, String type, Client client, Book borrowedBook, Date borrowDate) {
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

    public Client getClient() {
        return client;
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

}
