package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 身份验证表
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@TableName("sys_identity")
@Data
public class IdentityDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号码
     */
    private String rankIdCard;

    /**
     * 图片
     */
    private String rankImg;

    /**
     * 真实姓名
     */
    private String rankName;

    /**
     * 用户
     */
    private Integer rankUserId;

    /**
     * top点
     */
    private Integer rankSiteId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    @Override
    public String toString() {
        return "IdentityDO{" +
        "id=" + id +
        ", rankIdCard=" + rankIdCard +
        ", rankImg=" + rankImg +
        ", rankName=" + rankName +
        ", rankUserId=" + rankUserId +
        ", rankSiteId=" + rankSiteId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
