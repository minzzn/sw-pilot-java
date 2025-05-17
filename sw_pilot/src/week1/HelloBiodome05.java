//public class HelloBiodome05 {
//    int g;
//    int h;
//    //    수식 1 : g&1>>g<<2|h+g^h == 1  (g&((1>>g)<<2))|((h+g)^h) == 1
//   수식 2 : g%2<<b>>g|1&0^0 == 2  (((g%2)<<h)>>g)|((1&0)^0) == 2
//    수식 3 : (h*h+g)*(b<<b)+(g<<g) = ?
//    public static void calculateGnH(int g, int h) {
//        // 두 방정식의 조건을 비교 연산자로 표현
//        for (g = 0; g <= 7; g++) {
//            for (h = 0; h <= 7; h++) {
//                if ((g&((1>>g)<<2))|((h+g)^h) && (((g%2)<<h)>>g)|((1&0)^0)) {
//                    System.out.println("h = " + h + ", g = " + g);
//                    // 해를 찾았으므로 반복문을 종료합니다.
//                    break;
//                }
//            }
//            if ((x + y == 5) && (x - y == 1)) {
//                break;
//            }
//        }
//    }
//    public static void calculateResult(int g, int h) {
//
//    }
//    public static void main(String[] args) {
//        //calculateResult();
//    }
//}