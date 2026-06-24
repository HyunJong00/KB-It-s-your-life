package spring.config;

import com.study.sample01.MessageBeanImpl;
import com.study.sample02.CalcAdd;
import com.study.sample02.CalcMul;
import org.springframework.context.annotation.Bean;

public class SpringConfiguration {
    @Bean
    public MessageBeanImpl message(){
        return new MessageBeanImpl("딸기");
    }

    @Bean
    public CalcAdd calcadd(){
        return new CalcAdd(25, 26);
    }

    @Bean
    public CalcMul calcMul(){
        return new CalcMul(24,5);
    }
}
