package week3.BiodomeFamily06;

import java.util.ArrayList;
import java.util.List;

public class BiodomeFamily06 {
    public static void main(String[] args) {
        AnimalList animalList = new AnimalList();
        Animal monkey = new Animal("제니", "원숭이", 4);
        Animal elephant = new Animal("고먀", "코끼리", 4);
        Animal tiger = new Animal("타이", "호랑이", 9);
        Animal rhino = new Animal("로아", "코뿔소", 5);
        Animal deer = new Animal("바비", "사슴", 7);


        animalList.addAnimal(monkey);
        animalList.addAnimal(elephant);
        animalList.addAnimal(tiger);
        animalList.addAnimal(rhino);
        animalList.addAnimal(deer);

        // 안전한 순서로 배열을 재구성 - 조건
//      호랑이는 사슴의 포식자로, 사슴 뒤에 호랑이가 올 수 없다. - 사슴은 호랑이 뒤에 배치
//      코끼리는 적대 관계의 동물이 없지만, 5살 이하 코끼리는 호랑이 앞에 올 수 없다. - 코끼리가 5살 이하일 경우 호랑이 뒤에 배치
//      일렬 이동 중 동물은 앞만 볼 수 있고 뒤는 볼 수 없다.

        animalList.sortAnimallist();

        animalList.printAnimallist();

    }
}
