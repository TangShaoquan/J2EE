package cn.itcase.jdbc;

import cn.itcase.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JBDCDemo5 {
    //练习
    //需求：查询emp表的数据，将其封装为对象，然后封装为集合，然后打印
    public static void main(String[] args) throws SQLException {
        List<Emp> list = new JBDCDemo5().findAll();
        System.out.println(list);
    }

    /*
     *查询所有emp对象
     */
    public List<Emp> findAll() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        List<Emp> list = new ArrayList<Emp>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","admin");
            String sql = "select * from emp";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Emp emp = null;

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int balance = resultSet.getInt("balance");
                int job_id = resultSet.getInt("job_id");
                double salary = resultSet.getDouble("salary");
                int dept_id = resultSet.getInt("dept_id");

                //创建emp对象
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setBalance(balance);
                emp.setJob_id(job_id);
                emp.setSalary(salary);
                emp.setDept_id(dept_id);

                //装集合
                list.add(emp);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;


    }

}
