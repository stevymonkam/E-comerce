package com.stevy.contratti.controllers;

import com.stevy.contratti.models.Category;
import com.stevy.contratti.models.Product;
import com.stevy.contratti.payload.response.MessageResponse;
import com.stevy.contratti.repository.CategoryRepository;
import com.stevy.contratti.repository.ProductRepository;
import com.stevy.contratti.repository.UserRepository;
import com.stevy.contratti.service.email.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class CatalogueRestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/catalogue/list")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<MessageResponse> Listcatalogue() throws ParseException {
        List<Category> lst = (List<Category>) categoryRepository.findAll();

        return ResponseEntity.ok(new MessageResponse("List categorie", "ok", true, "list of categories", lst));
    }


    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public  byte[] getPhoto(@PathVariable(name = "id") Long id) throws IOException {
        System.out.println("le produit avantt  111111111111111111111111111111111111111111111");
        System.out.println(id);
        Product p = productRepository.findById(id).get();
        System.out.println("le produit   111111111111111111111111111111111111111111111");
        System.out.println(p.getPhotoName());
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));//System.getProperty("user.home") si on est en production il vas dans le dossier ou se trouve l'app

    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto( @RequestParam("file") MultipartFile file, @RequestParam Long idcat, @PathVariable Long id) throws  Exception{
        Product p = productRepository.findById(id).get();
        Category c = categoryRepository.findById(idcat).get();
        p.setPhotoName(file.getOriginalFilename());
        p.setCategory(c);
        Files.write(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()),file.getBytes());
        productRepository.save(p);

    }
}