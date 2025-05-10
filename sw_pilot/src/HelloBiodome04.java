public class HelloBiodome04 {

    static boolean isChecktemp;
    static boolean isCheckhumid;
    static boolean isCheckoxygen;

    public static boolean checkRangeTemp(double temp) {
        // 안정한 상태일 때의 조건
        // 온도 : 10도 이상 27.5도 미만
        // 습도 : 40도 초과 60도 미만
        // 산소 농도 : 19.5도 이상 23.5도 이하
        if(10<=temp && temp<27.5){
            isChecktemp=true;
        }  else{
            isChecktemp=false;
        }
        return isChecktemp;
    }
    public static boolean checkRangeHumid(double humid) {
        if(40<humid && humid<=60){
            isCheckhumid=true;
        } else{
            isCheckhumid=false;
        }
        return isCheckhumid;
    }
    public static boolean checkRangeOxygen(double oxygen) {
        if(19.5<=oxygen && oxygen<=23.5){
            isCheckoxygen=true;
        } else{
            isCheckoxygen=false;
        }
        return isCheckoxygen;
    }
    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                double temp = Double.valueOf(args[0]);
                double humid = Double.valueOf(args[1]);
                double oxygen = Double.valueOf(args[2]);
                checkRangeTemp(temp);
                checkRangeHumid(humid);
                checkRangeOxygen(oxygen);
                if(isChecktemp && isCheckhumid && isCheckoxygen){
                    System.out.println("생명의 나무는 안정적인 상태입니다 :)");
                }else if(!isChecktemp){
                    System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                }else if(!isCheckhumid){
                    System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                }else{
                    System.out.println("산소농도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
                return;
            }

        } else {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");

        }
    }
}