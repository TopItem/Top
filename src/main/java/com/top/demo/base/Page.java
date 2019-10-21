package com.top.demo.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author lth
 * @date 2019年10月21日 20:10
 */
@Data
public class Page<T> implements Serializable {

    /**
     * 起始索引
     */
    private Integer index = 0;

    /**
     * 当前页
     */
    private Integer pageNum = 1;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 排序方式
     */
    private String sortOrder = "asc";


    /**
     * 每页显示数据
     */
    private List<T> list = Lists.newArrayList();


}

