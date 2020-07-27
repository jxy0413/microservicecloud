package springcloud.mapper;

import com.atguigu.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Insert("insert into dept(dname,db_source) values (#{dname},DATABASE())")
    public boolean addDept(Dept dept);

    @Select("select * from dept where deptno = #{deptno}")
    public Dept findById(Long Id);

    @Select("select * from dept")
    public List<Dept> findAll();
}
