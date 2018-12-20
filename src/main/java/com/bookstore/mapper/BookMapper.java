package com.bookstore.mapper;

import com.bookstore.model.Book;
import java.math.BigDecimal;
import java.util.List;

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
        "insert into bs_book (book_id, book_name, ",
        "book_price, book_author, ",
        "book_count, cat_id, ",
        "book_discount)",
        "values (#{bookId,jdbcType=INTEGER}, #{bookName,jdbcType=VARCHAR}, ",
        "#{bookPrice,jdbcType=DECIMAL}, #{bookAuthor,jdbcType=VARCHAR}, ",
        "#{bookCount,jdbcType=INTEGER}, #{catId,jdbcType=INTEGER}, ",
        "#{bookDiscount,jdbcType=INTEGER})"
    })
    int insert(Book record);

    @Select({
        "select",
        "book_id, book_name, book_price, book_author, book_count, cat_id, book_discount",
        "from bs_book",
        "where book_id = #{bookId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="book_price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="book_author", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="book_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="cat_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="book_discount", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    Book selectByPrimaryKey(Integer bookId);

    @Select({
        "select",
        "book_id, book_name, book_price, book_author, book_count, cat_id, book_discount",
        "from bs_book"
    })
    @ConstructorArgs({
        @Arg(column="book_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="book_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="book_price", javaType=BigDecimal.class, jdbcType=JdbcType.DECIMAL),
        @Arg(column="book_author", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="book_count", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="cat_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="book_discount", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
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