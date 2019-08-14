package com.zs.util;

//@Table(name = "emp") /*有无都可以，mysql不区分大小写*/
public class Emp {

    @Column(name = "emp_id")
    private Integer empId;
    private String name;
    @Column(name = "dept_id")
    private Integer deptId;

    public Emp() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                '}';
    }
}
