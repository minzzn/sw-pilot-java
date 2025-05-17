package week1;

public class HelloBiodome03 {

    final double PI = 3.14;
    final double B = 0.415;
    static double fresult;

    public static double caculateSquareRoot(double humid){
        // 바빌로니아 법을 이용한 제곱근 구하기
        int count=0;
        double guess = humid;
        String result="";
        while(true){
            count++;
            if(count==200){
                result=String.format("%.2f",guess);
                break;
            }
            guess = (guess+(humid/guess))/2;
        }
        double hvalue= Double.valueOf(result);
        return hvalue;
    }
    public double calculateValue(double temp, double hvalue, double oxygen) {
        // 수식 : H = B * | hvalue - t | +( o/PI^2 )
        // 절댓값 구하기
        double absolute = hvalue - temp;
        if( absolute > 0 ) {
            fresult = B * absolute + ( oxygen / ( PI*PI ));
        }
        else { // h-t가 음수인 경우 절댓값 계산
            fresult = B * (-absolute) + ( oxygen / ( PI*PI ));
        }
        return fresult;
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                double temp = Double.valueOf(args[0]);
                double humid = Double.valueOf(args[1]);
                double oxygen = Double.valueOf(args[2]);
                System.out.println("-> 생명지수 H = " + fresult);

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
                return;
            }

        } else {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");

        }
    }
}