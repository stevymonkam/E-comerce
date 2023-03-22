package com.stevy.contratti.payload.response;

import com.stevy.contratti.models.*;

import java.util.List;

public class MessageResponse {

    private  Product product;
    private  ProductDto productDto;
    private  String action;
    private  String status;
    private  boolean success;
    private  String message;
    private Messages messages;
    private User user;
    private List<Category> listcat;
    private List<Product> listp;
    private List<ProductDto> ldto;

    public MessageResponse(String action, boolean b) {
        this.action = action;
        this.success = b;
    }




    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }



    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String action, boolean success, String message, User user) {
        this.action = action;
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public MessageResponse(String action,String status,boolean success,String message,Messages messages) {
        this.action = action;
        this.status = status;
        this.success = success;
        this.message = message;
        this.messages = messages;

    }
    public MessageResponse(String action,String status,boolean success,String message,List<Category> l) {
        this.action = action;
        this.status = status;
        this.success = success;
        this.message = message;
        this.messages = messages;
        this.listcat = l;

    }



    public MessageResponse(String action,String status,boolean success,List<ProductDto> l) {
        this.action = action;
        this.status = status;
        this.success = success;
        this.ldto = l;

    }

    public MessageResponse(String action,String status,String message, ProductDto productDto) {
        this.action = action;
        this.status = status;
        this.message = message;
        this.productDto = productDto;

    }


    public MessageResponse(String action,String status,boolean success,String message) {
        this.action = action;
        this.status = status;
        this.success = success;
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getListp() {
        return listp;
    }

    public void setListp(List<Product> listp) {
        this.listp = listp;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductDto> getLdto() {
        return ldto;
    }

    public void setLdto(List<ProductDto> ldto) {
        this.ldto = ldto;
    }

    public List<Category> getListcat() {
        return listcat;
    }

    public void setListcat(List<Category> listcat) {
        this.listcat = listcat;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
