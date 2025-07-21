package Util;

import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author baoha
 */
public class UHash {

    // Tạo chuỗi mã hóa ngẫu nhiên (không giải mã được)
    public static String randomHash(String password) {
        byte[] randomBytes = new byte[24]; 
        SecureRandom random = new SecureRandom();
        random.nextBytes(randomBytes);
        return Base64.getEncoder().encodeToString(randomBytes);
    }

    // Dùng để lưu đúng mật khẩu thực tế (mã hóa để so sánh)
    public static String encodePassword(String password) {
        String secret = "mykey"; // bạn có thể đổi
        String merged = password + secret;
        return Base64.getEncoder().encodeToString(merged.getBytes());
    }

    // Kiểm tra mật khẩu nhập vào có khớp không
    public static boolean match(String inputPassword, String storedEncodedPassword) {
        return encodePassword(inputPassword).equals(storedEncodedPassword);
    }
}
