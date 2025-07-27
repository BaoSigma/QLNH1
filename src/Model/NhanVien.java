package Model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {
    private String MaNV;
    private String HoTen;
    private String MatKhau;
    private String Email;
    private double LuongCoBan;
    private Date NgaySinh;
    private String Anh;

    @Builder.Default
    private VaiTro vt = new VaiTro();

    // Getter/Setter cho VaiTro
    public String getTenVaiTro() {
        return vt.getTenVaiTro();
    }

    public void setTenVaiTro(String TenVaiTro) {
        vt.setTenVaiTro(TenVaiTro);
    }

    public int getMaVaiTro() {
        return vt.getMaVaiTro();
    }

    public void setMaVaiTro(int MaVaiTro) {
        vt.setMaVaiTro(MaVaiTro);
    }
}
