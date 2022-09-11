package cn.bigc.admin.dto;

import lombok.Data;

/**
 * @author th1nk
 * {@code @date} 2022/9/10 下午1:16
 */
@Data
public class LoginDto {
    private String username;
    private String password;
    private String verkey;
    private String vercode;

    public boolean isNotNull() {
        if (username == null || username.equals("")) return false;
        if (password == null || password.equals("")) return false;
        if (verkey == null || verkey.equals("")) return false;
        return vercode != null && !vercode.equals("");
    }
}
