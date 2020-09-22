package com.example.repositoryservice.service;

import com.example.repositoryservice.viewObjects.ProductVO;
import com.example.repositoryservice.viewObjects.UpdateProductVO;

import java.util.List;

public interface ProductService {

    List<ProductVO> getProducts();

    void updateProduct(UpdateProductVO updateProductVO);

    List<UpdateProductVO> getUpdatedProducts();
}
