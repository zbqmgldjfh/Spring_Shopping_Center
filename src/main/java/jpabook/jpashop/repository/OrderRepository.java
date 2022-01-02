package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    // TODO 동적 쿼리로 검색조건을 통해 검색하기
//    public List<Order> findAll(OrderSearch orderSearch) {
//        em.createQuery("select o from Order o join o.member m", Order.class);
//    }
}
