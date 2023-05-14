package com.epam.tamentoring.bo.unittest;

import com.epam.tamentoring.bo.Product;
import com.epam.tamentoring.bo.ShoppingCart;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected ShoppingCart shoppingCart;

    @BeforeAll
    public void createShoppingCart() {
        List<Product> productList = new ArrayList<Product>(3) {{
            add(new Product(2, "apple", 5, 3));
            add(new Product(3, "tomato", 10, 4));
            add(new Product(4, "banana", 8, 4));
        }};
        shoppingCart = new ShoppingCart(productList);
    }
}
