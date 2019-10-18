package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 学生-老师关系表
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@TableName("sys_relation")
public class RelationDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生Id
     */
    private Integer relaStId;

    /**
     * 老师Id
     */
    private Integer relaTeaId;

    /**
     * top的科目
     */
    private Integer relaSpecialty;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 结束时间
     */
    private LocalDateTime endTime;

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

    public Integer getRelaStId() {
        return relaStId;
    }

    public void setRelaStId(Integer relaStId) {
        this.relaStId = relaStId;
    }

    public Integer getRelaTeaId() {
        return relaTeaId;
    }

    public void setRelaTeaId(Integer relaTeaId) {
        this.relaTeaId = relaTeaId;
    }

    public Integer getRelaSpecialty() {
        return relaSpecialty;
    }

    public void setRelaSpecialty(Integer relaSpecialty) {
        this.relaSpecialty = relaSpecialty;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
        return "RelationDO{" +
        "id=" + id +
        ", relaStId=" + relaStId +
        ", relaTeaId=" + relaTeaId +
        ", relaSpecialty=" + relaSpecialty +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
