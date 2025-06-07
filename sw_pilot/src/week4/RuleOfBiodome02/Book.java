package week4.RuleOfBiodome02;

public class Book {

    public String isbn;
    public String title;
    public String author;
    public boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
    public void changeIsBorrowed(String isbn) {
        if(!isBorrowed)
            isBorrowed = true;

        else
            isBorrowed =  false;

    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getIsBorrowed() {
        return this.isBorrowed;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public void printBookInfo() {
        System.out.println(this.title + ", " + this.isbn + ", " + this.author + ", " + this.isBorrowed);
    }

}
