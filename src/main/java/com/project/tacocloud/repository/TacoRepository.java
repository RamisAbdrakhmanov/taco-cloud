package com.project.tacocloud.repository;

import com.project.tacocloud.model.Taco;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TacoRepository  extends JpaRepository<Taco, Long> {

}
