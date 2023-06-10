package abdn.scnu.ai;

public class Exam {
    public static void main(String[] args) {
        int y = 0;
        for (int x = 0; x < 4; x++) {
            y = x;
            do {
                System.out.printf("%d", y--);
            } while (y > 0);
            System.out.println();
        }
        System.out.println(y);
    }
}
