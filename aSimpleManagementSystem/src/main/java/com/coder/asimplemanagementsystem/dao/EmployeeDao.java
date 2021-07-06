package com.coder.asimplemanagementsystem.dao;

import com.coder.asimplemanagementsystem.pojo.Department;
import com.coder.asimplemanagementsystem.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    //模拟数据库

    private static Map<Integer, Employee> employeeMap = null;

    //员工所属部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employeeMap = new HashMap<>();  //创建一个员工表

        employeeMap.put(1001,new Employee(1001,"王一","1236756675@qq.com",1, new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"王二","1236756676@qq.com",0, new Department(101,"教学部")));
        employeeMap.put(1003,new Employee(1003,"王三","1236756673@qq.com",1, new Department(101,"教学部")));
        employeeMap.put(1004,new Employee(1004,"王四","1236756678@qq.com",0, new Department(101,"教学部")));
        employeeMap.put(1005,new Employee(1005,"王五","1236756679@qq.com",1, new Department(101,"教学部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void addEmployee(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employeeMap.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAllEmployee(){
        return employeeMap.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    //通过id删除员工
    public void deleteEmployeeById(Integer id){
        employeeMap.remove(id);
    }
}