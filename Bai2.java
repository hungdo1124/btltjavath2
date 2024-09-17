import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class monhoc {
    private String mamon;
    private String tenmon;
    private int sotinchi;

    public monhoc(String mamon, String tenmon, int sotinchi) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.sotinchi = sotinchi;
    }

    public String getMamon() {
        return mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public int getSotinchi() {
        return sotinchi;
    }
}

class tinchi extends monhoc {
    private double diemthanhphan;
    private double diemthi;

    public tinchi(String mamon, String tenmon, int sotinchi, double diemthanhphan, double diemthi) {
        super(mamon, tenmon, sotinchi);
        this.diemthanhphan = diemthanhphan;
        this.diemthi = diemthi;
    }

    public double tinhdiemtongket() {
        return 0.3 * diemthanhphan + 0.7 * diemthi;
    }
}

class sinhvien {
    private String masinhvien;
    private String hoten;
    private int sotinchidadangky;
    private ArrayList<tinchi> danhsachtinchi = new ArrayList<>();

    public sinhvien(String masinhvien, String hoten, int sotinchidadangky) {
        this.masinhvien = masinhvien;
        this.hoten = hoten;
        this.sotinchidadangky = sotinchidadangky;
    }

    public void themtinchi(tinchi tinchi) {
        danhsachtinchi.add(tinchi);
    }

    public double tinhdiemtrungbinh() {
        double tongdiem = 0;
        int tongtinchi = 0;
        for (tinchi tc : danhsachtinchi) {
            tongdiem += tc.tinhdiemtongket() * tc.getSotinchi();
            tongtinchi += tc.getSotinchi();
        }
        return tongdiem / tongtinchi;
    }

    public String getMasinhvien() {
        return masinhvien;
    }

    public String getHoten() {
        return hoten;
    }

    public double getDiemtrungbinh() {
        return tinhdiemtrungbinh();
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<sinhvien> danhsachsinhvien = new ArrayList<>();
        System.out.print("nhap so luong sinh vien: ");
        int soluongsinhvien = scanner.nextInt();
        scanner.nextLine();  // doc bo dong trong
        for (int i = 0; i < soluongsinhvien; i++) {
            System.out.print("nhap ma sinh vien: ");
            String masinhvien = scanner.nextLine();
            System.out.print("nhap ho ten sinh vien: ");
            String hoten = scanner.nextLine();
            System.out.print("nhap so luong tin chi da dang ky: ");
            int sotinchi = scanner.nextInt();
            scanner.nextLine();  // doc bo dong trong
            sinhvien sv = new sinhvien(masinhvien, hoten, sotinchi);
            for (int j = 0; j < sotinchi; j++) {
                System.out.print("nhap ma mon hoc: ");
                String mamon = scanner.nextLine();
                System.out.print("nhap ten mon hoc: ");
                String tenmon = scanner.nextLine();
                System.out.print("nhap so tin chi: ");
                int tinchi = scanner.nextInt();
                System.out.print("nhap diem thanh phan: ");
                double diemthanhphan = scanner.nextDouble();
                System.out.print("nhap diem thi: ");
                double diemthi = scanner.nextDouble();
                scanner.nextLine();  // doc bo dong trong

                tinchi tc = new tinchi(mamon, tenmon, tinchi, diemthanhphan, diemthi);
                sv.themtinchi(tc);
            }

            danhsachsinhvien.add(sv);
        }
        System.out.println("\ndanh sach sinh vien:");
        for (sinhvien sv : danhsachsinhvien) {
            System.out.println("ma sv: " + sv.getMasinhvien() + ", ho ten: " + sv.getHoten() + ", diem trung binh: " + sv.getDiemtrungbinh());
        }
        System.out.println("\nsinh vien loai trung binh (dtk < 6):");
        for (sinhvien sv : danhsachsinhvien) {
            if (sv.getDiemtrungbinh() < 6) {
                System.out.println("ma sv: " + sv.getMasinhvien() + ", ho ten: " + sv.getHoten() + ", diem tb: " + sv.getDiemtrungbinh());
            }
        }
        System.out.println("\nsinh vien loai kha (6 <= dtk < 8):");
        for (sinhvien sv : danhsachsinhvien) {
            if (sv.getDiemtrungbinh() >= 6 && sv.getDiemtrungbinh() < 8) {
                System.out.println("ma sv: " + sv.getMasinhvien() + ", ho ten: " + sv.getHoten() + ", diem tb: " + sv.getDiemtrungbinh());
            }
        }
        System.out.println("\nsinh vien loai gioi (dtk >= 8):");
        for (sinhvien sv : danhsachsinhvien) {
            if (sv.getDiemtrungbinh() >= 8) {
                System.out.println("ma sv: " + sv.getMasinhvien() + ", ho ten: " + sv.getHoten() + ", diem tb: " + sv.getDiemtrungbinh());
            }
        }
        Collections.sort(danhsachsinhvien, new Comparator<sinhvien>() {
            @Override
            public int compare(sinhvien sv1, sinhvien sv2) {
                return Double.compare(sv2.getDiemtrungbinh(), sv1.getDiemtrungbinh());
            }
        });
        System.out.println("\ndanh sach sinh vien theo thu tu giam dan cua diem trung binh:");
        for (sinhvien sv : danhsachsinhvien) {
            System.out.println("ma sv: " + sv.getMasinhvien() + ", ho ten: " + sv.getHoten() + ", diem tb: " + sv.getDiemtrungbinh());
        }

        scanner.close();
    }
}
