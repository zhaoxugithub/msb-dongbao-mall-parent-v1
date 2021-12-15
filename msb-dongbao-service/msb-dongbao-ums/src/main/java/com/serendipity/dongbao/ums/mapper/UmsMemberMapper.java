package com.serendipity.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.serendipity.dongbao.ums.entity.UmsMember;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author 赵旭
 * @since 2021-12-09
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {
    UmsMember selectByName(String name);

    List<UmsMember> selectAllUser();
}
