public class Manager extends Staff implements ICalculator{
    private int chucDanh;
    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam, int boPhanLamViec, int soNgayNghiPhep, int chucDanh){
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.chucDanh = chucDanh;
    }
    public int getChucDanh(){
        return chucDanh;
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
        String chucDanhDoi = "";
        if(getChucDanh() == 1){
            chucDanhDoi = "Business Leader";
        } else if(getChucDanh() == 2){
            chucDanhDoi = "Project Leader";
        } else {
            chucDanhDoi = "Technical Leader";
        }
        System.out.format(leftAlignFormat, super.getMaNhanVien(), super.getTenNhanVien(), super.getTuoiNhanVien(), super.getHeSoLuong(), super.getNgayVaoLam(), super.getSoNgayNghiPhep(), boPhanDoi, chucDanhDoi, calculateSalary());
    }
    public double calculateSalary(){
        double luong = 0;
        if (chucDanh == 1){
           luong = getHeSoLuong() * 5000000 + 8000000;
        }
        if(chucDanh == 2){
            luong = getHeSoLuong() * 5000000 + 5000000;
        }
        if(chucDanh == 3){
            luong = getHeSoLuong() * 5000000 + 6000000;
        }
        return luong;
    }
}