package com.cosblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long expenseid;

//	@Column
//	@JoinColumn(name="tripid")
//	private Long tripid;

	@Column
	private Long expenseprice;

	@Column(nullable = true, length = 10)
	private String expensename;

	@CreationTimestamp
	private Timestamp createdate;

	@OneToMany
	@JoinColumn(name="attendantid")
	private List<ExpenseAttendant> attendantid;

}
