package cn.bigc.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author th1nk
 * {@code @date} 2022/9/8 下午8:10
 */
@Data
@TableName("activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @TableId
    private Integer id;

    /**
     * 活动开始时间
     */
    @TableField("start_name")
    private Timestamp start_time;

    /**
     * 活动结束时间
     */
    @TableField("end_time")
    private Timestamp end_time;

    /**
     * 活动创建时间
     */
    @TableField("create_time")
    private Timestamp create_time;

    /**
     * 活动发起者
     */
    private String creater;

    /**
     * 活动内容
     */
    private String content;

}
