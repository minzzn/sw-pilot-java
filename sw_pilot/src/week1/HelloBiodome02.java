package week1;

public class HelloBiodome02 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int solar = Integer.parseInt(args[0]);
                int wind = Integer.parseInt(args[1]);
                int geother = Integer.parseInt(args[2]);
                int sum = solar + wind + geother;
                System.out.println("-> 총 에너지 사용량은 " + sum + " 입니다.");

            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 값을 입력하셨어요.");
                return;
            }

        } else {
            System.out.println("입력하세요 : ");

        }
    }
}