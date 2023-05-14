package com.epam.tamentoring.bo.unittest;

import com.epam.tamentoring.bo.DiscountUtility;
import com.epam.tamentoring.bo.OrderService;
import com.epam.tamentoring.bo.UserAccount;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class OrderServiceTest extends BaseTest {

    @Mock
    private DiscountUtility discountUtility;

    @InjectMocks
    private OrderService orderService = new OrderService();

    private AutoCloseable closeable;

    private UserAccount userAccount;

    private static final double EXPECTED_DISCOUNT = 3;

    @BeforeAll
    public void openMocks() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @BeforeAll
    public void setUpUserAccount() {
        userAccount = new UserAccount("John", "Smith", "1990/10/10", shoppingCart);
    }

    @Test
    public void checkDiscountForUser() {
        ArgumentCaptor<UserAccount> accountCaptor = ArgumentCaptor.forClass(UserAccount.class);
        Mockito.when(discountUtility.calculateDiscount(accountCaptor.capture())).thenReturn(EXPECTED_DISCOUNT);

        double orderPrice = orderService.getOrderPrice(userAccount);

        verify(discountUtility, Mockito.times(1)).calculateDiscount(accountCaptor.capture());
        verifyNoMoreInteractions(discountUtility);
        Assertions.assertEquals(EXPECTED_DISCOUNT, shoppingCart.getCartTotalPrice() - orderPrice);
    }

    @AfterAll
    public void closeMocks() throws Exception {
        closeable.close();
    }
}
