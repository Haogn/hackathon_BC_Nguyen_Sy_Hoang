package exam3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        Queue<String > queue = new LinkedList<>();
        int choice ;
        do {
            System.out.println("_________JAVA-HACKATHON-05-ADVANCE-1-MENU__________");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            choice = Integer.parseInt(sc.nextLine()) ;
            switch (choice) {
                case 1 :

                    System.out.print("Nhap vao so phu huynh noi ho so  ");
                    int n  = Integer.parseInt(sc.nextLine()) ;
                    int next = 1 ;
                    for (int i = 0; i < n; i++) {
                        System.out.print("Phu huynh thu " + next++ + ": ");
                        String parentName = sc.nextLine();
                        queue.add(parentName);
                    }
                    break;
                case 2 :
                    if (!queue.isEmpty()) {
                        String nextParent = queue.poll();
                        System.out.println("Phu huynh dau tien trong danh sach " + nextParent);
                    } else {
                        System.out.println("Danh sach rong.");
                    }
                    break;
                case 3 :
                    System.err.println("Thoat khoi chuong trinh ");
                    sc.close();
                    break;
                default:
                    System.err.println("Lua chon khong phu hop . Vui long chon lai ");
            }
        } while (choice != 3) ;
    }
}
