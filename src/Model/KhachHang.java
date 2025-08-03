package Model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    private String maKH;
    private String hoTen;
    private double tongChiTieu;
    private String matKhau;
    private String anh;
    private String email;
    private String HangKhach;
    @Builder.Default
    private VaiTro vt = new VaiTro(); // Mặc định có VaiTro mới

    // Tính hạng khách theo chi tiêu
    public String getHangKhach() {
        if (tongChiTieu >= 60000000) {
            return "Kim Cương";
        } else if (tongChiTieu >= 45000000) {
            return "Vàng";
        } else if (tongChiTieu >= 30000000) {
            return "Bạc";
        } else if (tongChiTieu >= 15000000) {
            return "Thanh toán nhiều";
        } else {
            return "Thường";
        }
    }

    // Getter & Setter cho VaiTro (ẩn trong class KhachHang)
    public String getTenVaiTro() {
        return vt.getTenVaiTro();
    }

    public void setTenVaiTro(String tenVaiTro) {    
        vt.setTenVaiTro(tenVaiTro);
    }

    public int getMaVaiTro() {
        return vt.getMaVaiTro();
    }

    public void setMaVaiTro(int maVaiTro) {
        vt.setMaVaiTro(maVaiTro);
    }


}
