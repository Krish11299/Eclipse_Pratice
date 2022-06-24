package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Long>{

}
