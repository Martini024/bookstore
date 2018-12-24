package com.bookstore.mapper;

import com.bookstore.model.Book;
import com.bookstore.model.Shoppinglist;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShoppinglistMapper {
    @Delete({
        "delete from bs_shoppingList",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("custId") Integer custId, @Param("bookId") Integer bookId);

    @Insert({
        "insert into bs_shoppingList (cust_id, book_id, ",
        "shop_quantity, shop_totalPrice)",
        "values (#{custId,jdbcType=INTEGER}, #{bookId,jdbcType=INTEGER}, ",
        "#{shopQuantity,jdbcType=INTEGER}, #{shopTotalprice,jdbcType=INTEGER})"
    })
    int insert(Shoppinglist record);

    @Select({
        "select",
        "cust_id, book_id, shop_quantity, shop_totalPrice",
        "from bs_shoppingList",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_quantity", property="shopQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_totalPrice", property="shopTotalprice", jdbcType=JdbcType.INTEGER),
        @Result(property="book",column="book_id",javaType= Book.class,
                one=@One(select= "com.bookstore.mapper.BookMapper.selectByPrimaryKey"))
    })
    Shoppinglist selectByPrimaryKey(@Param("custId") Integer custId, @Param("bookId") Integer bookId);

    @Select({
        "select",
        "cust_id, book_id, shop_quantity, shop_totalPrice",
        "from bs_shoppingList"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shop_quantity", property="shopQuantity", jdbcType=JdbcType.INTEGER),
        @Result(column="shop_totalPrice", property="shopTotalprice", jdbcType=JdbcType.INTEGER)
    })
    List<Shoppinglist> selectAll();

    @Update({
        "update bs_shoppingList",
        "set shop_quantity = #{shopQuantity,jdbcType=INTEGER},",
          "shop_totalPrice = #{shopTotalprice,jdbcType=INTEGER}",
        "where cust_id = #{custId,jdbcType=INTEGER}",
          "and book_id = #{bookId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Shoppinglist record);


    @Select({
            "select",
            "cust_id, book_id, shop_quantity, shop_totalPrice",
            "from bs_shoppingList",
            "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="shop_quantity", property="shopQuantity", jdbcType=JdbcType.INTEGER),
            @Result(column="shop_totalPrice", property="shopTotalprice", jdbcType=JdbcType.INTEGER),
            @Result(property="book",column="book_id",javaType= Book.class,
                    one=@One(select= "com.bookstore.mapper.BookMapper.selectByPrimaryKey"))
    })
    List<Book> selectShoppinglistByCustomer(Integer custId);

}