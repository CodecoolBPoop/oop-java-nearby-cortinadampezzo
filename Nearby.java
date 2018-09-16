import java.util.Scanner;
import java.util.Arrays;

public class Nearby {

    public static void main(String[] args) {
        System.out.println("\nThe result is: " + Arrays.toString(nearby(0, 0, 0)));
    }

    private static int[][] multi = new int[][] {
            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    public static int[] nearby(int x, int y, int range) {

        do {
            Scanner num1 = new Scanner(System.in);
            System.out.println("\nAdd first coordinate:");
            x = num1.nextInt();
            if (x > multi.length-1) {
                System.out.println("Index out of range.");
            }
        } while (x > multi.length-1);

        do {
            Scanner num2 = new Scanner(System.in);
            System.out.println("\nAdd second coordinate: ");
            y = num2.nextInt();
            if (y > multi[x].length-1) {
                System.out.println("Index out of range.");
            }
        } while (y > multi[x].length-1);

        Scanner num3 = new Scanner(System.in);
        System.out.println("\nAdd range: ");
        range = num3.nextInt();

        int[] leftSide = Arrays.copyOfRange(multi[x], Math.max(y-range,0), y);
        int[] rightSide = Arrays.copyOfRange(multi[x], Math.min(y+1,multi[x].length-1), Math.min(y+1+range,multi[x].length-1));
        int[] resultArray = new int[leftSide.length + rightSide.length];
        System.arraycopy(leftSide, 0, resultArray, 0, leftSide.length);
        System.arraycopy(rightSide, 0, resultArray, leftSide.length, rightSide.length);
        return resultArray;
    }

}