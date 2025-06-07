package week4.RuleOfBiodome02;

import java.util.LinkedList;
import java.util.List;

public class User {
    String userId;
    String name;
    List<Book> BookList;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.BookList = new LinkedList<>();
    }

    public String getName() {
        return this.name;
    }

    public String getUserId() {
        return this.userId;
    }

    public void printUser() {
        System.out.println(getName() + "," + getUserId());
    }

    void borrowBook(Book book) {
        if(book.getIsBorrowed())
            System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
        else {
            BookList.add(book);
            book.changeIsBorrowed(book.isbn);
            System.out.println("직책 '" + getName() + "'가 '" + book.getTitle() + "' 대출합니다.");
        }
    }

    void returnBook(Book book) {
        if(book.getIsBorrowed()) {
            book.changeIsBorrowed(book.isbn);
            System.out.println("직책 '" + getName() + "'가 '" + book.getTitle() + "' 반납합니다.");
        }
        else {
            System.out.println("대출하지 않은 책은 반납할 수 없습니다.");
        }
    }


}
