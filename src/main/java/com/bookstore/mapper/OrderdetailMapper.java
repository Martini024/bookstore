package com.bookstore.mapper;

import com.bookstore.model.Book;
import com.bookstore.model.Orderdetail;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface OrderdetailMapper {
    @Delete({
        "delete from bs_orderDetail",
        "where ordd_id = #{orddId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer orddId);

    @Insert({
        "insert into bs_orderDetail (book_id, ord_id, ",
        "ordd_num, ordd_price)",
        "values (#{bookId,jdbcType=INTEGER}, #{ordId,jdbcType=INTEGER}, ",
        "#{orddNum,jdbcType=INTEGER}, #{orddPrice,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="orddId", before=false, resultType=Integer.class)
    int insert(Orderdetail record);

    @Select({
        "select",
        "ordd_id, book_id, ord_id, ordd_num, ordd_price",
        "from bs_orderDetail",
        "where ordd_id = #{orddId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ordd_id", property="orddId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER),
        @Result(column="ordd_num", property="orddNum", jdbcType=JdbcType.INTEGER),
        @Result(column="ordd_price", property="orddPrice", jdbcType=JdbcType.INTEGER),
        @Result(property="book",column="book_id",javaType= Book.class,
                one=@One(select= "com.bookstore.mapper.BookMapper.selectByPrimaryKey"))
    })
    Orderdetail selectByPrimaryKey(Integer orddId);

    @Select({
        "select",
        "ordd_id, book_id, ord_id, ordd_num, ordd_price",
        "from bs_orderDetail"
    })
    @Results({
        @Result(column="ordd_id", property="orddId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER),
        @Result(column="ordd_num", property="orddNum", jdbcType=JdbcType.INTEGER),
        @Result(column="ordd_price", property="orddPrice", jdbcType=JdbcType.INTEGER)
    })
    List<Orderdetail> selectAll();

    @Update({
        "update bs_orderDetail",
        "set book_id = #{bookId,jdbcType=INTEGER},",
          "ord_id = #{ordId,jdbcType=INTEGER},",
          "ordd_num = #{orddNum,jdbcType=INTEGER},",
          "ordd_price = #{orddPrice,jdbcType=INTEGER}",
        "where ordd_id = #{orddId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orderdetail record);

    @Select({
            "select",
            "ordd_id, book_id, ord_id, ordd_num, ordd_price",
            "from bs_orderDetail",
            "where ord_id = #{orddId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="ordd_id", property="orddId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER),
            @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER),
            @Result(column="ordd_num", property="orddNum", jdbcType=JdbcType.INTEGER),
            @Result(column="ordd_price", property="orddPrice", jdbcType=JdbcType.INTEGER),
            @Result(property="book",column="book_id",javaType= Book.class,
                    one=@One(select= "com.bookstore.mapper.BookMapper.selectByPrimaryKey"))
    })
    List<Orderdetail> selectOrderDetailByOrder(Integer ordId);
}