package com.xdy.ssm.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xdy.ssm.crud.bean.Employee;
import com.xdy.ssm.crud.bean.EmployeeExample;
import com.xdy.ssm.crud.bean.Msg;
import com.xdy.ssm.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Msg getAll(@RequestParam(name = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,10);
        List<Employee> employeeList = employeeMapper.selectByExampleWithDept(null);
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    @PostMapping("/emp")
    @ResponseBody
    public Msg addEmployee(Employee employee){
        System.out.println(employee);
        employeeMapper.insertSelective(employee);
        return Msg.success();
    }

    @DeleteMapping("/emp/{id}")
    @ResponseBody
    public Msg deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeMapper.deleteByPrimaryKey(id);
        return Msg.success();
    }

    @PutMapping("/emp")
    @ResponseBody
    public Msg updateEmployee(Employee employee){
        System.out.println(employee);
        EmployeeExample example = new EmployeeExample();
        example.createCriteria().andEmpIdEqualTo(employee.getEmpId());
        employeeMapper.updateByExampleSelective(employee,example);
        return Msg.success();
    }
}
