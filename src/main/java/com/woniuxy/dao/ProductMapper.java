package com.woniuxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.woniuxy.domain.Product;
import com.woniuxy.domain.ProductExample;

public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer proid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer proid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    
    //多表联合查询产品
    List<Product> selectAll();
<<<<<<< HEAD
    //产品收藏数查询
    List<Product> selectAll1(RowBounds rb);
    //总行数查询
    int selectCountPage();
=======
    
    //查找热门前n产品
	List<Product> selectByLooktimesTen(Integer num);
	
>>>>>>> branch 'dev' of git@github.com:zhangyan0215/paipai.git
}