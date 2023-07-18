package com.example.mapper;

import com.example.entily.Classcj2;
import org.apache.ibatis.annotations.*;

public interface Classcj2Mapper {
    @Insert("insert into classcj2(studentid, math, Chinese,English,py) values(#{studentid}, #{math}, #{Chinese},#{English},#{py})")
    int AddClasscj2(@Param("studentid") int student,@Param("math")int math,@Param("Chinese")int Chinese,@Param("English")int English,@Param("py")int py);

    @Delete("delete from classcj2 where studentid=#{studentid}")
    int DeleteClasscj2(@Param("studentid")int studentid);

    @Update("update classcj2 set  math=#{math},Chinese=#{Chinese},English=#{English},py=#{py} where studentid=#{studentid}")
    int UpdateClasscj2(@Param("studentid") int studentid,@Param("math")int math,@Param("Chinese")int Chinese,@Param("English")int English,@Param("py")int py);

    @Select("select * from classcj2 where studentid=#{studentid}")
    Classcj2 SelectClasscj2(@Param("studentid")int studentid);
}
