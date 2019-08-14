package com.zs.util;
//@Table(name = "dept")   /*有无都可以，mysql不区分大小写*/
public class Dept {
    @Column(name = "dept_id")
    private Integer deptId;
    private String name;

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
