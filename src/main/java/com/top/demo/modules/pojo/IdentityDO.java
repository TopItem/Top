package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRankIdCard() {
        return rankIdCard;
    }

    public void setRankIdCard(String rankIdCard) {
        this.rankIdCard = rankIdCard;
    }

    public String getRankImg() {
        return rankImg;
    }

    public void setRankImg(String rankImg) {
        this.rankImg = rankImg;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getRankUserId() {
        return rankUserId;
    }

    public void setRankUserId(Integer rankUserId) {
        this.rankUserId = rankUserId;
    }

    public Integer getRankSiteId() {
        return rankSiteId;
    }

    public void setRankSiteId(Integer rankSiteId) {
        this.rankSiteId = rankSiteId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

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
