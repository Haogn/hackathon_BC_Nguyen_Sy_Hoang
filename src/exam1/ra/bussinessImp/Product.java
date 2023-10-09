package exam1.ra.bussinessImp;

import exam1.ra.bussiness.ISHop;
import exam1.ra.cofix.InputMethods;

import static exam1.ra.run.ProductManagement.*;
public class Product implements ISHop {
    private static int nextId = 1 ;
    private int productId ;
    private String productName ;
    private String title ;
    private String descriptions ;
    private Catalog catalog ;
    private float importPrice ;
    private float exportPrice ;
    private  boolean productStatus ;

    public Product() {
        this.productId = nextId++ ;

    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        // ten san pham
        while (true) {
            System.out.println("Nhap vao ten san pham");
            String name = sc.nextLine();
            if (listProduct.isEmpty()) {
                this.productName = name;
                break;
            } else {
                boolean isExist = false ;
                for (int i = 0; i < listProduct.size(); i++) {
                    if (listProduct.get(i).getProductName().equals(name)) {
                        System.err.println("Ten san pham da co trong danh sach . Vui long nhap lai ❤");
                        isExist = true ;
                        break;
                    }
                }
                if (!isExist) {
                    this.productName =name ;
                    break;

                }
            }
        }

        // tieu de
        while (true) {
            System.out.println("Nhap vao tieu de danh muc");
            String tieude = sc.nextLine();
            if (tieude.trim().isEmpty()) {
                System.err.println("Mo ta danh muc khong dc de rong . Vui long nhap lai ❤");;
            } else {
                this.title = tieude ;
                break;
            }
        }

        // mo ta san pham
        while (true) {
            System.out.println("Nhap vao mo ta danh muc");
            String mota = sc.nextLine();
            if (mota.trim().isEmpty()) {
                System.err.println("Mo ta danh muc khong dc de rong . Vui long nhap lai ❤");;
            } else {
                this.descriptions = mota ;
                break;
            }
        }

        // gia nhap vao
        while (true) {
            System.out.println("Gia nhap vao ");
            float priceImport = Float.parseFloat(sc.nextLine()) ;
            if ( priceImport <= 0 ) {
                System.err.println("Gia nhap vao khong the nho hon 0. Vui long nhap lai ❤");
            } else {
                this.importPrice = priceImport ;
                break;
            }
        }

        while (true) {
            System.out.println("Trang thai cua san pham ( CO - KHONG ) ");
            String tt = InputMethods.getString();
            if ( tt.equalsIgnoreCase("co")){
                this.productStatus = true ;
                break;
            } else if (tt.equalsIgnoreCase("khong")) {
                this.productStatus = false ;
            } else {
                System.err.println("Trang thai ban hang chua hop le . Vui long nhap lai ❤");
            }
        }


        this.exportPrice = this.importPrice * RATE ;

        while (true) {
            boolean isExist = false ;
            if ( listCatalog.isEmpty()) {
                System.err.println("Danh muc san pham dang rong");
                createCatalog() ;
                break;
            } else {
                getAllCatalog();
                System.out.println("Chon danh muc san pham");
                String nameCatalog = sc.nextLine();
                for ( Catalog newCatalog : listCatalog) {
                    if (newCatalog.getCatalogName().equalsIgnoreCase(nameCatalog)) {
                        this.catalog = newCatalog;
                        isExist = true ;
                        break;
                    }
                }
                if (isExist) {
                   break;
                } else {
                    System.err.println("Khong ton tai danh muc trong danh sach");
                }

            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("_________ THONG TIN SAN PHAM __________");
        System.out.println("Id : " + productId);
        System.out.println("Ten san pham : " + productName);
        System.out.println("Tieu de san pham : " + title);
        System.out.println("Mo ta san pham : " + descriptions);
        System.out.println("San pham thuoc nhom :  " + catalog.getCatalogName());
        System.out.println("Gia nhap vao : " + importPrice + " VND");
        System.out.println("Trang thai : " + (productStatus?"Mo ban":"Khong ban"));
    }

    public static void getAllCatalog() {
        for (Catalog catalog1 : listCatalog) {
            catalog1.displayData();
        }
    }

    public static void getAllProduct(){
        for (Product product: listProduct) {
            product.displayData();
        }
    }

}
