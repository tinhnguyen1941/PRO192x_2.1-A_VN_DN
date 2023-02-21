public class Department {
    private String maBoPhan;
    private int tenBoPhan;
    private int soLuongNhanVien;
    public Department(String maBoPhan, int tenBoPhan,int soLuongNhanVien){
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVien = soLuongNhanVien;
    }
    public String getMaBoPhan(){
        return maBoPhan;
    }
    public int getSoLuongNhanVien(){
        return soLuongNhanVien;
    }
    public void setSoLuongNhanVien(int soLuongNhanVien){
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public void setTenBoPhan(int tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getTenBoPhan(){
        return tenBoPhan;
    }
    public String toString(){
        String tenBP = "";
        if (getTenBoPhan() == 1){
            tenBP = "Hành chính nhân sự";
        } else if (getTenBoPhan() == 2) {
            tenBP = "Công nghệ thông tin";
        } else {tenBP = "Marketing";}
        return String.format("%-13s | %-24s | %-11d", getMaBoPhan(), tenBP, getSoLuongNhanVien());
    }

}
