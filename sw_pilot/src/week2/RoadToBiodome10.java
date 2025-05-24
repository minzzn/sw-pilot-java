//package week2;
//
//import java.io.OptionalDataException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//import java.util.stream.Stream;
//
//public class RoadToBiodome10 {
//    /**
//     * @see <a href="https://pixx.tistory.com/231"></a>
//     */
//    private static ArrayList<ArrayList<Integer>> graph;
//    private static boolean[] visited;
//    private static int rows;
//    private static int cols;
//    private static int[][] grid;
//
//    private static int[] dx = {-1, 1, 0, 0};
//    private static int[] dy = {0, 0, -1, 1};
//
//    public static void dfs(int startNode) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(startNode);
//        visited[startNode] = true;
//
//        while (!stack.isEmpty()) {
//            int currentNode = stack.pop();
//
//            for (int neighbor : graph.get(currentNode)) {
//                if(!visited[neighbor]) {
//                    visited[neighbor] = true;
//                    stack.push(neighbor);
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        int rows = args.length;
//        if (rows >= 2) {
//            try {
//                int cols = args[0].length();
//
//                for (int i = 0; i < rows; i++) {
//                    String line = args[i];
//                    int[] arr = Stream.of(line.split(",")).mapToInt(Integer::parseInt).toArray();
//                    if (arr.length != cols) {
//                        System.out.println("올바른 입력이 아닙니다. 2차원 배열이 생성되도록 값을 입력하세요.");
//                        return;
//                    }
//                    boolean isValidLine = Arrays.stream(arr).allMatch(n -> 1 <= n && n <= 100); // 모든 요소가 0 또는 1인지 확인
//
//                    if (!isValidLine) {
//                        System.out.println("올바른 입력이 아닙니다. 1부터 100까지의 값을 입력하세요.");
//                        return; // 유효하지 않은 문자가 있으면 바로 종료
//                    }
//
//                    for (int j = 0; j < cols; j++) {
//                        graph[i][j] = arr[j];
//                    }
//                }
//                dfs(1);
//            }
//            catch (NumberFormatException e){
//                System.out.println("올바른 입력이 아닙니다. 숫자로 이루어진 2차원 배열이 생성되도록 값을 입력하세요.");
//            }
//        }
//        else {
//            System.out.println("올바른 입력이 아닙니다. 2차원 배열이 생성되도록 값을 입력하세요.");
//        }
//
//
//
//    }
//}