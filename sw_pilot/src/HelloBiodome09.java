public class HelloBiodome09 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int input = Integer.parseInt(args[0]);
                if (3 <= input && input <= 10) {
                    int count = input;
                    System.out.println(">>>");
                    int i = 0;
                    while( i < count ) {
                        int blank = count-(i+1);
                        int star = (i*2)+1;

                        if (blank > 0){
                            System.out.println(" ".repeat(blank) + "*".repeat(star) + " ".repeat(blank));
                        }
                        else {
                            System.out.println("*".repeat(star));
                        }
                        i++;
                    }
                    // count-(0+1) = count-1
                    // 적어도 3부터 시작이므로 count가 1 이하일 걱정은 안해도 됨
                    System.out.println(" ".repeat(count-1) + "|" + " ".repeat(count-1));

                    /** count = 3일 때 **/
                    // __*__
                    // _***_
                    // *****
                    // __|__

                    // for문을 사용했을 떄의 문제점 - 아래와 같은 경우 repeat()에 음수값이 들어가게 되어 IllegalArgumentException이 발생
                    //            for (int i=0; i<count; i++){
                    //                System.out.println(" ".repeat(count-(i+1))+"*".repeat((i*2)+1)+" ".repeat(count-(i+1));
                    //            }
                } else {
                    System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            }
        } else {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
        }
    }
}