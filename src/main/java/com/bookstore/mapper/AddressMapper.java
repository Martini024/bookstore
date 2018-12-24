package com.bookstore.mapper;

import com.bookstore.model.Address;
import java.util.List;

import com.bookstore.model.Customer;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AddressMapper {
    @Delete({
        "delete from bs_address",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer addrId);

    @Insert({
        "insert into bs_address (cust_id, addr_name, ",
        "addr_phone, addr_address, ",
        "addr_zipcode)",
        "values (#{custId,jdbcType=INTEGER}, #{addrName,jdbcType=VARCHAR}, ",
        "#{addrPhone,jdbcType=VARCHAR}, #{addrAddress,jdbcType=VARCHAR}, ",
        "#{addrZipcode,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="addrId", before=false, resultType=Integer.class)
    int insert(Address address);

    @Select({
        "select",
        "addr_id, cust_id, addr_name, addr_phone, addr_address, addr_zipcode",
        "from bs_address",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_id", property = "custId", jdbcType = JdbcType.INTEGER),
        @Result(column="addr_name", property="addrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_phone", property="addrPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_address", property="addrAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_zipcode", property="addrZipcode", jdbcType=JdbcType.VARCHAR),
    })
    Address selectByPrimaryKey(Integer addrId);

    @Select({
        "select",
        "addr_id, cust_id, addr_name, addr_phone, addr_address, addr_zipcode",
        "from bs_address"
    })
    @Results({
        @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="cust_id", property = "custId", jdbcType = JdbcType.INTEGER),
        @Result(column="addr_name", property="addrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_phone", property="addrPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_address", property="addrAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="addr_zipcode", property="addrZipcode", jdbcType=JdbcType.VARCHAR),
    })
    List<Address> selectAll();

    @Update({
        "update bs_address",
        "set cust_id = #{custId,jdbcType=INTEGER},",
          "addr_name = #{addrName,jdbcType=VARCHAR},",
          "addr_phone = #{addrPhone,jdbcType=VARCHAR},",
          "addr_address = #{addrAddress,jdbcType=VARCHAR},",
          "addr_zipcode = #{addrZipcode,jdbcType=VARCHAR}",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address address);

    @Select({
            "select",
            "addr_id, cust_id, addr_name, addr_phone, addr_address, addr_zipcode",
            "from bs_address",
            "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="addr_id", property="addrId", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="cust_id", property = "custId", jdbcType = JdbcType.INTEGER),
            @Result(column="addr_name", property="addrName", jdbcType=JdbcType.VARCHAR),
            @Result(column="addr_phone", property="addrPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="addr_address", property="addrAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="addr_zipcode", property="addrZipcode", jdbcType=JdbcType.VARCHAR),
    })
    List<Address> selectAddressByCustomer(Integer custId);
}