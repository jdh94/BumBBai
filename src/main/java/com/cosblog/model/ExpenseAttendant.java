package com.cosblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ExpenseAttendant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long expenseid;

	@Column
	private Long Attendantid;

	@CreationTimestamp
	private Timestamp createdate;
}
