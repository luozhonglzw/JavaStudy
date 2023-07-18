package com.example.mapper;

import com.example.entily.Classcj;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClasscjMapper {
    @Select("select * from classcj where studentid=#{studentid};")
    Classcj Selectcj (@Param("studentid")int studentid);

    @Insert("insert into classcj(studentid, classid, classcj1) values(#{studentid}, #{classid}, #{classcj1})")
    int Addcj(@Param("studentid")int studentid,@Param("classid")int classid,@Param("classcj1")int classcj1);

    @Delete("delete from classcj where studentid=#{studentid}")
    int Deletecj(@Param("studentid")int studentid);

    @Update("update classcj set studentid=#{studentid},classid=#{classid},classcj1=#{classcj1} where studentid=#{studentid}")
    int Updatecj(@Param("studentid")int studentid,@Param("classid")int classid,@Param("classcj1")int classcj1);

    @Select("select classcj1 from classcj where classid=#{classid}")
    List<Integer> Selectsycj(int classid);


}
