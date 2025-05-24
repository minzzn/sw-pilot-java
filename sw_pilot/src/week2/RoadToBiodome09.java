package week2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class RoadToBiodome09 {
    /**
     * @see <a href="https://velog.io/@kyungmin/JAVA-%EB%AF%B8%EB%A1%9C%EC%9D%98-%EC%B5%9C%EB%8B%A8%EA%B1%B0%EB%A6%AC-BFS"></a>
     */
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int[][] board;
    static boolean[][] visited;
    static int[][] dist;

    static void bfs(int x, int y, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        visited[x][y] = true;
        dist[x][y] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int currentDist = dist[now[0]][now[1]];

            if (now[0] == rows - 1 && now[1] == cols - 1) {
                break; // 출구에 도달했으면 BFS 종료
            }

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    if(board[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = currentDist + 1;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int rows = args.length;
        if (rows < 2) {
            System.out.println("올바른 입력이 아닙니다. 2차원 배열이 생성되도록 값을 입력하세요.");
        }
        int cols = args[0].length();

        board = new int[rows][cols];
        visited = new boolean[rows][cols];
        dist = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            String line = args[i];
            int[] arr = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
            if(arr.length != cols) {
                System.out.println("올바른 입력이 아닙니다. 2차원 배열이 생성되도록 값을 입력하세요.");
                return;
            }
            boolean isValidLine = Arrays.stream(arr).allMatch(n -> n == 0 || n == 1); // 모든 요소가 0 또는 1인지 확인

            if (!isValidLine) {
                System.out.println("올바른 입력이 아닙니다. 0또는 1만 포함해야 합니다.");
                return; // 유효하지 않은 문자가 있으면 바로 종료
            }

            for(int j = 0; j < cols; j++) {
                board[i][j] = arr[j];
            }
        }

        int startX = 0;
        int startY = 0;

        int endX = rows - 1;
        int endY = cols - 1;

        // 시작점이 벽인지 확인 (문제 조건에 따라 시작점이 항상 이동 가능할 수도 있음)
        if (board[startX][startY] == 0) {
            System.out.println("-1"); // 시작점이 벽이면 도달 불가능
            return;
        }

        dist[startX][startY] = 0;

        bfs(startX, startY, rows, cols);

        if(dist[endX][endY] == 0 ) {
            if (startX == endX && startY == endY) {
                System.out.println(0);
            } else {
                System.out.println("입구에서 출구로 연결된 안전한 경로가 없습니다.");
            }
        } else {
            System.out.println(dist[endX][endY]);
        }
    }
}

/*
    원형큐를 구현하고 나서 java 기본 제공 queue를 사용하라는 구현지침을 본,,,,
    불미스러운 일이 발생했어요 ....
    *//**
 * @see <a href="https://jiji-gilog.tistory.com/4"/>코드 참고 출처</a>
 *//*
    private static int front = 0;
    private static int rear = 0;
    private static int queueSize = 0;
    private static int[] queue;

    private static void resize(int newCapacity) {
        int[] newQueue = new int[newCapacity];

        for (int i = 1, j = front + 1; i <= queueSize; i++, j++) {
            newQueue[i] = queue[j % queue.length];
        }
        queue = newQueue;
        front = 0;
        rear = queueSize;
    }

    *//**
 *  enqueue = offer - 큐 마지막에 요소를 추가
 *//*
    private static void offer(int val) {
        if (front == (rear + 1) % queue.length) {
            resize(queue.length * 2);
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = val;
        queueSize++;
    }

    *//**
 * dequeue = poll - 큐의 첫 번째 요소를 삭제 및 반환
 *//*
    private static int poll() {
        checkIsEmpty();

        front = (front + 1) % queue.length;
        int element = queue[front];

        queue[front] = 0;
        queueSize--;

        if(queueSize < (queue.length / 4)) {
            resize(queue.length / 2);
        }
        return element;
    }

    *//**
 * delete = remove - 큐의 첫 번째 요소를 삭제 및 반환
 *//*
    private static int remove() {
        int element = poll();

        return element;
    }

    private static int size() {
        return queueSize;
    }

    private static boolean isEmpty(){
        return (front==rear);
    }

    private static boolean isFull(){
        return ( rear + 1 ) % queue.length == front;
    }

    *//**
 * peek = front - 큐의 첫 번째 요소를 반환
 * back - 큐의 마지막 요소를 반환
 * @return
 *//*
//    private static int peek() {
//        checkIsEmpty();
//        return queue[(front + 1) % queue.length];
//    }

    private static int front() {
        checkIsEmpty();
        return queue[(front + 1 ) % queue.length];
    }

    private static int back() {
        checkIsEmpty();
        return queue[(rear) % queue.length];
    }
    public void printQueue(){
        checkIsEmpty();
        for(int i=front+1; i<rear; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    private static void checkIsFull(){
        if(isFull()){
            throw new IllegalStateException("큐가 가득참");
        }
    }
    private static void checkIsEmpty(){
        if(isEmpty()){
            throw new IllegalStateException("큐가 비었음");
        }
    }*/