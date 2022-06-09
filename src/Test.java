import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws MyExceptions {
        Scanner sc = new Scanner(System.in);
        Calculate calc = new Calculate();
        calc.calculator(sc.nextLine());
        System.out.println(calc.calc());
    }

}
