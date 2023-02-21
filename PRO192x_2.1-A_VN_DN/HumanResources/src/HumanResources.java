import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class HumanResources {
    public static ArrayList <Staff> arrNhanVien = new ArrayList<>();
    public static ArrayList <Department> arrBoPhan = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        Employee employee1 = new Employee("E001", "Nguyễn Thị Kim Ly", 32, 2.3, "01/04/2022", 3, 5, 4.0);
        Employee employee2 = new Employee("E002", "Nguyễn Thị Thanh Thảo", 31, 3.2, "01/04/2021", 1, 5, 4.0);
        Manager employee3 = new Manager("E003", "Nguyễn Duy Tình", 35, 5.0, "02/04/2022", 2, 5, 1);
        Manager employee4 = new Manager("E004", "Nguyễn Đức Thanh", 30, 5.2,"20/08/2022", 2, 5, 1);
        arrNhanVien.add(employee1);
        arrNhanVien.add(employee2);
        arrNhanVien.add(employee3);
        arrNhanVien.add(employee4);
        Department department1 = new Department("HC", 1, 0);
        Department department2 = new Department("IT", 2, 0);
        Department department3 = new Department("MKT", 3, 0);
        arrBoPhan.add(department1);
        arrBoPhan.add(department2);
        arrBoPhan.add(department3);
        boolean run = true;
        // Trong khi biến run là true thì chương trình luôn chạy, ngược lại dừng chương trình
        while (run){
            System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
            System.out.println("2. Hiển thị các bộ phận trong công ty.");
            System.out.println("3. Hiển thị các nhân viên theo từng bộ phận.");
            System.out.println("4. Thêm nhân viên mới vào công ty.");
            System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã khách hàng.");
            System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
            System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
            System.out.println("0. Thoát khỏi chương trình.");
            System.out.print("Lựa chọn của bạn: ");
            int luaChon = sc.nextInt();
        // Các trường hợp của biến luaChon:
            switch (luaChon){
                case 1: {
                    // In thông tin đây đủ của nhân viên:
                    System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                    System.out.format("------------------------------------------------------------------------------------------------------------------------------------------------------------%n");
                    // Duyệt qua từng nhân viên trong mảng và in ra màng hình bằng cách gọi hàm display:
                    for (int i = 0; i < arrNhanVien.size(); i++){
                        arrNhanVien.get(i).displayInformation();
                    }
                    break;
                }
                case 2: {
                    System.out.format("Mã bộ phận    | Tên bộ phận              | Số lượng nhân viên hiện tại%n");
                    // Duyệt vòng lặp thứ nhất của mảng arrBoPhan để lấy từng phần tử đi so sánh với từng phần tử của mảng arrNhanVien bằng vòng lặp th 2
                    // sau dó nếu trùng nhau thì tăng số lượng nhân viên của từng phần từ arrBoPhan lên 1:
                    for (int i = 0; i <arrBoPhan.size(); i++){
                        for(int j = 0; j <arrNhanVien.size(); j++){
                            if(arrBoPhan.get(i).getTenBoPhan() == arrNhanVien.get(j).getBoPhanLamViec()){
                                arrBoPhan.get(i).setSoLuongNhanVien(arrBoPhan.get(i).getSoLuongNhanVien() + 1);
                            }
                        }
                    // In ra thông tin của từng phòng ban với phương thức toString đã được ghi đè:
                        System.out.println(arrBoPhan.get(i));
                    // Reset lại số lượng nhân viên của từng phòng ban mỗi khi chọn chức năng này, để đảm bảo khi chọn lại lần tiếp theo ko bị double
                    // số lượng nhân viên lên.
                        arrBoPhan.get(i).setSoLuongNhanVien(0);
                    }
                    break;
                }
                case 3: {
                    // Dùng vòng lặp và câu lệnh if để hiển thị tên bộ phận đầy đủ, sau đó dùng vòng lặp thứ 2 để hiển thị thông tin của từng nhân viên
                    for(int j = 0; j < arrBoPhan.size(); j++){
                        System.out.println();
                        if(arrBoPhan.get(j).getTenBoPhan() == 1){
                            System.out.println("Hành chính nhân sự");
                        } else if(arrBoPhan.get(j).getTenBoPhan() == 2){
                            System.out.println("Công nghệ thông tin");
                        } else {
                            System.out.println("Marketing");
                        }
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                        for(int i = 0; i < arrNhanVien.size(); i++){
                            if(arrNhanVien.get(i).getBoPhanLamViec() == j+1){
                                arrNhanVien.get(i).displayInformation();
                            }
                        }
//
                    }
                    break;
                }
                case 4: {

                    System.out.println("1. Thêm nhân viên thông thường.");
                    System.out.println(("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ.)"));
                    int luaChonThemNhanVien;
                    do {
                        System.out.print("Bạn chọn: ");
                        luaChonThemNhanVien = sc.nextInt();
                    } while (luaChonThemNhanVien < 1 || luaChonThemNhanVien > 2); // Đảm bảo người dùng chỉ được nhập 1 hoăc 2.
                    if (luaChonThemNhanVien == 1){
                        themNhanVien(); // Gọi hàm thêm nhân viên nếu lựa chọn 1.
                    } else {
                        themQuanLy(); // Gọi hàm thêm quản lý nếu lựa chọn 2.
                    }
                    break;
                }
                case 5: {
                    System.out.println("1. Tìm nhân viên bằng tên: ");
                    System.out.println("2. Tìm nhân viên bằng mã nhân viên: ");
                    int luaChonTimKiemNhanVien;
                    do {
                        System.out.print("Bạn chọn: ");
                        luaChonTimKiemNhanVien = sc.nextInt();
                    }while (luaChonTimKiemNhanVien < 1 || luaChonTimKiemNhanVien > 2); // Đảm bảo người dùng chỉ được chọn 1 hoặc 2

                    if(luaChonTimKiemNhanVien == 1){
                        System.out.println("Nhập tên nhân viên cần tìm: ");
                        String in = sc.next();
                        String kyTuDauTien = in.substring(0,1).toUpperCase(); // tách ký tự đầu để viết hoa lên.
                        String kyTuConLai = in.substring(1,in.length()); // phần ký tự còn lại từ vị trí 1 về sau giữ nguyên
                        String tenHoacMaNhanVien = kyTuDauTien + kyTuConLai; // nối 2 chuỗi này lại sau khi đã viết hoa chữ cái đầu tiên.
                        System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                        for(int i = 0; i < arrNhanVien.size(); i++){
                            // nếu người nhập kết quả mong muốn vào thì chương trình sẽ duyệt từng nhân viên để lấy tên hoặc mã so sánh có chứa kết quả của người nhập vào không?
                            // nếu có thì hiển thị thông tin đầy đủ.
                            if(arrNhanVien.get(i).getTenNhanVien().contains(tenHoacMaNhanVien)){
                                arrNhanVien.get(i).displayInformation();
                            }
                        }
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    } else {
                        System.out.println("Nhập mã nhân viên cần tìm: ");
                        String in = sc.next();
                        String kyTuDauTien = in.substring(0,1).toUpperCase(); // tách ký tự đầu để viết hoa lên.
                        String kyTuConLai = in.substring(1,in.length()); // phần ký tự còn lại từ vị trí 1 về sau giữ nguyên
                        String tenHoacMaNhanVien = kyTuDauTien + kyTuConLai; // nối 2 chuỗi này lại sau khi đã viết hoa chữ cái đầu tiên.
                        System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                        for(int i = 0; i < arrNhanVien.size(); i++){
                            // nếu người nhập kết quả mong muốn vào thì chương trình sẽ duyệt từng nhân viên để lấy tên hoặc mã so sánh có chứa kết quả của người nhập vào không?
                            // nếu có thì hiển thị thông tin đầy đủ.
                            if(arrNhanVien.get(i).getMaNhanVien().contains(tenHoacMaNhanVien)){
                                arrNhanVien.get(i).displayInformation();
                            }
                        }
                        System.out.println();
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                    break;
                }
                case 6: {
                // Sắp xếp theo thứ tự lương giảm dần:
//                    for(int j = 0; j < arrNhanVien.size() - 1; j++){
//                        for(int k = j + 1; k < arrNhanVien.size(); k++){
//                            Staff emp = arrNhanVien.get(k);
//                            if (((ICalculator) arrNhanVien.get(j)).calculateSalary() < ((ICalculator) arrNhanVien.get(k)).calculateSalary()){
//                                emp = arrNhanVien.get(k);
//                                arrNhanVien.set(k, arrNhanVien.get(j));
//                                arrNhanVien.set(j, emp);
//                            }
//                        }
//                    }
                // Sử dụng Collection để ghi đè phương thức so sánh compare có sẵn của Java:
                    Collections.sort(arrNhanVien, new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            if(((ICalculator) o1).calculateSalary() < ((ICalculator)o2).calculateSalary()){ // CastDown phương thức tính lương từ inerfacr
                                return 1;
                            } else if (((ICalculator) o1).calculateSalary() > ((ICalculator)o2).calculateSalary()){// CastDown phương thức tính lương từ inerfacr
                                return  -1;
                            }
                            return 0;
                        };
                    });
                    System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                    // Chạy vòng lặp và in thông tin từng nhân  viên theo thứ tự giảm dần:
                    for (int n = 0; n < arrNhanVien.size(); n++ ){
                        arrNhanVien.get(n).displayInformation();
                    }

                break;
                }
                case 7: {
                        // Sắp xếp theo thứ tự lương tăng dần:
                    // Sử dụng Collection để ghi đè phương thức so sánh compare có sẵn của Java:
                    Collections.sort(arrNhanVien, new Comparator<Staff>() {
                        @Override
                        public int compare(Staff o1, Staff o2) {
                            if(((ICalculator) o1).calculateSalary() > ((ICalculator)o2).calculateSalary()){// CastDown phương thức tính lương từ inerfacr
                                return 1;
                            } else if (((ICalculator) o1).calculateSalary() < ((ICalculator)o2).calculateSalary()) {// CastDown phương thức tính lương từ inerfacr
                                return  -1;
                            }
                            return 0;
                        };
                    });
                    System.out.format("Mã nhân viên   | Tên nhân viên         | Tuổi | HS Lương    | Ngày vào làm   | Ngày nghỉ phép  | Bộ Phận               | Số giờ làm việc/Chức danh | Lương          %n");
                    // Chạy vòng lặp và in thông tin từng nhân  viên theo thứ tự tăng dần:
                    for (int n = 0; n < arrNhanVien.size(); n++ ){
                        arrNhanVien.get(n).displayInformation();
                    }

                break;
                }
                case 0: {
                    run = false; // biên run sai thì chương trình sẽ dừng.
                    break;
                }
                default:
                    System.out.println("VUI LÒNG NHẬP SÓ TỪ 0 ĐẾN 7."); // Nếu người dùng chọn số khác vùng chọn này thì thông báo sẽ hiện lên.
            }
        }
    }
    public static void themNhanVien(){
        System.out.print("Nhập mã nhân viên: ");
        sc.nextLine();
        String maNhanVien = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String tenNhanVien = sc.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        String tuoi = sc.nextLine();
        int tuoiNhanVien = Integer.parseInt(tuoi);
        System.out.print("Nhập hệ số luong của nhân viên: ");
        String he = sc.nextLine();
        double heSoLuong = Double.parseDouble(he);
        System.out.print("Nhập ngày vào làm của nhân viên: ");
        String ngayVaoLam = sc.next();
        System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
        int soNgayNghiPhep = sc.nextInt();
        System.out.println("1. HC - Hành chính nhân sự");
        System.out.println("2. IT - Công nghệ thông tin");
        System.out.println("3. MKT - Marketing");
        int boPhanLamViec;
        do{
            System.out.print("Bạn chọn bộ phận: ");
            boPhanLamViec = sc.nextInt();
        }while (boPhanLamViec < 1 || boPhanLamViec > 3);// Đảm bảo người dùng chỉ được nhập từ 1 tới 3.
        sc.nextLine();
        System.out.print("Nhập số giờ làm thêm của nhân viên: ");
        String gio = sc.nextLine();
        double soGioLamThem = Double.parseDouble(gio);
        Employee employee = new Employee(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, soGioLamThem);
        arrNhanVien.add(employee); // Sau khi thêm nhân viên thì arrNhanVien cũng tự cập nhật tăng thêm.
    }
    public static void  themQuanLy(){
        System.out.print("Nhập mã nhân viên: ");
        sc.nextLine();
        String maNhanVien = sc.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String tenNhanVien = sc.nextLine();
        System.out.print("Nhập tuổi nhân viên: ");
        String tuoi = sc.nextLine();
        int tuoiNhanVien = Integer.parseInt(tuoi);
        System.out.print("Nhập hệ số luong của nhân viên: ");
        String he = sc.nextLine();
        double heSoLuong = Double.parseDouble(he);
        System.out.print("Nhập ngày vào làm của nhân viên: ");
        String ngayVaoLam = sc.next();
        System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
        int soNgayNghiPhep = sc.nextInt();
        System.out.println("1. HC - Hành chính nhân sự");
        System.out.println("2. IT - Công nghệ thông tin");
        System.out.println("3. MKT - Marketing");
        int boPhanLamViec;
        do{
            System.out.print("Bạn chọn bộ phận: ");
            boPhanLamViec = sc.nextInt();
        }while (boPhanLamViec < 1 || boPhanLamViec > 3); // Đảm bảo người dùng chỉ được nhập từ 1 tới 3.
        sc.nextLine();
        System.out.println("Chức danh: ");
        System.out.println("1. Business Leader");
        System.out.println("2. Project Leader");
        System.out.println("3. Technical Leader");
        int chucDanh;
        do {
            System.out.print("Nhập chức danh: ");
            chucDanh = sc.nextInt();
        }while (chucDanh < 1 || chucDanh > 3); // Đảm bảo người dùng chỉ được nhập từ 1 tới 3.
        Manager employee = new Manager(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, chucDanh);
        arrNhanVien.add(employee); // Sau khi thêm nhân viên thì arrNhanVien cũng tự cập nhật tăng thêm.
    }
}
