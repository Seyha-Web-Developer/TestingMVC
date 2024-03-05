package org.example.View;

import org.example.Controller.ProductController;
import org.example.Model.ProductModel;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductController productController;
    private Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void createProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        ProductModel product;


        productController.createProduct(new ProductModel(name,price,qty));
    }

    private void viewAllProducts() {
        List<ProductModel> products = productController.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (ProductModel product : products) {
                System.out.println(product);
            }
        }
    }
    private void updateProduct() {
        System.out.print("Enter the ID of the product to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the new price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the new quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the updateId matches the ID of the product to be updated
        boolean productUpdated = productController.updateProduct(updateId, name, price, qty);
        if (productUpdated) {
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + updateId + " not found.");
        }
    }


    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        productController.deleteProduct(id);
    }
}

