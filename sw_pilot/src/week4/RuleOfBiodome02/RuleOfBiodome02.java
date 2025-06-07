package week4.RuleOfBiodome02;


public class RuleOfBiodome02{
    public static void main(String[] args) {
        Library library = new Library();

        Manager manager = library.addManager("01", "세이코");
        Member member1 = library.addMember("11","메리");
        Member member2 = library.addMember("12", "만옥");
        System.out.println();

        Book book1 = library.writeBook(manager,"0001", "자바의 구름", "제임스밥");
        Book book2 = library.writeBook(manager,"0002", "파이썬 마스터", "한송희");
        Book book3 = library.writeBook(manager,"0003", "에너지 플로우", "키네틱스");
        Book book4 = library.writeBook(manager,"0004", "화성에서의 기억", "한송희");
        Book book5 = library.writeBook(manager,"0005", "야채의 비밀", "송은정");
        System.out.println();

        member1.borrowBook(book1);
        System.out.println();

        Book book6 = library.writeBook(manager,"0006", "자료구조의 언덕", "황수");
        Book book7 = library.writeBook(manager,"0007", "그곳에 가면", "한송희");
        System.out.println();

        member2.borrowBook(book1);
        System.out.println();

        member1.returnBook(book1);
        System.out.println();

        manager.borrowBook(book4);
        System.out.println();

        library.searchBook("한송희");
    }
}
