package Util;

import java.security.MessageDigest;

public class UHash {

    // Mã hóa mật khẩu bằng MD5
    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes("UTF-8"));

            // Chuyển byte thành chuỗi hex
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (Exception e) {
            System.err.println("️ Lỗi khi mã hóa MD5: " + e.getMessage());
            return null;
        }
    }



    // So sánh mật khẩu khi đăng nhập
    public static boolean match(String inputPassword, String encryptedFromDatabase) {
        String hashedInput = encrypt(inputPassword);
        return hashedInput != null && hashedInput.equals(encryptedFromDatabase);
    }
}
