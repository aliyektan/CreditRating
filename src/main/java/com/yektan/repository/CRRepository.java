package com.yektan.repository;

import com.yektan.model.CreditRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yektan on 1.01.2018.
 */

@Repository // Spring data kullanarak DAO yazma yükünden kurtularak tüm fonksiyonları kendi modelime uyarladım.
public interface CRRepository extends JpaRepository<CreditRating, Integer> {
}
