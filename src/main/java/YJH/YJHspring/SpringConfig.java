package YJH.YJHspring;

import YJH.YJHspring.repository.MemberRepository;
import YJH.YJHspring.repository.MemoryMemberRepository;
import YJH.YJHspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService () {
        return  new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository () {
        return  new MemoryMemberRepository();
    }
}
