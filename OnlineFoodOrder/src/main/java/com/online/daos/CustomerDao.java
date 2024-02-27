package com.online.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.online.entites.Customer;

public class CustomerDao {

    private Connection con;

    public CustomerDao(Connection con) {
        this.con = con;
    }

    // Method to insert customer data into the database
    public boolean saveCustomer(Customer customer) {
        boolean success = false;
        String query = "INSERT INTO Customer (customerId, customerName, customerCity, customerPassword, customerEmail) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = this.con.prepareStatement(query)) {
            statement.setInt(1, customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerCity());
            statement.setString(4, customer.getCustomerPassword());
            statement.setString(5, customer.getCustomerEmail());

            int rowsInserted = statement.executeUpdate();
            success = rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    
    //get Customer mail and password;
    public Customer getCustomerEmailAndPassword(String email, String password) {
        Customer customer = null;

        try {
            String query = "SELECT * FROM Customer WHERE customerEmail=? AND customerPassword=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet set = statement.executeQuery();

            if (set.next()) {
                customer = new Customer();
                customer.setCustomerId(set.getInt("customerId"));
                customer.setCustomerName(set.getString("customerName"));
                customer.setCustomerCity(set.getString("customerCity"));
                customer.setCustomerPassword(set.getString("customerPassword"));
                customer.setCustomerEmail(set.getString("customerEmail"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
   }
