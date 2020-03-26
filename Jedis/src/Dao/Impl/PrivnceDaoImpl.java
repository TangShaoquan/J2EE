package Dao.Impl;

import Dao.PrivnceDao;
import Utils.JDBCUtils;
import domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PrivnceDaoImpl implements PrivnceDao {

    @Override
    public List<Province> findall() {
        //声明成员变量Jdbctemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        //1. 定义sql
        String  sql = "select * from province";
        //2. 执行sql
        List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
