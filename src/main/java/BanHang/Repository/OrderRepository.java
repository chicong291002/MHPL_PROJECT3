package BanHang.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BanHang.Entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

}