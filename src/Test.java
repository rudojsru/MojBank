
import java.util.Scanner;

public class Test {
        public static void main(String[] args) {
                Scanner keubord =new Scanner(System.in);
                while (true){
                        try {
                                int a =Integer.parseInt(keubord.nextLine());
                        }catch (NumberFormatException e){
                                System.out.println(" Please provide just a number");
                        }
                }
        }

}
