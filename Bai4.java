import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private String loaiPhong;
    private int giaPhong;
    private int soNgayO;

    public Room(String loaiPhong, int giaPhong, int soNgayO) {
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.soNgayO = soNgayO;
    }

    public int tinhTienPhong() {
        return giaPhong * soNgayO;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public int getSoNgayO() {
        return soNgayO;
    }
}

class Khach {
    private String ten;
    private String diaChi;
    private Room phong;
    private boolean internet;
    private boolean nuocNong;
    private boolean karaoke;
    private boolean anSang;

    public Khach(String ten, String diaChi, Room phong, boolean internet, boolean nuocNong, boolean karaoke, boolean anSang) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.phong = phong;
        this.internet = internet;
        this.nuocNong = nuocNong;
        this.karaoke = karaoke;
        this.anSang = anSang;
    }

    public int tinhTienDichVu() {
        int tienDichVu = 0;
        if (internet) {
            tienDichVu += 10000;
        }
        if (nuocNong) {
            tienDichVu += 10000;
        }
        if (karaoke) {
            tienDichVu += 50000;
        }
        if (anSang) {
            tienDichVu += 15000;
        }
        return tienDichVu;
    }

    public int tinhTongTien() {
        return phong.tinhTienPhong() + tinhTienDichVu();
    }

    public void hienThiThongTin() {
        System.out.println("Khach: " + ten);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Loai phong: " + phong.getLoaiPhong());
        System.out.println("So ngay o: " + phong.getSoNgayO());
        System.out.println("Tien phong: " + phong.tinhTienPhong() + " VND");
        System.out.println("Tien dich vu: " + tinhTienDichVu() + " VND");
        System.out.println("Tong tien: " + tinhTongTien() + " VND");
        System.out.println();
    }

    public int layTongTien() {
        return tinhTongTien();
    }
}

public class Bai4 {
    private static int tongLuotKhach = 0;
    private static int tongTienThu = 0;
    private static ArrayList<Khach> danhSachKhach = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong khach hang: ");
        int soKhach = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < soKhach; i++) {
            System.out.println("\nNhap thong tin khach hang " + (i + 1) + ":");
            System.out.print("Nhap ten: ");
            String ten = scanner.nextLine();
            System.out.print("Nhap dia chi: ");
            String diaChi = scanner.nextLine();
            System.out.println("Chon loai phong (1: Phong don, 2: Phong doi, 3: Phong ba): ");
            int loaiPhong = scanner.nextInt();
            int giaPhong = 0;
            String tenPhong = "";
            switch (loaiPhong) {
                case 1:
                    giaPhong = 300000;
                    tenPhong = "Phong don";
                    break;
                case 2:
                    giaPhong = 350000;
                    tenPhong = "Phong doi";
                    break;
                case 3:
                    giaPhong = 400000;
                    tenPhong = "Phong ba";
                    break;
                default:
                    System.out.println("Loai phong khong hop le.");
                    return;
            }
            System.out.print("Nhap so ngay o: ");
            int soNgayO = scanner.nextInt();
            Room phong = new Room(tenPhong, giaPhong, soNgayO);
            System.out.println("Co su dung internet (true/false): ");
            boolean internet = scanner.nextBoolean();
            System.out.println("Co su dung nuoc nong (true/false): ");
            boolean nuocNong = scanner.nextBoolean();
            System.out.println("Co su dung karaoke (true/false): ");
            boolean karaoke = scanner.nextBoolean();
            System.out.println("Co su dung an sang (true/false): ");
            boolean anSang = scanner.nextBoolean();
            scanner.nextLine();
            Khach khach = new Khach(ten, diaChi, phong, internet, nuocNong, karaoke, anSang);
            danhSachKhach.add(khach);
            tongLuotKhach++;
        }
        System.out.println("\nThong tin tat ca khach hang da nhap:");
        for (Khach khach : danhSachKhach) {
            khach.hienThiThongTin();
            tongTienThu += khach.layTongTien();
        }
        System.out.println("Tong ket:");
        System.out.println("Tong so luot khach: " + tongLuotKhach);
        System.out.println("Tong so tien thu: " + tongTienThu + " VND");
        scanner.close();
    }
}
