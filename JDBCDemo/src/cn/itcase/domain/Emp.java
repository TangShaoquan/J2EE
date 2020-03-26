package cn.itcase.domain;

public class Emp {
    private int id;
    private String name;
    private int balance;
    private int job_id;
    private double salary;
    private int dept_id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getJob_id() {
        return job_id;
    }

    public double getSalary() {
        return salary;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", job_id=" + job_id +
                ", salary=" + salary +
                ", dept_id=" + dept_id +
                '}';
    }
}
