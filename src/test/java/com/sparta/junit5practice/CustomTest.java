package com.sparta.junit5practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * ✅ CustomTest 클래스는 JUnit 5에서 테스트를 그룹화하고,
 *    테스트의 순서를 지정하며, 각 테스트의 목적을 명확히 하기 위한 예시입니다.
 */
public class CustomTest {

    /**
     * ✅ 개별 테스트 메서드입니다.
     *
     *    ➡️ 테스트의 내용을 @DisplayName 어노테이션을 사용하여 가독성을 높이고,
     *        메서드명이 아닌 의도한 테스트의 목적을 명확히 표시할 수 있습니다.
     */
    @Test
    @DisplayName("테스트의 내용을 한눈에 알아볼 수 있게 네이밍 해줄 수 있습니다.")
    void test1() {
        // 테스트 수행 중 출력되는 내용
        System.out.println("테스트의 수행 내용들을 빠르게 파악할 수 있습니다.");
    }

    /**
     * ✅ @Nested 어노테이션을 통해 하위 테스트 그룹을 생성할 수 있습니다.
     *
     *    ➡️ 이 그룹 내에서 여러 테스트를 순서대로 실행할 수 있으며,
     *        @Order 어노테이션을 사용하여 실행 순서를 지정할 수 있습니다.
     */
    @Nested
    @DisplayName("주제 별로 테스트를 그룹지어서 파악하기 좋습니다.")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 테스트 실행 순서를 지정하는 어노테이션
    class Test1 {

        /**
         * ✅ 이 테스트는 해당 테스트 그룹의 첫 번째로 실행됩니다.
         */
        @Order(1)
        @Test
        @DisplayName("Test1 클래스") // 테스트에 대한 설명을 쉽게 이해할 수 있도록 추가
        void test() {
            System.out.println("\nTest1 클래스");
        }

        /**
         * ✅ 이 테스트는 세 번째로 실행됩니다.
         */
        @Order(3)
        @Test
        @DisplayName("Test1 - test1()") // 의도를 명확히 하기 위한 테스트 이름
        void test1() {
            System.out.println("Test1.test1");
        }

        /**
         * ✅ 이 테스트는 두 번째로 실행됩니다.
         */
        @Order(2)
        @Test
        @DisplayName("Test1 - test2()") // 설명을 명확히 하기 위한 테스트 이름
        void test2() {
            System.out.println("Test1.test2");
        }
    }

    /**
     * ✅ 또 다른 주제를 가진 테스트 그룹입니다.
     *
     *    ➡️ @Nested 어노테이션을 사용하여 주제 별로 테스트를 나눌 수 있습니다.
     */
    @Nested
    @DisplayName("Test2 다른 주제") // 이 그룹이 다른 주제를 다루고 있음을 표시
    class Test2 {

        /**
         * ✅ Test2 그룹의 첫 번째 테스트입니다.
         */
        @Test
        @DisplayName("Test2 - test1()")
        void test1() {
            System.out.println("Test2.test1");
        }

        /**
         * ✅ Test2 그룹의 두 번째 테스트입니다.
         */
        @Test
        @DisplayName("Test2 - test2()")
        void test2() {
            System.out.println("Test2.test2");
        }
    }
}