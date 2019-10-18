package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@Data
@TableName("sys_dict_type")
public class DictTypeDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 英文代号
     */
    private String dictCode;

    /**
     * 中文代号
     */
    private String dictName;

    /**
     * 状态 1 ： 启用 2 ： 未启用
     */
    private Boolean dictStatus;

    /**
     * 父节点的id 0：说明为顶级
     */
    private Integer dictParent;

    /**
     * 排序字段
     */
    private Integer dictOrder;

    /**
     * 是否为叶子节点 1：是 0：否
     */
    private Integer leaf;

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
        return "DictTypeDO{" +
        "id=" + id +
        ", dictCode=" + dictCode +
        ", dictName=" + dictName +
        ", dictStatus=" + dictStatus +
        ", dictParent=" + dictParent +
        ", dictOrder=" + dictOrder +
        ", isLeaf=" + leaf +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
