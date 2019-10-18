package com.top.demo.modules.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * top点信息表
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@TableName("sys_site")
public class SiteDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * top点的名称
     */
    private String siteName;

    /**
     * 容量
     */
    private Integer siteCapacity;

    /**
     * 附加说明信息
     */
    private String siteInfo;

    /**
     * 省份id 数据字典
     */
    private Integer siteProvice;

    /**
     * 城市id
     */
    private Integer siteCity;

    /**
     * 地区id
     */
    private Integer siteDistrict;

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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getSiteCapacity() {
        return siteCapacity;
    }

    public void setSiteCapacity(Integer siteCapacity) {
        this.siteCapacity = siteCapacity;
    }

    public String getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(String siteInfo) {
        this.siteInfo = siteInfo;
    }

    public Integer getSiteProvice() {
        return siteProvice;
    }

    public void setSiteProvice(Integer siteProvice) {
        this.siteProvice = siteProvice;
    }

    public Integer getSiteCity() {
        return siteCity;
    }

    public void setSiteCity(Integer siteCity) {
        this.siteCity = siteCity;
    }

    public Integer getSiteDistrict() {
        return siteDistrict;
    }

    public void setSiteDistrict(Integer siteDistrict) {
        this.siteDistrict = siteDistrict;
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
        return "SiteDO{" +
        "id=" + id +
        ", siteName=" + siteName +
        ", siteCapacity=" + siteCapacity +
        ", siteInfo=" + siteInfo +
        ", siteProvice=" + siteProvice +
        ", siteCity=" + siteCity +
        ", siteDistrict=" + siteDistrict +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
