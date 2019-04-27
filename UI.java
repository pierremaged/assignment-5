package eg.edu.alexu.csd.datastructure.stack.cs22;
import java.util.Scanner;
public class UI {
    public static void main (String[] args) {
        int number;int num;
        Stack p=new Stack();
        while(true){
            System.out.print("Please choose an action\n" +
                    "-----------------------\n" +
                    "1- Push\n" +
                    "2- Pop\n" +
                    "3- Peek\n" +
                    "4- Get size\n" +
                    "5- Check if empty\n" +
                    "====================================================================\n"
            );
            Scanner d=new Scanner(System.in);
            number=d.nextInt();
            switch (number){
                case 1:
                    System.out.print("Enter the number you want to push:\n");
                    Scanner t=new Scanner(System.in);
                    num=t.nextInt();
                    p.push(num);
                    break;
                case 2:
                    System.out.println(p.pop());
                    break;
                case 3:
                    System.out.println(p.peek());
                    break;
                case 4:
                    System.out.println(p.size());
                    break;
                case 5:
                    System.out.println(p.isEmpty());
                    break;
                default:
                    System.out.println("You entered a wrong number");
            }
        }

    }

}
