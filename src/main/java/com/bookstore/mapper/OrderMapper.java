package com.bookstore.mapper;

import com.bookstore.model.Order;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface OrderMapper {
    @Delete({
        "delete from bs_order",
        "where ord_id = #{ordId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer ordId);

    @Insert({
        "insert into bs_order (ord_id, cust_id, ",
        "addr_id, ord_totalNum, ",
        "ord_totalMoney, ord_createData, ",
        "ord_state)",
        "values (#{ordId,jdbcType=INTEGER}, #{custId,jdbcType=INTEGER}, ",
        "#{addrId,jdbcType=INTEGER}, #{ordTotalnum,jdbcType=INTEGER}, ",
        "#{ordTotalmoney,jdbcType=INTEGER}, #{ordCreatedata,jdbcType=DATE}, ",
        "#{ordState,jdbcType=VARCHAR})"
    })
    int insert(Order record);

    @Select({
        "select",
        "ord_id, cust_id, addr_id, ord_totalNum, ord_totalMoney, ord_createData, ord_state",
        "from bs_order",
        "where ord_id = #{ordId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="ord_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="addr_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_totalNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_totalMoney", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_createData", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="ord_state", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Order selectByPrimaryKey(Integer ordId);

    @Select({
        "select",
        "ord_id, cust_id, addr_id, ord_totalNum, ord_totalMoney, ord_createData, ord_state",
        "from bs_order"
    })
    @ConstructorArgs({
        @Arg(column="ord_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="addr_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_totalNum", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_totalMoney", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="ord_createData", javaType=Date.class, jdbcType=JdbcType.DATE),
        @Arg(column="ord_state", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Order> selectAll();

    @Update({
        "update bs_order",
        "set cust_id = #{custId,jdbcType=INTEGER},",
          "addr_id = #{addrId,jdbcType=INTEGER},",
          "ord_totalNum = #{ordTotalnum,jdbcType=INTEGER},",
          "ord_totalMoney = #{ordTotalmoney,jdbcType=INTEGER},",
          "ord_createData = #{ordCreatedata,jdbcType=DATE},",
          "ord_state = #{ordState,jdbcType=VARCHAR}",
        "where ord_id = #{ordId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}