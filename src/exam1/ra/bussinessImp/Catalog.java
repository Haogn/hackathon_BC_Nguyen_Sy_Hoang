package exam1.ra.bussinessImp;

import exam1.ra.bussiness.ISHop;
import static exam1.ra.run.ProductManagement.*;

public class Catalog implements ISHop {
    private static int nextId = 1;
    private int catalogId ;
    private String catalogName ;
    private int priority ;
    private String descriptions ;
    private boolean catalogStatus ;
    public Catalog() {
        this.catalogId = nextId ++ ;
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Catalog.nextId = nextId;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        // ten danh muc
        while (true) {
            System.out.println("Nhap vao ten danh muc ");
            String name = sc.nextLine() ;
            if (listCatalog.isEmpty()) {
                if (name.isEmpty()) {
                    System.err.println("Ten danh muc khong dc de rong");
                } else {
                    this.catalogName = name ;
                    break;
                }
            } else {
                boolean isExist = false ;
                for (int i = 0; i < listCatalog.size(); i++) {
                    if (listCatalog.get(i).getCatalogName().equals(name)) {
                        System.err.println("Ten san pham da co trong danh sach . Vui long nhap lai ❤");
                        isExist = true ;
                        break;
                    }
                }
                if (!isExist) {
                    this.catalogName =name ;
                    break;
                }
            }
        }
        // do uu tien
        while (true) {
            System.out.println("Nhap vao do uu tien");
            int uu = Integer.parseInt(sc.nextLine()) ;
            if ( uu <= 0 ) {
                System.err.println("Do uu tien khong the nho hon 0 . Vui long nhap lai ❤");
            } else {
                this.priority = uu  ;
                break;
            }
        }
        // mo ta danh muc
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

        // trang thai
        while (true) {
            System.out.println("Trang thai danh muc : ( Co / Khong )  ");
            String tt = sc.nextLine();
            if ( tt.equalsIgnoreCase("co")) {
                this.catalogStatus = true ;
                break;
            } else if (tt.equalsIgnoreCase("khong")) {
                this.catalogStatus = false ;
                break;
            } else {
                System.err.println("trang thai ban hang khong dung . Vui long nhap lai ❤");
            }
        }

    }

    @Override
    public void displayData() {
        System.out.println("__________ THONG TIN DANH MUC ___________");
        System.out.println("Id : " + catalogId);
        System.out.println("Ten danh muc : " + catalogName);
        System.out.println("Do uu tien : " + priority);
        System.out.println("Mo ta danh muc : " + descriptions);
        System.out.println("Trang thai : " + catalogStatus);
    }
}
