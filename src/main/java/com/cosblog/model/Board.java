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
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob
	private String content; // 섬머노트 라이브러리 <html>태그가 섞여서 디자인이 됨.

	private int count; // 조회수

	//eager 바로 가져와준다.
	@ManyToOne(fetch = FetchType.EAGER) // many = many, User = One
	@JoinColumn(name="userId")
	private User user;  // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE) // 연관관계의 주인이 아니다. FK가 아니다. DB에 컬럼을 만들지 마세요.
	@JsonIgnoreProperties({"board"}) //json을 무시해준다
	@OrderBy("id desc")
	private List<Reply> replys;

	@CreationTimestamp
	private Timestamp createDate;

	@Column
	private String fileName;
	@Column
	private String filePath;

}
