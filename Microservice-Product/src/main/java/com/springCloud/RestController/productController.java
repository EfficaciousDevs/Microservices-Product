package com.springCloud.RestController;

import com.springCloud.Model.Coupon;
import com.springCloud.Model.Product;
import com.springCloud.Repository.ProductRepository;
import com.springCloud.RestClients.CouponClient;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productApi")
public class productController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CouponClient couponClient;

    @PostMapping("/products")
    @Retry(name = "product-api",fallbackMethod = "handleError")
    public Product addProduct(@RequestBody Product product){
        Coupon coupon = couponClient.getCoupon(product.getCouponCode());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productRepository.findById(id);
    }

    public Product handleError(Product product,Exception exception){
        System.out.println("Inside Error Handler");
        return product;
    }
}
