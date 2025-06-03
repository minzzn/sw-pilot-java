package week3.BiodomeFamily06;

import java.text.MessageFormat;
import java.util.*;

public class AnimalList {
    List<Animal> animalList;

    public AnimalList() {
        this.animalList = new LinkedList<>();
    }

    public void addAnimal(Animal animal) {
        animalList.add(animal);
    }

    public void printAnimallist() {
        for (Animal source : animalList) {
            (source).printAnimal();
        }
    }

    public void sortAnimallist() {

        List<Animal> elephantsToMove = new LinkedList<>();
        int tigerIndex = 0;

        Iterator<Animal> elephantIterator = animalList.iterator();
        Animal currentAnimal;
        while (elephantIterator.hasNext()) {
            currentAnimal = elephantIterator.next();

            if (currentAnimal != null && Objects.equals(currentAnimal.getSpecies(), "코끼리") && currentAnimal.getAge() < 6) {
                elephantsToMove.add(currentAnimal); // 이동시킬 elephant 수집 (원본 객체 그대로)
                elephantIterator.remove();         // Iterator의 remove()를 사용하여 현재 순회 중인 요소 안전하게 삭제
            }
        }
        if (!elephantsToMove.isEmpty()) {
            animalList.addAll(elephantsToMove);
        } else {
            System.out.println("이동시킬 조건에 맞는 elephant가 없습니다.");
        }
//
//        for (int i = 0; i < animalList.size(); i++) {
//            Animal Ianimal = animalList.get(i);
//            if(Objects.equals(Ianimal.getSpecies(), "tiger")) {
//                tigerIndex = i;
//            }
//        }
//        animalList.addAll(tigerIndex + 1, elephantsToMove);

            // 자바의 List 컬렉션은 반복문(특히 향상된 for 문)으로 순회하는 도중에
            // add()나 remove() 메소드를 호출하여 리스트의 구조(요소의 개수나 순서)를 변경하면
            // ConcurrentModificationException이 발생.
            // Iterator를 사용하여 remove()는 가능하지만, add()를 특정 위치에 여러 개 삽입하는 것은 복잡하다

        List<Animal> deersToMove = new LinkedList<>();
        Iterator<Animal> deerIterator = animalList.iterator();
        while (deerIterator.hasNext()) {
            currentAnimal = deerIterator.next();
            // null 체크 및 조건 확인
            // species 비교 == "deer"를 원하셨으므로 그대로 사용합니다. (일반적으로는 equals가 맞습니다)
            if (currentAnimal != null && Objects.equals(currentAnimal.getSpecies(), "사슴")) {
                deersToMove.add(currentAnimal); // 이동시킬 deer 수집 (원본 객체 그대로)
                deerIterator.remove();        // Iterator의 remove()를 사용하여 현재 순회 중인 요소 안전하게 삭제
            }
            // 만약 species 비교를 == 대신 equals로 하고 싶다면:
            // if (currentAnimal != null && "deer".equals(currentAnimal.getSpecies())) { ... }
        }

        if (!deersToMove.isEmpty()) {
            animalList.addAll(deersToMove);
        } else {
            System.out.println("이동시킬 deer가 없습니다.");
        }

    }
}