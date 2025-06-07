package week4.RuleOfBiodome02;

public class Manager extends User{
    public Manager(String userId, String name) {
        super(userId, name);
    }

    @Override
    public void borrowBook(Book book) {
        if(book.getIsBorrowed())
            System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
        else {
            BookList.add(book);
            book.changeIsBorrowed(book.isbn);
            System.out.println("관리자 '" + getName() + "'가 '" + book.getTitle() + "' 대출합니다.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if(book.getIsBorrowed()) {
            BookList.remove(book);
            book.changeIsBorrowed(book.isbn);
            System.out.println("관리자 '" + getName() + "'가 '" + book.getTitle() + "' 반납합니다.");
        }
        else {
            System.out.println("대출하지 않은 책은 반납할 수 없습니다.");
        }
    }

    @Override
    public void printUser() {
        System.out.println("관리자, " + getName() + "," + getUserId());
    }

//    public void addBook(String isbn, String title, String author) {
//        writeBook(isbn, title, author);
//        System.out.println("관리자 '" + getName() + "'가 책을 추가합니다: '" + title + "' - " + author);
//    }
//
//    public void removeBook(Book book) {
//        removeBooks(book);
//        System.out.println("관리자 '" + getName() + "'가 책을 삭제합니다: '" + book.title + "' - " + book.author);
//    }



}
