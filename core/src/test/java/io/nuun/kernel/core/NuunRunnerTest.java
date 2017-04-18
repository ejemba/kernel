package io.nuun.kernel.core;

import org.junit.Test;

public class NuunRunnerTest
{
    public static class MyApp {
        
    }

    @Test
    public void test()
    {
        NuunRunner.entrypoint(MyApp.class).execute(new String[]{"--option1" , "stuff"});
    }

}
