package com.stevy.contratti.service;

import com.stevy.contratti.models.Product;
import com.stevy.contratti.models.ProductDto;

import java.util.List;

public interface DtoService {

    Product ConvertDtoToEntity(ProductDto productDto);
    ProductDto ConvertEntityToDto(Product product);

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(long id, Product product);

    void deleteProduct(long id);

    Product getPostById(long id);

}
