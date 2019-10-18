package com.top.demo.modules.service.impl;

import com.top.demo.modules.pojo.RelationDO;
import com.top.demo.modules.mapper.RelationMapper;
import com.top.demo.modules.service.RelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生-老师关系表 服务实现类
 * </p>
 *
 * @author lth
 * @since 2019-10-17
 */
@Service
public class RelationServiceImpl extends ServiceImpl<RelationMapper, RelationDO> implements RelationService {

}
