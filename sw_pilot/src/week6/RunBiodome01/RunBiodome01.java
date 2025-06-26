package week6.RunBiodome01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RunBiodome01 {
    public static void main(String[] args) throws IOException {
        System.out.println("멤버 리스트를 입력하세요:");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String inputText = input.readLine();
        String[] freshMen = Arrays.stream(inputText.split(",")).filter(s -> s.contains("신입")).toArray(String[]::new);
        for(int i=0; i<freshMen.length ; i++){
//            String member = Arrays.toString(freshMan.split("-"));
            int cutter = freshMen[i].indexOf("-");
            String member = freshMen[i].substring(cutter + 1, freshMen[i].length());
            String and = (i == freshMen.length-1) ? "" : ", ";
            System.out.print(member + "님 환영합니다" + and);
        }
    }
}