package com.example.mapper;

import com.example.entily.Class;
import org.apache.ibatis.annotations.*;

public interface ClassMapper {
    @Select("select * from class where classid=#{classid};")
    Class selectClass(@Param("classid") String classid);

    @Insert("insert into class( classid,classname,classshijian, classxingzhi,xuefen,teacher) values(#{classid} ,#{classname}, #{classshijian},#{classxingzhi},#{xuefen},#{teacher})")
    int addClass(@Param("classid")String classid,@Param("classname") String classname, @Param("classshijian") String classshijian, @Param("classxingzhi") String classxingzhi,@Param("xuefen") String xuefen,   @Param("teacher") String teacher);

    @Delete("delete from class where classid=#{classid}")
    int deleteClass(@Param("classid") String classid);

    @Update("update class set  classshijian=#{classshijian},xuefen=#{xuefen},classname=#{ classname},classxingzhi=#{classxingzhi},teacher=#{teacher} where classid=#{classid}")
    int UpdateClass(@Param("classid") String classid, @Param("classname") String classname,@Param("classshijian") String classshijian,  @Param("classxingzhi") String classxingzhi, @Param("xuefen") String xuefen, @Param("teacher") String teacher);
}
