package com.bookstore.mapper;

import com.bookstore.model.Address;
import com.bookstore.model.Order;
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
        "insert into bs_order (cust_id, addr_id, ",
        "ord_totalNum, ord_totalMoney, ",
        "ord_createDate, ord_state)",
        "values (#{custId,jdbcType=INTEGER}, #{addrId,jdbcType=INTEGER}, ",
        "#{ordTotalnum,jdbcType=INTEGER}, #{ordTotalmoney,jdbcType=INTEGER}, ",
        "#{ordCreatedate,jdbcType=DATE}, #{ordState,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="ordId", before=false, resultType=Integer.class)
    int insert(Order record);

    @Select({
        "select",
        "ord_id, cust_id, addr_id, ord_totalNum, ord_totalMoney, ord_createDate, ord_state",
        "from bs_order",
        "where ord_id = #{ordId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_totalNum", property="ordTotalnum", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_totalMoney", property="ordTotalmoney", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_createDate", property="ordCreatedate", jdbcType=JdbcType.DATE),
        @Result(column="ord_state", property="ordState", jdbcType=JdbcType.VARCHAR),
        @Result(property="address",column="addr_id",javaType= Address.class,
                one=@One(select= "com.bookstore.mapper.AddressMapper.selectByPrimaryKey")),
        @Result(column = "ord_id", property = "orderdetailList", javaType = List.class,
                many = @Many(select = "com.bookstore.mapper.OrderdetailMapper.selectOrderDetailByOrder"))
    })
    Order selectByPrimaryKey(Integer ordId);

    @Select({
        "select",
        "ord_id, cust_id, addr_id, ord_totalNum, ord_totalMoney, ord_createDate, ord_state",
        "from bs_order"
    })
    @Results({
        @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER),
        @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_totalNum", property="ordTotalnum", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_totalMoney", property="ordTotalmoney", jdbcType=JdbcType.INTEGER),
        @Result(column="ord_createDate", property="ordCreatedate", jdbcType=JdbcType.DATE),
        @Result(column="ord_state", property="ordState", jdbcType=JdbcType.VARCHAR)
    })
    List<Order> selectAll();

    @Update({
        "update bs_order",
        "set cust_id = #{custId,jdbcType=INTEGER},",
          "addr_id = #{addrId,jdbcType=INTEGER},",
          "ord_totalNum = #{ordTotalnum,jdbcType=INTEGER},",
          "ord_totalMoney = #{ordTotalmoney,jdbcType=INTEGER},",
          "ord_createDate = #{ordCreatedate,jdbcType=DATE},",
          "ord_state = #{ordState,jdbcType=VARCHAR}",
        "where ord_id = #{ordId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);

    @Select({
            "select",
            "ord_id, cust_id, addr_id, ord_totalNum, ord_totalMoney, ord_createDate, ord_state",
            "from bs_order",
            "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="ord_id", property="ordId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER),
            @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER),
            @Result(column="ord_totalNum", property="ordTotalnum", jdbcType=JdbcType.INTEGER),
            @Result(column="ord_totalMoney", property="ordTotalmoney", jdbcType=JdbcType.INTEGER),
            @Result(column="ord_createDate", property="ordCreatedate", jdbcType=JdbcType.DATE),
            @Result(column="ord_state", property="ordState", jdbcType=JdbcType.VARCHAR),
            @Result(property="address",column="addr_id",javaType= Address.class,
                    one=@One(select= "com.bookstore.mapper.AddressMapper.selectByPrimaryKey")),
            @Result(column = "ord_id", property = "orderdetailList", javaType = List.class,
                    many = @Many(select = "com.bookstore.mapper.OrderdetailMapper.selectOrderDetailByOrder"))
    })
    List<Order> selectOrderByCustomer(Integer custId);
}