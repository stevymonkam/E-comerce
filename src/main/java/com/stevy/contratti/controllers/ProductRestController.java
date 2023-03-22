package com.stevy.contratti.controllers;

import com.stevy.contratti.models.Category;
import com.stevy.contratti.models.Messages;
import com.stevy.contratti.models.Product;
import com.stevy.contratti.models.ProductDto;
import com.stevy.contratti.payload.response.MessageResponse;
import com.stevy.contratti.repository.CategoryRepository;
import com.stevy.contratti.repository.ProductRepository;
import com.stevy.contratti.repository.UserRepository;
import com.stevy.contratti.service.DtoService;
import com.stevy.contratti.service.email.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ProductRestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private DtoService dtoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/product/create")
    public ResponseEntity<MessageResponse> create(@Valid @RequestBody ProductDto productDto) {
        // convert DTO to Entity
        Product productRequest = dtoService.ConvertDtoToEntity(productDto);

        Product product = dtoService.createProduct(productRequest);

        // convert entity to DTO
        ProductDto postResponse = dtoService.ConvertEntityToDto(product);
        System.out.println("le produit avantt  dto 8888888888888888");
        System.out.println(postResponse);
       // postResponse.setIdCat(productDto.getIdCat());

        return ResponseEntity.ok(new MessageResponse("create product111", "ok11","product create success111",postResponse));
    }

    @GetMapping("/product/list")
    public ResponseEntity<MessageResponse> getAllPosts() {

        List<ProductDto> lst = dtoService.getAllProducts().stream().map(product -> dtoService.ConvertEntityToDto(product))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new MessageResponse("List Products", "ok", true, lst));
    }

    @PutMapping("/product/update/{id}")
    public ResponseEntity<MessageResponse>updatePost(@PathVariable long id, @RequestBody ProductDto productDto) {

        // convert DTO to Entity
        Product postRequest = dtoService.ConvertDtoToEntity(productDto);

        Product product = dtoService.updateProduct(id, postRequest);

        // entity to DTO
        ProductDto postResponse = dtoService.ConvertEntityToDto(product);

        return ResponseEntity.ok(new MessageResponse("update product", "ok","product update success",postResponse));
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<MessageResponse> deletePost(@PathVariable(name = "id") Long id) {
        dtoService.deleteProduct(id);
        return ResponseEntity.ok(new MessageResponse("delete product success"));
    }
}










