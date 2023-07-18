package com.example.mapper;

import com.example.entily.Class;
import com.example.entily.Classcj;
import com.example.entily.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface StudentMapper {
    @Select("select * from username where id=#{id};")
    Student selectStudent(@Param("id")int id);

    @Insert("insert into username(id, name, sex,age) values(#{sid}, #{name}, #{sex},#{age})")
    int addStudent(@Param("sid") int sid, @Param("name")  String name, @Param("sex") String sex,@Param("age")int age);

    @Delete("delete from username where id=#{sid}")
    int deleteStudent(@Param("sid")int sid);

    @Update("update username set name=#{name},sex=#{sex},age=#{age} where id=#{sid}")
    int UpdateStudent(@Param("sid")int sid,@Param("name")String name,@Param("sex")String sex,@Param("age")int age);

//    @Results({
//            @Result(id = true, column = "id", property = "id"),
//            @Result(column = "name", property = "name"),//前面一一映射 后面因为是List 所以要用另一个表的查询结果来映射 many就是专门用来映射一对多的映射的
//            @Result(column = "sex", property = "sex"),
//            @Result(column = "age", property = "age"),
//            @Result(column = "studenti", property = "class1", many =
//            @Many(select = "selectcj")
//            )
//    })
    @Select("select * from  classcj join  username on username.id =classcj.studentid where classcj1 = #{classcj1}")
    Student selectsyStudent(@Param("classcj1")int classcj1);
//
//    @Select("select * from  classcj where studentid=#{studentid}")
//    List<Classcj> selectcj(int studentid);
}
