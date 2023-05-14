package com.epam.tamentoring.bo.unittest;

import com.epam.tamentoring.bo.Product;
import com.epam.tamentoring.bo.ShoppingCart;
import com.epam.tamentoring.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShoppingCartTest extends BaseTest {

    private Random randomGenerator = new Random();

    private final static int NEW_PRODUCT_ID = 5;
    private final static int NOT_EXISTING_PRODUCT_ID = 7;

    @Test
    public void userCanAddNewProduct() {
        Product cucumbers = new Product(NEW_PRODUCT_ID, "cucumber", 7, 4);

        shoppingCart.addProductToCart(cucumbers);
        Product actualProduct = shoppingCart.getProductById(cucumbers.getId());
        Assertions.assertEquals(cucumbers, actualProduct, String.format("Shopping Cart does not contain newly added Product '%s' in Cart", cucumbers));
    }

    @Test
    public void userCanAddOneMoreAlreadyAddedProduct() {
        Product any = shoppingCart.getProducts().get(randomGenerator.nextInt(shoppingCart.getProducts().size()));
        Product newExistingProduct = new Product(any.getId(), any.getName(), any.getPrice(), 2);

        double expectedQuantity = any.getQuantity() + newExistingProduct.getQuantity();
        shoppingCart.addProductToCart(newExistingProduct);
        Assertions.assertEquals(shoppingCart.getProductById(any.getId()).getQuantity(), expectedQuantity);
    }

    @Test
    public void userCanRemoveExistingProduct() {
        Product any = shoppingCart.getProducts().get(randomGenerator.nextInt(shoppingCart.getProducts().size()));

        shoppingCart.removeProductFromCart(any);
        Assertions.assertThrows(ProductNotFoundException.class, () -> shoppingCart.getProductById(any.getId()));
    }

    @Test
    public void userCannotRemoveNonExistingProduct() {
        Product newProduct = new Product(NOT_EXISTING_PRODUCT_ID, "cherry", 12, 1.5);

        Assertions.assertThrows(ProductNotFoundException.class, () -> shoppingCart.removeProductFromCart(newProduct));
    }

    @Test
    public void userCanGetCartTotalPrice() {
        List<Product> products = shoppingCart.getProducts();

        double expectedPrice = 0;
        for (Product product : products) {
            expectedPrice += product.getPrice() * product.getQuantity();
        }

        Assertions.assertEquals(shoppingCart.getCartTotalPrice(), expectedPrice);
    }
}
