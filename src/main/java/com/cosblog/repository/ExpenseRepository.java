package com.cosblog.repository;

import com.cosblog.model.Attendant;
import com.cosblog.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}

