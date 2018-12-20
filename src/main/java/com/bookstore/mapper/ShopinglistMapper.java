package com.bookstore.mapper;

import com.bookstore.model.ShopingList;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface ShopinglistMapper {
    @Delete({
        "delete from bs_shopingList",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("custId") Integer custId, @Param("bookId") Integer bookId);

    @Insert({
        "insert into bs_shopingList (cust_id, book_id, ",
        "shop_quantity, shop_totalPrice)",
        "values (#{custId,jdbcType=INTEGER}, #{bookId,jdbcType=INTEGER}, ",
        "#{shopQuantity,jdbcType=INTEGER}, #{shopTotalprice,jdbcType=INTEGER})"
    })
    int insert(ShopingList record);

    @Select({
        "select",
        "cust_id, book_id, shop_quantity, shop_totalPrice",
        "from bs_shopingList",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="shop_quantity", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="shop_totalPrice", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    ShopingList selectByPrimaryKey(@Param("custId") Integer custId, @Param("bookId") Integer bookId);

    @Select({
        "select",
        "cust_id, book_id, shop_quantity, shop_totalPrice",
        "from bs_shopingList"
    })
    @ConstructorArgs({
        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="shop_quantity", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="shop_totalPrice", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<ShopingList> selectAll();

    @Update({
        "update bs_shopingList",
        "set shop_quantity = #{shopQuantity,jdbcType=INTEGER},",
          "shop_totalPrice = #{shopTotalprice,jdbcType=INTEGER}",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ShopingList record);
}