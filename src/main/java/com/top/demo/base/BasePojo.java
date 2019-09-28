package com.top.demo.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * * @description:
 * * @author: Tonghuan
 * * @create: 2019/4/1
 **/
@Data
public abstract class BasePojo implements Serializable{

   private Date created;
   private Date updated;
   private String createBy;
   private String updateBy;

}
