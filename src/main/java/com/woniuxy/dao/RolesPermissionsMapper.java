package com.woniuxy.dao;

import com.woniuxy.domain.RolesPermissionsExample;
import com.woniuxy.domain.RolesPermissionsKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPermissionsMapper {
    long countByExample(RolesPermissionsExample example);

    int deleteByExample(RolesPermissionsExample example);

    int deleteByPrimaryKey(RolesPermissionsKey key);

    int insert(RolesPermissionsKey record);

    int insertSelective(RolesPermissionsKey record);

    List<RolesPermissionsKey> selectByExample(RolesPermissionsExample example);

    int updateByExampleSelective(@Param("record") RolesPermissionsKey record, @Param("example") RolesPermissionsExample example);

    int updateByExample(@Param("record") RolesPermissionsKey record, @Param("example") RolesPermissionsExample example);
}