package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@TableName("sys_permission")
public class PermissionDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 资源名称
     */
    private String perName;

    /**
     * 权限代码字符串
     */
    private String perCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    @Override
    public String toString() {
        return "PermissionDO{" +
        "id=" + id +
        ", perName=" + perName +
        ", perCode=" + perCode +
        "}";
    }
}
