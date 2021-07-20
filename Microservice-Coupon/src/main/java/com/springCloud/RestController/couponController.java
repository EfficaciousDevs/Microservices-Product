package com.springCloud.RestController;

import com.springCloud.Model.Coupon;
import com.springCloud.Repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponApi")
public class couponController {

    @Autowired
    private CouponRepository couponRepository;

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }
}
