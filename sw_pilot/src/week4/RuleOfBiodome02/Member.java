package week4.RuleOfBiodome02;

public class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void borrowBook(Book book) {
        if(book.getIsBorrowed())
            System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
        else {
            BookList.add(book);
            book.changeIsBorrowed(book.isbn);
            System.out.println("이용자 '" + getName() + "'가 '" + book.getTitle() + "' 대출합니다.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if(book.getIsBorrowed()) {
            BookList.remove(book);
            book.changeIsBorrowed(book.isbn);
            System.out.println("이용자 '" + getName() + "'가 '" + book.getTitle() + "' 반납합니다.");
        }
        else {
            System.out.println("대출하지 않은 책은 반납할 수 없습니다.");
        }
    }

    @Override
    public void printUser() {
        System.out.println("이용자, " + getName() + "," + getUserId());
    }

}
