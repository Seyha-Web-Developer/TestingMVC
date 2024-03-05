package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.example.Controller.ProductController;
import org.example.View.ProductView;

import java.sql.*;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/stock_db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            ProductController productController = new ProductController(connection);
            ProductView productView = new ProductView(productController);

            productView.displayMenu(); // Display the menu for CRUD operations
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
