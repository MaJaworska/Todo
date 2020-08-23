package com.majaw.hello;

import com.majaw.lang.Lang;
import com.majaw.lang.LangRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HelloServiceTest {
    @Test
    public void test_nullName_prepareGreeting_returns_fallback() throws Exception {
        //given
        LangRepository mockRepository = getMockLangRepository();
        HelloService SUT = new HelloService(mockRepository);

        //when
        String result = SUT.prepareGreetings(null, -1);

        //then
        String expected = String.format("Hello %s!", HelloService.FALLBACK_NAME);
        assertEquals(expected, result);
    }

    @Test
    public void test_name_prepareGreeting_returns_name() throws Exception {
        //given
        HelloService SUT = new HelloService();
        String name = "test";

        // when
        String result = SUT.prepareGreetings(name, -1);

        //then
        String expected = String.format("Hello %s!", name);
        assertEquals(expected, result);
    }


    private LangRepository getMockLangRepository() {
        return new LangRepository() {
            @Override
            public Optional<Lang> findById(Integer id) {
                return Optional.of(new Lang(null, "Hello", ""));
            }
        };
    }
}
