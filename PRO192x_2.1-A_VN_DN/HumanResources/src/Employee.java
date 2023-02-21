public class Employee extends Staff implements ICalculator {
    private double soGioLamThem;
    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam, int boPhanLamViec, int soNgayNghiPhep, Double soGioLamThem){
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }
    public Double getSoGioLamThem(){
        return soGioLamThem;
    }
    public void displayInformation(){
        String leftAlignFormat ="%-14s | %-21s | %-4d | %-11f | %-14s | %-15s |  %-20s | %-25s | %-15f %n";
        String boPhanDoi = "";
        if(getBoPhanLamViec() == 1){
            boPhanDoi = "Hành chính nhân sự";
        }
        else if (getBoPhanLamViec() == 2){
            boPhanDoi = "Công nghệ thông tin";
        }
        else {
            boPhanDoi = "Marketing";
        }
        System.out.format(leftAlignFormat, super.getMaNhanVien(), super.getTenNhanVien(), super.getTuoiNhanVien(), super.getHeSoLuong(), super.getNgayVaoLam(), super.getSoNgayNghiPhep(), boPhanDoi, getSoGioLamThem(), calculateSalary());
    }
    public double calculateSalary(){
        return getHeSoLuong() * 3000000 + soGioLamThem * 200000;
    }
}
