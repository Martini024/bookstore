package com.bookstore.mapper;

import com.bookstore.model.OrderDetail;
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
        "insert into bs_orderDetail (ordd_id, book_id, ",
        "ord_id, ordd_num, ",
        "ordd_price)",
        "values (#{orddId,jdbcType=INTEGER}, #{bookId,jdbcType=INTEGER}, ",
        "#{ordId,jdbcType=INTEGER}, #{orddNum,jdbcType=INTEGER}, ",
        "#{orddPrice,jdbcType=INTEGER})"
    })
    int insert(OrderDetail record);

    @Select({
        "select",
        "ordd_id, book_id, ord_id, ordd_num, ordd_price",
        "from bs_orderDetail",
        "where ordd_id = #{orddId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="ordd_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ordd_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ordd_price", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    OrderDetail selectByPrimaryKey(Integer orddId);

    @Select({
        "select",
        "ordd_id, book_id, ord_id, ordd_num, ordd_price",
        "from bs_orderDetail"
    })
    @ConstructorArgs({
        @Arg(column="ordd_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ordd_num", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ordd_price", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<OrderDetail> selectAll();

    @Update({
        "update bs_orderDetail",
        "set book_id = #{bookId,jdbcType=INTEGER},",
          "ord_id = #{ordId,jdbcType=INTEGER},",
          "ordd_num = #{orddNum,jdbcType=INTEGER},",
          "ordd_price = #{orddPrice,jdbcType=INTEGER}",
        "where ordd_id = #{orddId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(OrderDetail record);
}