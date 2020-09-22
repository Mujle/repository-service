package com.example.repositoryservice.service;

import com.example.repositoryservice.domain.Product;
import com.example.repositoryservice.domain.ProductHistory;
import com.example.repositoryservice.repository.ProductHistoryRepository;
import com.example.repositoryservice.repository.ProductRepository;
import com.example.repositoryservice.service.ProductService;
import com.example.repositoryservice.viewObjects.ProductVO;
import com.example.repositoryservice.viewObjects.UpdateProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductHistoryRepository productHistoryRepository;

    @Override
    public List<ProductVO> getProducts() {

        List<Product> productsList = (List<Product>) productRepository.findAll();

        return productsList
                .stream()
                .map(product -> new ProductVO(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getMass(),
                        product.getAlcohol(),
                        product.getPicture(),
                        product.getAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProduct(UpdateProductVO updateProductVO) {

        Product product = productRepository.findById(updateProductVO.getProduct()).orElse(new Product());
        product.setAmount(product.getAmount() + updateProductVO.getNumberOfOrderedProducts());
        product.setUserId(updateProductVO.getUser());
        productRepository.save(product);
    }

    @Override
    public List<UpdateProductVO> getUpdatedProducts() {

        List<ProductHistory> productHistories = productHistoryRepository.findByTypeOfChange("update");

        return productHistories
                .stream()
                .map(productHistory -> new UpdateProductVO(productHistory.getUserId(), productHistory.getProductId(), productHistory.getNumberOfOrderedProducts()))
                .collect(Collectors.toList());
    }
}
