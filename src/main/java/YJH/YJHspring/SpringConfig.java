package YJH.YJHspring;

import YJH.YJHspring.repository.JdbcTemplateMemberRepository;
import YJH.YJHspring.repository.MemberRepository;
import YJH.YJHspring.repository.MemoryMemberRepository;
import YJH.YJHspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public  SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService () {
        return  new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository () {
//        return  new MemoryMemberRepository();
        return  new JdbcTemplateMemberRepository(dataSource);
    }
}
