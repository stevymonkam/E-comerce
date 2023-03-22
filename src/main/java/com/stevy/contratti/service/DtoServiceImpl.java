package com.stevy.contratti.service;

import com.stevy.contratti.models.Category;
import com.stevy.contratti.models.Product;
import com.stevy.contratti.models.ProductDto;
import com.stevy.contratti.repository.CategoryRepository;
import com.stevy.contratti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.List;

@Service
public class DtoServiceImpl implements DtoService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public DtoServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product ConvertDtoToEntity(ProductDto productDto) {


        try {
            Product product = new Product();
              //product.setId(productDto.getId());
              product.setAvailable(productDto.isAvailable());
              product.setDescription(productDto.getDescription());
              product.setCurrentprice(productDto.getCurrentprice());
              product.setName(productDto.getName());
              product.setPhotoName(productDto.getPhotoName());
              product.setPromotion(productDto.isPromotion());
              product.setSelected(productDto.isSelected());
              Category c = categoryRepository.findById(productDto.getIdCat()).get();
              product.setCategory(c);
            return product;

        } catch (Exception e) {
            throw new RuntimeException("Could not create the product. Error: " + e.getMessage());
        }

    }

    @Override
    public ProductDto ConvertEntityToDto(Product product) {
        try {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setAvailable(product.isAvailable());
            productDto.setDescription(product.getDescription());
            productDto.setCurrentprice(product.getCurrentprice());
            productDto.setName(product.getName());
            productDto.setPhotoName(product.getPhotoName());
            productDto.setPromotion(product.isPromotion());
            productDto.setSelected(product.isSelected());
            Category c = product.getCategory();
            productDto.setIdCat(c.getId());
            return productDto;

        } catch (Exception e) {
            throw new RuntimeException("Could not create 2 the product. Error: " + e.getMessage());
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(long id, Product productRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product"));

        product.setAvailable(productRequest.isAvailable());
        product.setDescription(productRequest.getDescription());
        product.setCurrentprice(productRequest.getCurrentprice());
        product.setName(productRequest.getName());
        product.setPhotoName(productRequest.getPhotoName());
        product.setPromotion(productRequest.isPromotion());
        product.setSelected(productRequest.isSelected());
        Category c = categoryRepository.findById(productRequest.getCategory().getId()).get();
        product.setCategory(c);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product"));

        productRepository.delete(product);

    }

    @Override
    public Product getPostById(long id) {
        return null;
    }
}
