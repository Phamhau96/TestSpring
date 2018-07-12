/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.DB.DBUtils;
import com.test.model.Employees;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TAND.M
 */
@Controller
public class EmployeesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getEmployees() throws ClassNotFoundException, SQLException {

        List<Employees> list = new ArrayList<>(getEmployeeses());
        ModelAndView andView = new ModelAndView("getEmployees");
        andView.addObject("list", list);
        return andView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addEmployees() throws ClassNotFoundException, SQLException {
        ModelAndView andView = new ModelAndView("addEmployees");
        return andView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editEmployees(HttpServletRequest request, @ModelAttribute(value = "employees") Employees employees) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        if (request.getParameter("edit") != null) {
            ModelAndView andView = new ModelAndView("editEmployees");
            andView.addObject("employees", employees);
            return andView;
        } else {
            deleteEmployeeses(employees);
            ModelAndView andView = new ModelAndView("deleteEmployees");
            andView.addObject("info", "Delete thành công!");
            return andView;
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateEmployees(@ModelAttribute(value = "employees") Employees employees) throws ClassNotFoundException, SQLException {
        editEmployeeses(employees);
        ModelAndView andView = new ModelAndView("deleteEmployees");
        andView.addObject("info", "Update thành công!");
        return andView;
    }

    @RequestMapping(value = "/addEmployees")
    public ModelAndView add(@ModelAttribute(value = "employees") Employees employees) throws ClassNotFoundException, SQLException {
        addEmployeeses(employees);
        ModelAndView andView = new ModelAndView("deleteEmployees");
        andView.addObject("info", "Thêm mới thành công!");
        return andView;
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

    public void addEmployeeses(Employees employees) throws ClassNotFoundException, SQLException {

        Connection conn = DBUtils.getConnection();
        String sql = "INSERT INTO  employees (name, address, phone, mail) values (?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, employees.getName());
        ps.setString(2, employees.getAddress());
        ps.setString(3, employees.getPhone());
        ps.setString(4, employees.getMail());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void editEmployeeses(Employees employees) throws ClassNotFoundException, SQLException {

        Connection conn = DBUtils.getConnection();
        String sql = "update employees set name = ?, address = ?, phone = ?, mail = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, employees.getName());
        ps.setString(2, employees.getAddress());
        ps.setString(3, employees.getPhone());
        ps.setString(4, employees.getMail());
        ps.setString(5, employees.getId());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void deleteEmployeeses(Employees employees) throws ClassNotFoundException, SQLException {

        Connection conn = DBUtils.getConnection();
        String sql = "delete from employees where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, employees.getId());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
