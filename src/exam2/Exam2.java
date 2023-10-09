package exam2;

import java.util.Scanner;
import java.util.Stack;

public class Exam2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in) ;
        Stack<String> stack = new Stack<>();
        String stackReverse = "";
        int choice ;
        do {
            System.out.println("__________JAVA-HACKATHON-05-ADVANCE-1-MENU___________");
            System.out.println("1. Nhap vao van ban ");
            System.out.println("2. Dao nguoc van ban");
            System.out.println("3. Thoat");
            choice = Integer.parseInt(sc.nextLine()) ;
            switch (choice) {
                case 1 :
                    System.out.println("Nhap vao doan van ban");
                    String text = sc.nextLine();
                    String[] words = text.split(" ") ;
                   for (String tt : words) {
                       stack.push(tt) ;
                   }

                    break;
                case 2 :
                    System.out.println("Van ban bi dao nguoc ");
                    while (!stack.empty()) {
                        System.out.print(stack.pop());
                    }
                    break;
                case 3 :
                    System.err.println("Thoat khoi chuong trinh");
                    sc.close();
                    break;
                default:
                    System.err.println("Lua chon khong phu hop . Vui long chon lai ");
            }
        }while (choice != 3 ) ;
    }
}
