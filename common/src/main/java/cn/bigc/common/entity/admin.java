package cn.bigc.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author th1nk
 * {@code @date} 2022/9/8 下午7:35
 */
@TableName("admin")
@Data
public class admin {
    /**
     * 主键ID
     */
    @TableId
    private Integer id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户名,唯一
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public void hidePassword() {
        this.password = "";
    }
}
