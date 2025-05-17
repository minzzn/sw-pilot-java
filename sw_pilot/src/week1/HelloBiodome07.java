package week1;

public class HelloBiodome07 {
    public static void compressInput(String genecode, char currentChar, char upperCurrentChar, int i) {
        // 허용되는 문자인 경우 카운트 및 압축 진행
        String compressedGeneCode = ""; // 압축된 문자열을 저장
        int count = 0;
        int j = i; // 현재 문자 위치부터 시작
        // 연속되는 동일한 문자(대소문자 구분 없이)의 개수 카운트
        for (; j < genecode.length() && Character.toUpperCase(genecode.charAt(j)) == upperCurrentChar; j++) {
            count++; // 일치하면 카운트 증가
        }

        compressedGeneCode += upperCurrentChar;
        if (count > 1) {
            compressedGeneCode += count;
        }

        // 외부 for 문의 다음 반복을 위해 인덱스 i를 업데이트
        i = j; // 연속된 문자 건너뛰기
        System.out.println("압축된 유전자 코드: " + compressedGeneCode);
    }
    public static void main(String[] args) {
        // 문자열에 공백이 있다면 제거
        String genecode = args[0].replace(" ", "");
        if (!genecode.isEmpty()) {
            if (genecode.isBlank()) {
                System.out.println("염기서열이 입력되지 않았습니다.");
            }
            else {
                String allowedChars = "CYJEHcyjeh";

                for (int i = 0; i < genecode.length(); ) {
                    char currentChar = genecode.charAt(i);
                    char upperCurrentChar = Character.toUpperCase(currentChar); // 구분 없애려고 대문자로 변경

                    // 허용되는 문자인지 확인
                    if (allowedChars.indexOf(currentChar) == -1) {
                        System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
                        return; // 허용되지 않는 문자 발견 시 프로그램 종료
                    }
                    else{
                        compressInput(genecode,currentChar, upperCurrentChar, i);
                    }

                }

            }

        } else {
            System.out.println("염기서열이 입력되지 않았습니다.");

        }
    }
}