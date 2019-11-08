package com.woniuxy.dao;

import com.woniuxy.domain.UsersRolesExample;
import com.woniuxy.domain.UsersRolesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersRolesMapper {
    long countByExample(UsersRolesExample example);

    int deleteByExample(UsersRolesExample example);

    int deleteByPrimaryKey(UsersRolesKey key);

    int insert(UsersRolesKey record);

    int insertSelective(UsersRolesKey record);

    List<UsersRolesKey> selectByExample(UsersRolesExample example);

    int updateByExampleSelective(@Param("record") UsersRolesKey record, @Param("example") UsersRolesExample example);

    int updateByExample(@Param("record") UsersRolesKey record, @Param("example") UsersRolesExample example);
}