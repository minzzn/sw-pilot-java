package week2;


import java.util.Arrays;
import java.util.Objects;

public class RoadToBiodome02 {
    private String type;
    private int capacity;
    private int top = -1;
    private Object[] stackArray;
    RoadToBiodome02(String type){
        this.type = type;
        stackArray = new Object[capacity];
    }
    RoadToBiodome02(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        stackArray = new Object[capacity];
    }
    public void push(Object element) {
        checkType(element);
        checkIsFull();
        stackArray[++top] = element;
    }
    public Object pop() {
        checkIsEmpty();
        Object element = stackArray[top];
        stackArray[top] = null;
        top--;
        return element;
    }
    public Object peek() {
        checkIsEmpty();
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top >= this.capacity-1);
    }
    public void clear() {
        checkIsEmpty();
        this.top = -1;
        stackArray = new Object[this.capacity];
    }
    public void printStack() {
        for(Object ele : stackArray){
            if(ele != null){
                System.out.print(ele + " ");
            }
        }
    }
    public int size() {
        return (this.top + 1);
    }
    private void checkType(Object obj){
        if(!Objects.equals(this.type, obj.getClass().getSimpleName())){
            throw new IllegalStateException(("타입 에러"));
        }
    }
    private void checkIsFull(){
        if(isFull()){
            throw new IllegalStateException("스택이 가득참");
        }
    }
    private void checkIsEmpty(){
        if(isEmpty()){
            throw new IllegalStateException("스택이 비었음");
        }
    }
    public static void main(String[] args){
        if (args.length > 0) {
            try {
                String combined = String.join(" ",args);
                if (combined.isBlank()) {
                    System.out.println("올바른 문장을 입력해주세요.");
                }
                else {
                    if (args[0].length() < 2 || args[0].length() > 1000000) {
                            System.out.println("입력된 값의 범위가 올바르지 않습니다. 2에서 10^6 길이의 문자열을 입력해주세요.");
                            System.exit(0);
                        }
                    // Array.toString() 은 배열 내용 출력이기 때문에 input에 "[새로운, 나무가, 발견되었습니다]" 와 같은 값이 들어감 주의
                    String input = String.join(" ",args);

                    RoadToBiodome02 stack = new RoadToBiodome02("Character", input.length());
                    for(int i = 0; i < input.length(); i++){
                        stack.push(input.charAt(i));
                    }
                    String[] result;
                    for(int i = 0; i < input.length(); i++){
                        System.out.print(stack.pop());
                    }


                }

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 올바른 문장을 입력해주세요.");
            }
        } else {
            System.out.println("올바른 문장을 입력해주세요.");
        }
    }
}