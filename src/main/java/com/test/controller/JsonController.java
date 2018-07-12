/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.DB.DBUtils;
import com.test.model.Employees;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TAND.M
 */
@Controller
public class JsonController {

    @RequestMapping(value = "/getJson", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Employees>> getJson(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        List<Employees> list = new ArrayList<>(getEmployeeses());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public List<Employees> getEmployeeses() throws ClassNotFoundException, SQLException {

        List<Employees> list = new ArrayList<>();
        Connection conn = DBUtils.getConnection();
        String sql = "select * from employees";
        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Employees employees = new Employees();
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String mail = resultSet.getString(5);
            employees.setId(id);
            employees.setName(name);
            employees.setAddress(address);
            employees.setPhone(phone);
            employees.setMail(mail);
            list.add(employees);
        }
        statement.close();
        conn.close();
        return list;
    }
}
