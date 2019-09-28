package com.top.demo.common.response;

import lombok.Data;
import lombok.ToString;


/**
 * 返回数据
 * @author lth
 * @date 2019/9/27 17:49
 */

@Data
@ToString
public class QueryResponseResult<T> extends ResponseResult {

    QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode,QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
