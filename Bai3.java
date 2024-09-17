import java.util.Scanner;

class address {
    private String streetaddress;
    private String city;
    private String state;
    private long zipcode;

    public address(String streetaddress, String city, String state, long zipcode) {
        this.streetaddress = streetaddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return streetaddress + ", " + city + ", " + state + " " + zipcode;
    }
}

class student {
    private String firstname;
    private String lastname;
    private address homeaddress;
    private address schooladdress;

    public student(String firstname, String lastname, address homeaddress, address schooladdress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.homeaddress = homeaddress;
        this.schooladdress = schooladdress;
    }

    @Override
    public String toString() {
        return "student: " + firstname + " " + lastname + "\nhome address: " + homeaddress + "\nschool address: " + schooladdress;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap thong tin dia chi nha:");
        System.out.print("duong: ");
        String homeStreet = scanner.nextLine();
        System.out.print("thanh pho: ");
        String homeCity = scanner.nextLine();
        System.out.print("tieu bang: ");
        String homeState = scanner.nextLine();
        System.out.print("ma buu dien: ");
        long homeZipcode = scanner.nextLong();
        scanner.nextLine();
        System.out.println("\nnhap thong tin dia chi truong:");
        System.out.print("duong: ");
        String schoolStreet = scanner.nextLine();
        System.out.print("thanh pho: ");
        String schoolCity = scanner.nextLine();
        System.out.print("tieu bang: ");
        String schoolState = scanner.nextLine();
        System.out.print("ma buu dien: ");
        long schoolZipcode = scanner.nextLong();
        scanner.nextLine();
        System.out.println("\nnhap thong tin sinh vien:");
        System.out.print("ho: ");
        String firstname = scanner.nextLine();
        System.out.print("ten: ");
        String lastname = scanner.nextLine();
        address homeAddress = new address(homeStreet, homeCity, homeState, homeZipcode);
        address schoolAddress = new address(schoolStreet, schoolCity, schoolState, schoolZipcode);
        student student = new student(firstname, lastname, homeAddress, schoolAddress);
        System.out.println("\nthong tin sinh vien da nhap:");
        System.out.println(student);
        scanner.close();
    }
}
