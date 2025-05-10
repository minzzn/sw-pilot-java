public class HelloBiodome01 {
    public static void main(String[] args) {
        String name= args[0];
        if (args.length == 0) {
            System.out.println("이름을 다시 입력해 주세요");
            return;
        }
        else{
            System.out.print("이름을 입력하세요: ");
            System.out.println("안녕하세요," + name + "님!");
            System.out.println("스프링와트에 오신걸 환영합니다," + name + "님!");
            System.out.println("안녕하세요," + name + ".");
        }

    }
}