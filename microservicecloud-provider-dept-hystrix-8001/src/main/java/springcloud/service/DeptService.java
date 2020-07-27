package springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.mapper.DeptMapper;

import java.util.List;

/**
 * @Auther jxy
 * @Date 2020-07-23
 */
@Service
public class DeptService {
    @Autowired
    private DeptMapper dao;


    public boolean add(Dept dept)
    {
        return dao.addDept(dept);
    }


    public Dept get(Long id)
    {

        return dao.findById(id);
    }

    public List<Dept> list()
    {

        return dao.findAll();
    }

}
