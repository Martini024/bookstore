package com.bookstore.mapper;

import com.bookstore.model.Category;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
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
    @Results({
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cat_name", property="catName", jdbcType=JdbcType.VARCHAR)
    })
    Category selectByPrimaryKey(Integer catId);

    @Select({
        "select",
        "cat_id, cat_name",
        "from bs_category"
    })
    @Results({
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cat_name", property="catName", jdbcType=JdbcType.VARCHAR)
    })
    List<Category> selectAll();

    @Update({
        "update bs_category",
        "set cat_name = #{catName,jdbcType=VARCHAR}",
        "where cat_id = #{catId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Category record);
}