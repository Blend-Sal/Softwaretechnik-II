package com.example.softwaretechnik2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DemoRepo extends CrudRepository<Demo, Long> {

}
