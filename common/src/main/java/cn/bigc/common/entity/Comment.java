package cn.bigc.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author th1nk
 * {@code @date} 2022/9/8 下午8:15
 */
@Data
@TableName("message")
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 评论者昵称
     */
    private String name;

    /**
     * 评论内容
     */
    private String message;

    /**
     * 活动ID
     */
    @TableField("activity_id")
    private Integer activity_id;

}
