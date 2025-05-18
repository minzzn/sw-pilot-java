package week2;

public class RoadToBiodome08 {
    private int front;
    private int rear;
    private int queueSize;
    private String itemArray[];

    public RoadToBiodome08(int queueSize){
        front = -1;
        rear = -1;
        this.queueSize = queueSize;
        itemArray = new String[this.queueSize];
    }

    public boolean isEmpty(){
        return (front==rear);
    }

    public boolean isFull(){
        return (rear==queueSize-1);
    }

    public void enQueue(String item) {
        checkIsFull();
        itemArray[++rear] = item;
    }

    public void deQueue() {
        checkIsEmpty();
        ++front;
    }

    public void delete() {
        checkIsEmpty();
        ++front;
    }

    public String peek() {
        checkIsEmpty();
        return itemArray[front+1];
    }

    public void printQueue(){
        checkIsEmpty();
        for(int i=front+1; i<rear; i++){
            System.out.print(itemArray[i] + " ");
        }
        System.out.println();
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
                    System.out.println("올바른 자원의 양을 입력해주세요.");
                }
                else {
                    if (args[0].length() >= 100) {
                        System.out.println("입력된 값의 범위가 올바르지 않습니다. 큐의 최대 크기는 100입니다.");
                        System.exit(0);
                    }
                    int queueSize = args.length;
                    RoadToBiodome08 queue = new RoadToBiodome08(queueSize);
                    for (int i=0; i<queueSize; i++){
                        queue.enQueue(args[i]);
                    }
                    System.out.println("-->");
                    for (int i=0; i<queueSize; i++){
                        System.out.println("자원" + queue.peek() + "을 제공했습니다.");
                        queue.deQueue();
                    }
                    System.out.println("모든 요청이 처리되었습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("입력된 값이 올바르지 않습니다. 올바른 자원의 양을 입력해주세요.");
            }
        } else {
            System.out.println("올바른 자원의 양을 입력해주세요.");
        }
    }
}