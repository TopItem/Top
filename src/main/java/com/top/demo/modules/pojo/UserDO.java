package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@TableName("sys_user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String uUserName;

    /**
     * 密码
     */
    private String uPassword;

    /**
     * 数据字典 特长
     */
    private Integer uSpecialty;

    /**
     * 电话号码
     */
    private String uPhone;

    /**
     * 头像
     */
    private String uProfile;

    /**
     * 性别 1： 男  0： 女
     */
    private Integer uSex;

    /**
     * 学历 id 字典id
     */
    private Integer uDegree;

    /**
     * 状态 ：0  待认证 1 认证中  2 已认证
     */
    private Integer uStatus;

    /**
     * 角色id
     */
    private Integer uRole;

    /**
     * 邮箱地址
     */
    private String uEmail;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuUserName() {
        return uUserName;
    }

    public void setuUserName(String uUserName) {
        this.uUserName = uUserName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public Integer getuSpecialty() {
        return uSpecialty;
    }

    public void setuSpecialty(Integer uSpecialty) {
        this.uSpecialty = uSpecialty;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuProfile() {
        return uProfile;
    }

    public void setuProfile(String uProfile) {
        this.uProfile = uProfile;
    }

    public Integer getuSex() {
        return uSex;
    }

    public void setuSex(Integer uSex) {
        this.uSex = uSex;
    }

    public Integer getuDegree() {
        return uDegree;
    }

    public void setuDegree(Integer uDegree) {
        this.uDegree = uDegree;
    }

    public Integer getuStatus() {
        return uStatus;
    }

    public void setuStatus(Integer uStatus) {
        this.uStatus = uStatus;
    }

    public Integer getuRole() {
        return uRole;
    }

    public void setuRole(Integer uRole) {
        this.uRole = uRole;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
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
        return "UserDO{" +
        "id=" + id +
        ", uUserName=" + uUserName +
        ", uPassword=" + uPassword +
        ", uSpecialty=" + uSpecialty +
        ", uPhone=" + uPhone +
        ", uProfile=" + uProfile +
        ", uSex=" + uSex +
        ", uDegree=" + uDegree +
        ", uStatus=" + uStatus +
        ", uRole=" + uRole +
        ", uEmail=" + uEmail +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
