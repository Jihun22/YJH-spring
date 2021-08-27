package YJH.YJHspring.service;

import YJH.YJHspring.domain.Member;
import YJH.YJHspring.repository.MemberRepository;
import YJH.YJHspring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private  final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
     회원가입
     */
    public  Long join (Member member) {
        //같은 이름이 있는 중복 회원 X
       // Optional<Member> result = memberRepository.findByName(member.getName()); //널이 아니라 값이 있으면 로직 동작
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())

            .ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
}