package com.springCloud.RestClients;

import com.springCloud.Model.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("GATEWAY-SERVICE")
public interface CouponClient {

    @GetMapping("/couponApi/coupons/{code}")
    Coupon getCoupon(@PathVariable("code") String code);
}
