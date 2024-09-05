package com.sparta.junit5practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * ✅ RepeatTest 클래스는 JUnit 5의 반복 테스트와 파라미터화된 테스트에 대한 예시입니다.
 *
 *    ➡️ 반복 테스트는 동일한 테스트를 여러 번 실행해야 할 때 사용됩니다.
 *    ➡️ 파라미터화된 테스트는 여러 다른 입력 값으로 동일한 테스트를 실행할 때 유용합니다.
 */
public class RepeatTest {

    /**
     * ✅ RepeatedTest 어노테이션을 사용하여 테스트를 5번 반복합니다.
     *
     *    ➡️ {currentRepetition}과 {totalRepetitions}를 사용해 반복 횟수를 표시할 수 있습니다.
     *    ➡️ RepetitionInfo를 통해 현재 반복 횟수와 전체 반복 횟수 정보를 가져올 수 있습니다.
     *
     * @param info 현재 반복 회차 및 총 반복 횟수에 대한 정보를 담고 있는 객체.
     */
    @RepeatedTest(value = 5, name = "반복 테스트 {currentRepetition} / {totalRepetitions}")
    void repeatTest(RepetitionInfo info) {
        // 현재 반복 횟수와 총 반복 횟수를 출력
        System.out.println("테스트 반복 : " + info.getCurrentRepetition() + " / " + info.getTotalRepetitions());
    }

    /**
     * ✅ ParameterizedTest 어노테이션을 사용하여 여러 파라미터 값으로 테스트를 실행합니다.
     *
     *    ➡️ ValueSource를 통해 여러 int 값들을 전달하여 테스트를 반복합니다.
     *    ➡️ 각 파라미터 값마다 테스트가 실행되며, num 변수에 각 값이 주입됩니다.
     *
     * @param num ValueSource에서 제공되는 각 정수 값.
     */
    @DisplayName("파라미터 값 활용하여 테스트 하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void parameterTest(int num) {
        // 각 파라미터 값에 대해 5와의 곱셈 결과를 출력
        System.out.println("5 * num = " + 5 * num);
    }
}