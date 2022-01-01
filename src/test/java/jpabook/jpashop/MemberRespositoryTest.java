package jpabook.jpashop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRespositoryTest {

    @Autowired
    MemberRepository memberRespository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("Repository 테스트")
    void testMember() {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long saveId = memberRespository.save(member);
        Member findMember = memberRespository.find(saveId);

        // then
        assertThat(member.getId()).isEqualTo(findMember.getId());
        assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
        assertThat(findMember).isEqualTo(member);
    }
}