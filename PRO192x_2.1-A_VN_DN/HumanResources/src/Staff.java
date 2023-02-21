public  abstract class Staff {
    private String maNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private double heSoLuong;
    private String ngayVaoLam;
    private int boPhanLamViec;
    private int soNgayNghiPhep;
    public Staff(String maNhanVien, String tenNhanVien, int tuoiNhanVien, double heSoLuong, String ngayVaoLam, int boPhanLamViec, int soNgayNghiPhep){
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.heSoLuong = heSoLuong;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhanLamViec  = boPhanLamViec;
        this.soNgayNghiPhep = soNgayNghiPhep;
    }
    public abstract void displayInformation();
    public Double getHeSoLuong(){
        return heSoLuong;
    }
    public void setHeSoLuong(double heSoLuong){
        this.heSoLuong = heSoLuong;
    }
    public String getMaNhanVien(){
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien){
        this.maNhanVien = maNhanVien;
    }
    public String getTenNhanVien(){
        return tenNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien){
        this.tenNhanVien = tenNhanVien;
    }
    public int getTuoiNhanVien(){
        return tuoiNhanVien;
    }
    public void setTuoiNhanVien(int  tuoiNhanVien){
        this.tuoiNhanVien = tuoiNhanVien;
    }
    public String getNgayVaoLam(){
        return ngayVaoLam;
    }
    public void setNgayVaoLam(String ngayVaoLam){
        this.ngayVaoLam = ngayVaoLam;
    }
    public int getBoPhanLamViec(){
        return boPhanLamViec;
    }
    public void setBoPhanLamViec(int boPhanLamViec){
        this.boPhanLamViec = boPhanLamViec;
    }
    public int getSoNgayNghiPhep(){
        return soNgayNghiPhep;
    }
    public void setSoNgayNghiPhep(int soNgayNghiPhep){
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

}