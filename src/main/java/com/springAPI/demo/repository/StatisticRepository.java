package com.springAPI.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springAPI.demo.model.Statistics;

public interface StatisticRepository extends JpaRepository<Statistics, Long>{

}
