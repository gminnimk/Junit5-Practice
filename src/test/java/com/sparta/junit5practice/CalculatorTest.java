package com.sparta.junit5practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * ✅ CalculatorTest 클래스는 Calculator 클래스의 연산 기능을 테스트합니다.
 *
 *    ➡️ 연산 성공 및 실패 시의 동작을 검증합니다.
 *    ➡️ JUnit5의 다양한 assertion 메서드를 사용하여 테스트 결과를 확인합니다.
 *
 *
 *
 *      📢 Given
 *
 *          설명: 테스트가 실행되기 전에 설정해야 하는 사전 조건을 정의합니다.
 *          역할: 테스트가 시작될 때 어떤 상태나 상황이 준비되어야 하는지를 설명합니다.
 *          예시: 데이터베이스에 특정 데이터가 저장되어 있거나, 특정 객체가 초기화되어 있어야 하는 경우.
 *
 *      📢 When
 *
 *          설명: 특정 행동이나 이벤트가 발생하는 시점을 정의합니다.
 *          역할: 테스트 중에 실행되는 핵심 기능이나 메서드를 호출합니다.
 *          예시: 특정 메서드를 호출하거나, 특정 사용자 입력을 시뮬레이션하는 경우.
 *
 *      📢 Then
 *
 *          설명: 예상되는 결과나 상태를 검증합니다.
 *          역할: Given과 When에서 설정한 조건을 바탕으로, 실제 결과가 예상과 일치하는지 확인합니다.
 *          예시: 메서드의 반환값이 예상 값과 일치하는지, 객체의 상태가 올바른지 확인하는 경우.
 *
 */
class CalculatorTest {

    // Calculator 인스턴스 선언
    Calculator calculator;

    /**
     * ✅ 각 테스트 전에 Calculator 인스턴스를 초기화하는 메서드.
     *
     *    ➡️ @BeforeEach를 사용하여 각 테스트가 실행되기 전에 호출됩니다.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * ✅ 계산기의 연산 성공 시나리오를 테스트합니다.
     *
     *    ➡️ 5를 2로 나눈 결과가 2.5가 되는지 확인합니다.
     */
    @Test
    @DisplayName("계산기 연산 성공 테스트")
    void test1() {
        // given: 테스트에 사용할 입력값 설정
        int num1 = 5;
        String op = "/";
        int num2 = 2;

        // when: 실제로 연산을 수행
        Double result = calculator.operate(num1, op, num2);

        // then: 결과가 null이 아니며, 2.5와 일치하는지 확인
        assertNotNull(result);
        assertEquals(2.5, result);
    }

    /**
     * ✅ 분모가 0인 경우 계산기의 연산 실패 시나리오를 테스트합니다.
     *
     *    ➡️ 5를 0으로 나눌 때 결과가 null임을 확인합니다.
     */
    @Test
    @DisplayName("계산기 연산 실패 테스트 : 분모가 0일 경우")
    void test1_1() {
        // given: 분모를 0으로 설정
        int num1 = 5;
        String op = "/";
        int num2 = 0;

        // when: 실제로 연산을 수행
        Double result = calculator.operate(num1, op, num2);

        // then: 결과가 null인지 확인
        assertNull(result);
    }

    /**
     * ✅ 잘못된 연산자를 사용했을 때 계산기의 연산 실패 시나리오를 테스트합니다.
     *
     *    ➡️ 유효하지 않은 연산자 '?'를 사용할 때 IllegalArgumentException이 발생하는지 확인합니다.
     */
    @Test
    @DisplayName("계산기 연산 실패 테스트 : 연산자가 잘못됐을 경우")
    void test1_2() {
        // given: 잘못된 연산자 설정
        int num1 = 5;
        String op = "?";
        int num2 = 2;

        // when - then: 연산 시 IllegalArgumentException이 발생하는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.operate(5, "?", 2));
        // 예외 메시지가 예상한 메시지와 일치하는지 확인
        assertEquals("잘못된 연산자입니다.", exception.getMessage());
    }
}