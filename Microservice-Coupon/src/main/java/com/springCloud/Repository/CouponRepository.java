package com.springCloud.Repository;

import com.springCloud.Model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {
    Coupon findByCode(String code);
}
