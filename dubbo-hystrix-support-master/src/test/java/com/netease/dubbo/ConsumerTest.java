package com.netease.dubbo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.dubbo.service.EchoService;

/**
 * Created by yangshaokai on 2018/2/7.
 */
public class ConsumerTest {

    EchoService echoService;

    @Before
    public void before() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();
        echoService = (EchoService) context.getBean("echoService", EchoService.class);
    }

    @Test
    public void test() {
        Assert.assertEquals("Hello World", echoService.echo());

    }

    @Test
    public void testTimeout() {
        Assert.assertEquals("Hello World", echoService.echoWithTimeOut());
    }

    @Test
    public void testEchoException() {
        echoService.echoWithException();
    }
}
