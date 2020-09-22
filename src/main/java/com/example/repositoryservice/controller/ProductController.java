package com.example.repositoryservice.controller;

import com.example.repositoryservice.service.ProductService;
import com.example.repositoryservice.viewObjects.ProductVO;
import com.example.repositoryservice.viewObjects.UpdateProductVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Get info of all products")
    @GetMapping
    public List<ProductVO> getProducts(){
        return productService.getProducts();
    }

    @ApiOperation(value = "Update products amount")
    @PutMapping
    void productUpdate(@RequestBody UpdateProductVO updateProductVO){
        productService.updateProduct(updateProductVO);
    }

    @ApiOperation(value = "Get previous updates on products amount")
    @GetMapping("/updates/history")
    List<UpdateProductVO> updatedProducts(){
        return productService.getUpdatedProducts();
    }
}
