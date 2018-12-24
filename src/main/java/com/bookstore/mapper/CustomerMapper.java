package com.bookstore.mapper;

import com.bookstore.model.Customer;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CustomerMapper {
    @Delete({
        "delete from bs_customer",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer custId);

    @Insert({
        "insert into bs_customer (cust_name, cust_password, ",
        "cust_realName, cust_email, ",
        "cust_createDate)",
        "values (#{custName,jdbcType=VARCHAR}, #{custPassword,jdbcType=VARCHAR}, ",
        "#{custRealname,jdbcType=VARCHAR}, #{custEmail,jdbcType=VARCHAR}, ",
        "#{custCreatedate,jdbcType=DATE})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="custId", before=false, resultType=Integer.class)
    int insert(Customer record);

    @Select({
        "select",
        "cust_id, cust_name, cust_password, cust_realName, cust_email, cust_createDate",
        "from bs_customer",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_password", property="custPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_realName", property="custRealname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_email", property="custEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_createDate", property="custCreatedate", jdbcType=JdbcType.DATE),
        @Result(column = "cust_id", property = "addressList", javaType = List.class,
                many = @Many(select = "com.bookstore.mapper.AddressMapper.selectAddressByCustomer")),
        @Result(column = "cust_id", property = "orderList", javaType = List.class,
                many = @Many(select = "com.bookstore.mapper.OrderMapper.selectOrderByCustomer")),
        @Result(column = "cust_id", property = "shoppinglist", javaType = List.class,
                many = @Many(select = "com.bookstore.mapper.ShoppinglistMapper.selectShoppinglistByCustomer"))
    })
    Customer selectByPrimaryKey(Integer custId);


    @Select("select  cust_id from bs_customer where cust_name = #{custName}")
    @Results({
            @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true)
    })
    Integer selectByCustName(String custName);

    @Select({
        "select",
        "cust_id, cust_name, cust_password, cust_realName, cust_email, cust_createDate",
        "from bs_customer"
    })
    @Results({
        @Result(column="cust_id", property="custId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_name", property="custName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_password", property="custPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_realName", property="custRealname", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_email", property="custEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="cust_createDate", property="custCreatedate", jdbcType=JdbcType.DATE)
    })
    List<Customer> selectAll();

    @Update({
        "update bs_customer",
        "set cust_name = #{custName,jdbcType=VARCHAR},",
          "cust_password = #{custPassword,jdbcType=VARCHAR},",
          "cust_realName = #{custRealname,jdbcType=VARCHAR},",
          "cust_email = #{custEmail,jdbcType=VARCHAR},",
          "cust_createDate = #{custCreatedate,jdbcType=DATE}",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);
}
