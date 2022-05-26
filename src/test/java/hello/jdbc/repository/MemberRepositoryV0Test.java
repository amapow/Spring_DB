package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@Slf4j
class MemberRepositoryV0Test {

    MemberRepositoryV0 repository = new MemberRepositoryV0();

    @Test
    void crud() throws SQLException {

        //save
        Member member = new Member("memberV1", 10000);
        repository.save(member);

        //findById
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember = {}", findMember);
        Assertions.assertThat(findMember).isEqualTo(member);

        //update
        int money = 40000;
        repository.update(money, member.getMemberId());
        findMember = repository.findById(member.getMemberId());
        log.info("findMember = {}", findMember);
        Assertions.assertThat(findMember.getMoney()).isEqualTo(money);

        //delete
        String deleteMemberId = member.getMemberId();
        repository.delete(deleteMemberId);
        Assertions.assertThatThrownBy(() -> repository.findById(deleteMemberId))
                .isInstanceOf(NoSuchElementException.class);
    }
}