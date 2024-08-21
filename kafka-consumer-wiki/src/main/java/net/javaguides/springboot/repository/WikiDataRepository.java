package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.WikiData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface WikiDataRepository extends JpaRepository<WikiData,Long> {

}
