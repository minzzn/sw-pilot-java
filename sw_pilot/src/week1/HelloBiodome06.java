package week1;

public class HelloBiodome06 {
    public static void main(String[] args) {
        if (args.length == 2) {
            String genecode1 = args[0];
            String genecode2 = args[1];
            int i = 0;
            // 각 문자가 일치하는지 비교, 똑같으려면 문자열의 길이가 같아야 하므로 i < genecode1.length()를 조건으로 설정
            while(i < genecode1.length()) {
                if(genecode1.charAt(i) == genecode2.charAt(i)){
                    i++;
                }else break;
            }
            // 마지막 문자까지 검사를 진행했어도, 마지막 문자가 다르면 i = genecode1.length() - 1 이므로 조건을 i == genecode1.length()로 설정
            if(i == genecode1.length()){
                System.out.println("동일한 유전자 코드입니다.");
            } else{
                System.out.println("일치하지 않습니다.");
            }

        } else {
            System.out.println("두 개의 유전자 코드를 입력해주세요.");

        }
    }
}