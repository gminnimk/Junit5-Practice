package com.sparta.junit5practice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * ✅ BeforeAfterTest 클래스는 JUnit5의 `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll`
 *      어노테이션을 사용하여 각 테스트 메서드가 실행되기 전후 및 모든 테스트 실행 전후에 수행되는
 *      로직을 정의하는 예제입니다.
 */
public class BeforeAfterTest {

    /**
     * ✅ 각 테스트 메서드가 실행되기 전에 실행됩니다.
     *
     *    ➡️ 테스트가 실행되기 전에 공통적으로 수행해야 할 작업을 정의할 수 있습니다.
     *    예를 들어, 테스트 환경을 초기화하거나 필요한 리소스를 준비하는 코드를 작성할 수 있습니다.
     */
    @BeforeEach
    void setUp() {
        System.out.println("각각의 테스트 코드가 실행되기 전에 수행");
    }

    /**
     * ✅ 각 테스트 메서드가 실행된 후에 실행됩니다.
     *
     *    ➡️ 테스트가 완료된 후에 공통적으로 수행해야 할 작업을 정의할 수 있습니다.
     *    예를 들어, 테스트에서 사용된 리소스를 정리하거나 연결을 해제하는 코드를 작성할 수 있습니다.
     */
    @AfterEach
    void tearDown() {
        System.out.println("각각의 테스트 코드가 실행된 후에 수행\n");
    }

    /**
     * ✅ 모든 테스트 메서드가 실행되기 전에 최초로 한 번 실행됩니다.
     *
     *    ➡️ `@BeforeAll` 어노테이션이 붙은 메서드는 테스트 클래스 내에서 딱 한 번 실행됩니다.
     *    여기에서는 테스트 실행 전에 전체적으로 필요한 리소스 또는 환경을 설정할 때 사용됩니다.
     *    이 메서드는 `static`으로 선언되어야 합니다.
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("모든 테스트 코드가 실행되기 전에 최초로 수행\n");
    }

    /**
     * ✅ 모든 테스트 메서드가 실행된 후에 마지막으로 한 번 실행됩니다.
     *
     *    ➡️ `@AfterAll` 어노테이션이 붙은 메서드는 모든 테스트가 끝난 후에 딱 한 번 실행됩니다.
     *    테스트가 완료된 후 전체적으로 정리해야 할 리소스나 설정을 해제할 때 사용됩니다.
     *    이 메서드 또한 `static`으로 선언되어야 합니다.
     */
    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트 코드가 수행된 후 마지막으로 수행");
    }

}
