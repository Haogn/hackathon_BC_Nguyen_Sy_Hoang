package exam1.ra.run;

import exam1.ra.bussinessImp.Catalog;
import exam1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static exam1.ra.bussinessImp.Product.*;

public class ProductManagement {
    public static Scanner sc = new Scanner(System.in) ;
    public static List<Catalog> listCatalog = new ArrayList<>() ;
    public static List<Product> listProduct = new ArrayList<>() ;

public static ProductManagement productManagement = new ProductManagement();
    public static void main(String[] args) {
        int choice ;
     do {
         System.out.println("___________JAVA-HACKATHON-05-ADVANCE-2-MENU______________");
         System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
         System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
         System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) ");
         System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
         System.out.println("5. Thoát");
         System.out.println("Lua chon de thuc hien quan ly MENU ");
         choice = Integer.parseInt(sc.nextLine()) ;
         switch (choice) {
             case 1 :
                 createCatalog();
                 break;
             case 2 :
                 createProduct();
                 break;
             case 3 :
                 sortByPrice();
                 break;
             case 4 :
                 searchProductByCatalog();
                 break;
             case 5 :
                 System.err.println("THoat khoa chuong trinh");
                 sc.close();
                 break;
             default:
                 System.err.println("Lua chon khong phu hop. Vui long chon lai ❤");
         }
     } while (choice != 5) ;
    }

    public static void createCatalog() {
        System.out.println("nhap so danh muc muon them vao danh sach");
        int n = Integer.parseInt(sc.nextLine()) ;
        for (int i = 0; i < n; i++) {
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            listCatalog.add(newCatalog);
        }
        getAllCatalog();
    }

    public static void createProduct(){
        System.out.println("nhap so danh muc muon them vao danh sach");
        int n = Integer.parseInt(sc.nextLine()) ;
        for (int i = 0; i < n; i++) {
            Product newProduct = new Product();
            newProduct.inputData();
            listProduct.add(newProduct) ;
        }
        getAllProduct();
    }

    public static void sortByPrice() {
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getExportPrice() - o2.getExportPrice());
            }
        });
        System.out.println("Sap xep loi nhuan tang dan");
        for (Product product: listProduct) {
            System.out.println(product.getCatalog().getCatalogName() + " - " + product.getExportPrice() + " VND");
        }
    }

    public static void searchProductByCatalog() {
        System.out.println("Nhap vao danh muc san pham ");
        String nameCatalog = sc.nextLine();
        for (Product product : listProduct) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(nameCatalog)) {
                System.out.println("San pham co trong danh sach ");
                product.displayData();
                break;
            } else {
                System.err.println("Khong tim thay san pham trong danh muc ");
                break;
            }
        }
    }
}
