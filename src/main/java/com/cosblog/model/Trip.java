package com.cosblog.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long tripid;
	
	@Column(nullable = true, length = 10)
	private String tripname;

	@CreationTimestamp
	private Timestamp createdate;

	@OneToMany
	@JoinColumn(name="tripid")
	private List<Attendant> attendant;

	@OneToMany // many = many, User = One
	@JoinColumn(name="tripid")
	private List<Expense> expense;

//	@Column(nullable = true, length = 20)
//	private String attendant;


//	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE) // 연관관계의 주인이 아니다. FK가 아니다. DB에 컬럼을 만들지 마세요.
//	@JsonIgnoreProperties({"board"}) //json을 무시해준다
//	@OrderBy("id desc")
//	private List<Reply> replys;
	
}
