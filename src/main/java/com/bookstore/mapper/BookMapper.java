package com.bookstore.mapper;

import com.bookstore.model.Book;
import java.util.List;

import com.bookstore.model.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface BookMapper {
    @Delete({
        "delete from bs_book",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer bookId);

    @Insert({
        "insert into bs_book (book_name, book_price, ",
        "book_author, book_count, ",
        "cat_id, book_discount)",
        "values (#{bookName,jdbcType=VARCHAR}, #{bookPrice,jdbcType=DECIMAL}, ",
        "#{bookAuthor,jdbcType=VARCHAR}, #{bookCount,jdbcType=INTEGER}, ",
        "#{catId,jdbcType=INTEGER}, #{bookDiscount,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="bookId", before=false, resultType=Integer.class)
    int insert(Book record);

    @Select({
        "select",
        "book_id, book_name, book_price, book_author, book_count, cat_id, book_discount",
        "from bs_book",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="book_author", property="bookAuthor", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_count", property="bookCount", jdbcType=JdbcType.INTEGER),
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER),
        @Result(column="book_discount", property="bookDiscount", jdbcType=JdbcType.INTEGER),
        @Result(property="category",column="cat_id",javaType= Category.class,
                one=@One(select= "com.bookstore.mapper.CategoryMapper.selectByPrimaryKey")),
    })
    Book selectByPrimaryKey(Integer bookId);

    @Select({
        "select",
        "book_id, book_name, book_price, book_author, book_count, cat_id, book_discount",
        "from bs_book"
    })
    @Results({
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_price", property="bookPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="book_author", property="bookAuthor", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_count", property="bookCount", jdbcType=JdbcType.INTEGER),
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER),
        @Result(column="book_discount", property="bookDiscount", jdbcType=JdbcType.INTEGER)
    })
    List<Book> selectAll();

    @Update({
        "update bs_book",
        "set book_name = #{bookName,jdbcType=VARCHAR},",
          "book_price = #{bookPrice,jdbcType=DECIMAL},",
          "book_author = #{bookAuthor,jdbcType=VARCHAR},",
          "book_count = #{bookCount,jdbcType=INTEGER},",
          "cat_id = #{catId,jdbcType=INTEGER},",
          "book_discount = #{bookDiscount,jdbcType=INTEGER}",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Book record);
}