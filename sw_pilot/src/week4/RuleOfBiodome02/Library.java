package week4.RuleOfBiodome02;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public Library() {

    }

    public Book writeBook(Manager manager, String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        System.out.println("관리자 '" + manager.getName() + "'가 책을 추가합니다: '" + title + "' - " + author);
        return book;
    }

    public void removeBooks(Manager manager, Book book) {
        books.remove(book);
        System.out.println("관리자 '" + manager.getName() + "'가 책을 삭제합니다: '" + book.title + "' - " + book.author);

    }

    public Member addMember(String userId, String name) {
        Member member = new Member(userId, name);
        System.out.println("새로운 이용자 '" + member.getName() + "'를 등록합니다.");
        users.add(member);
        return member;
    }

    public Manager addManager(String userId, String name) {
        Manager manager = new Manager(userId, name);
        System.out.println("새로운 관리자 '" + manager.getName() + "'를 등록합니다.");
        users.add(manager);
        return manager;
    }

    public void printUser() {
        System.out.println("도서관 회원 정보 : ");
        for (User user : users) {
            user.printUser();
        }
    }

    public void printBook() {
        System.out.println("도서관 책 정보 : ");
        for (Book book : books) {
            book.printBookInfo();
        }
    }

    public void searchBook(String author) {
        System.out.println("저자 '" + author + "'의 책 목록");
        String borrow = "";
        Book book = null;
        for (Book searchedBook : books) {
            if(searchedBook.getAuthor().equals(author)) {
                book = searchedBook;
                borrow = book.isBorrowed ? "대출 불가" : "대출 가능";
                System.out.println("• " + book.getTitle() + ", " + borrow);
            }
        }

//        if(book == null)
//            System.out.println("해당 책을 찾을 수 없습니다.");
    }
}
