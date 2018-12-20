package com.bookstore.mapper;

import com.bookstore.model.Category;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CategoryMapper {
    @Delete({
        "delete from bs_category",
        "where cat_id = #{catId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer catId);

    @Insert({
        "insert into bs_category (cat_id, cat_name)",
        "values (#{catId,jdbcType=INTEGER}, #{catName,jdbcType=VARCHAR})"
    })
    int insert(Category record);

    @Select({
        "select",
        "cat_id, cat_name",
        "from bs_category",
        "where cat_id = #{catId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="cat_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cat_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(Integer catId);

    @Select({
        "select",
        "cat_id, cat_name",
        "from bs_category"
    })
    @ConstructorArgs({
        @Arg(column="cat_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cat_name", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectAll();

    @Update({
        "update bs_category",
        "set cat_name = #{catName,jdbcType=VARCHAR}",
        "where cat_id = #{catId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}