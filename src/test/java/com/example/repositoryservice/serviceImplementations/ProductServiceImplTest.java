package com.example.repositoryservice.serviceImplementations;

import com.example.repositoryservice.domain.OrderProduct;
import com.example.repositoryservice.domain.Product;
import com.example.repositoryservice.domain.ProductHistory;
import com.example.repositoryservice.repository.ProductHistoryRepository;
import com.example.repositoryservice.repository.ProductRepository;
import com.example.repositoryservice.service.ProductServiceImpl;
import com.example.repositoryservice.viewObjects.ProductVO;
import com.example.repositoryservice.viewObjects.UpdateProductVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductHistoryRepository productHistoryRepository;

    private Product productTest;
    private List<Product> productsTest;
    private String name = "beer";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        OrderProduct op = new OrderProduct();
        List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(op);

        productTest = new Product(1, name, 225, 1.5, 4.5,
                "picture", 46, 1, orderProductList);

        productsTest = new ArrayList<>();
        productsTest.add(productTest);
    }

    @Test
    void getProducts() {

        when(productRepository.findAll()).thenReturn(productsTest);

        List<ProductVO> productVOS = productService.getProducts();
        ProductVO productVO = productVOS.get(0);

        assertEquals(name, productVO.getName());
    }

    @Test
    void update(){

        Optional<Product> productResponseTest = Optional.of(productTest);
        UpdateProductVO updateProductVO = new UpdateProductVO(productTest.getUserId(), productTest.getId(), 54);

        when(productRepository.findById(anyInt())).thenReturn(productResponseTest);

        productService.updateProduct(updateProductVO);

        verify(productRepository, times(1)).save(productTest);
    }

    @Test
    void getUpdatedProducts(){

        ProductHistory productHistoryTest = new ProductHistory(1, 1, 1, 43, new Date(), "update");
        List<ProductHistory> productHistoriesTest = new ArrayList<>();
        productHistoriesTest.add(productHistoryTest);

        when(productHistoryRepository.findByTypeOfChange("update")).thenReturn(productHistoriesTest);

        List<UpdateProductVO> updateProductVOS = productService.getUpdatedProducts();
        UpdateProductVO updateProductVO = updateProductVOS.get(0);

        assertEquals(productHistoryTest.getUserId(), updateProductVO.getUser());
    }


}