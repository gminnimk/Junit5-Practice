package com.sparta.junit5practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ✅ AssertionTest 클래스는 JUnit5의 다양한 Assertion 메서드를 테스트하는 예제입니다.
 *
 *    ➡️ 각 테스트는 Calculator 클래스의 동작을 검증합니다.
 *    ➡️ assertEquals, assertNotEquals, assertTrue, assertFalse, assertNull, assertNotNull, assertThrows 등 다양한 Assertion 사용법을 확인할 수 있습니다.
 */
public class AssertionTest {

    // Calculator 인스턴스 선언
    Calculator calculator;

    /**
     * ✅ 각 테스트 실행 전 Calculator 인스턴스를 초기화하는 메서드.
     *
     *    ➡️ @BeforeEach 어노테이션을 사용하여 각 테스트 전에 자동으로 실행됩니다.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * ✅ assertEquals를 사용하여 연산 결과가 예상한 값과 같은지 테스트합니다.
     *    ➡️ 5를 2로 나눈 결과가 2.5인지 확인합니다.
     */
    @Test
    @DisplayName("assertEquals")
    void test1() {
        Double result = calculator.operate(5, "/", 2);
        assertEquals(2.5, result); // 결과가 2.5와 일치하는지 확인
    }

    /**
     * ✅ assertEquals에 Supplier를 사용하여 실패 시 메시지를 동적으로 생성합니다.
     *
     *    ➡️ 5를 0으로 나누는 잘못된 연산의 결과를 테스트하며, 실패 시 메시지를 출력합니다.
     */
    @Test
    @DisplayName("assertEquals - Supplier")
    void test1_1() {
        Double result = calculator.operate(5, "/", 0);
        // 실패 시 메시지를 동적으로 생성하여 출력
        assertEquals(2.5, result, () -> "연산자 혹은 분모가 0이 아닌지 확인해보세요!");
    }

    /**
     * ✅ assertNotEquals를 사용하여 연산 결과가 예상 값과 다름을 테스트합니다.
     *
     *    ➡️ 5를 0으로 나눈 결과가 2.5가 아닌지 확인합니다.
     */
    @Test
    @DisplayName("assertNotEquals")
    void test1_2() {
        Double result = calculator.operate(5, "/", 0);
        assertNotEquals(2.5, result); // 결과가 2.5와 일치하지 않는지 확인
    }

    /**
     * ✅ assertTrue와 assertFalse를 사용하여 조건이 참인지 거짓인지 테스트합니다.
     *
     *    ➡️ 숫자 9가 유효한 값인지(true), 0이 유효하지 않은 값인지(false) 확인합니다.
     */
    @Test
    @DisplayName("assertTrue 와 assertFalse")
    void test2() {
        assertTrue(calculator.validateNum(9)); // 9는 유효한 숫자인지 확인
        assertFalse(calculator.validateNum(0)); // 0은 유효하지 않은 숫자인지 확인
    }

    /**
     * ✅ assertNotNull과 assertNull을 사용하여 객체가 null인지 아닌지 테스트합니다.
     *
     *    ➡️ 5를 2로 나눈 결과는 null이 아님을 확인하고, 5를 0으로 나눈 결과는 null임을 확인합니다.
     */
    @Test
    @DisplayName("assertNotNull 과 assertNull")
    void test3() {
        Double result1 = calculator.operate(5, "/", 2);
        assertNotNull(result1); // 결과가 null이 아님을 확인
        Double result2 = calculator.operate(5, "/", 0);
        assertNull(result2); // 결과가 null임을 확인
    }

    /**
     * ✅ assertThrows를 사용하여 예외 발생 여부를 테스트합니다.
     *
     *    ➡️ 잘못된 연산자를 사용했을 때 IllegalArgumentException이 발생하는지 확인하고, 예외 메시지도 검증합니다.
     */
    @Test
    @DisplayName("assertThrows")
    void test4() {
        // 잘못된 연산자를 사용할 때 예외가 발생하는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.operate(5, "?", 2));
        // 예외 메시지가 기대한 메시지와 일치하는지 확인
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }
}