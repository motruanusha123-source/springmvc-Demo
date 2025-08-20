package com.upload;

import com.upload.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Employee emp) {
        String sql = "INSERT INTO employee (name, resume_name, resume_path) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, emp.getName(), emp.getResumeName(), emp.getResumePath());
    }
}

