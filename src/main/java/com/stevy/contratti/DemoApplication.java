package com.stevy.contratti;

import com.stevy.contratti.models.Category;
import com.stevy.contratti.models.ERole;
import com.stevy.contratti.models.Product;
import com.stevy.contratti.models.Role;
import com.stevy.contratti.repository.CategoryRepository;
import com.stevy.contratti.repository.ProductRepository;
import com.stevy.contratti.repository.RoleRepository;
import com.stevy.contratti.service.FileContratService;
import com.stevy.contratti.service.email.UserService;
import net.bytebuddy.utility.RandomString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.Random;

@SpringBootApplication
public class DemoApplication implements  CommandLineRunner{
    @Resource
    FileContratService fileContratService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

   /* @Bean
    CommandLineRunner start(UserService userService) {
        return args->{
            fileContratService.deleteAll();
            fileContratService.init();
             //contraService.compareDate3(1l);
             //contraService.ListInterrogazione("2021-09-06","2021-09-06","2021-09-06");


        };
    }*/
    @Override
    public void run(String... args) throws  Exception {
      /* categoryRepository.save(new Category(null,"Ordinateur",null,null,null));
        categoryRepository.save(new Category(null,"Printers",null,null,null));
        categoryRepository.save(new Category(null,"Smart phones",null,null,null));

        Random rn = new Random();
        categoryRepository.findAll().forEach(c->{
            Product p=new Product();
            System.out.println("dans la category 222222222222222222222222222222222222");
            System.out.println();
            p.setName(RandomString.make(18));
            p.setCurrentprice(100+rn.nextInt(10000));
            p.setAvailable(rn.nextBoolean());
            p.setPromotion(rn.nextBoolean());
            p.setSelected(rn.nextBoolean());
            p.setCategory(c);
            p.setPhotoName("");
            productRepository.save(p);
        });



       for(int i=0; i<2; i++){

            if(i==0){
                Role r = new Role();
                r.setName(ERole.ROLE_USER);
                roleRepository.save(r);
            }
            if(i==1){
                Role r = new Role();
                r.setName(ERole.ROLE_ADMIN);
                roleRepository.save(r);
            }

        }

*/

    }
}
