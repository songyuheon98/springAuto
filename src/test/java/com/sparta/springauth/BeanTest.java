package com.sparta.springauth;

import com.sparta.springauth.food.Food;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanTest {

    @Autowired
    @Qualifier("pizza")
    Food food;

    @Test
    @DisplayName("Primary 와 Qualifier 우선순위 확인")
    void test1() {
        // 현재 Chicken 은 Primary 가 적용된 상태
        // Pizza는 Qualifier 가 추가된 상태입니다.
        food.eat();
    }
}