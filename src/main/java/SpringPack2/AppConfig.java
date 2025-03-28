package SpringPack2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
//    @Scope("singleton")
    @Scope("prototype")
    @Bean
    public SpringHelloWorld2 aaa()
    {
        return new SpringHelloWorld2();
    }
    @Bean("innerClass23")
    public InnerClass2 getInnerClass2()
    {
        return new InnerClass2();
    }
    @Bean("massage")
    public String getMyMessage()
    {
        return "Hello World!!!";
    }
    @Bean("innerMessage33")
    public String getMySharkMessage()
    {
        return "Hello Shark!!!";
    }
}
