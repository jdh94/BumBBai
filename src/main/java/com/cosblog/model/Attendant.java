package com.cosblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Attendant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long attendantid;

	@Column
	@JoinColumn(name="tripid")
	private Long tripid;

	@Column(nullable = true, length = 10)
	private String attendantname;

	@CreationTimestamp
	private Timestamp createdate;


	//eager 바로 가져와준다.
//	@ManyToOne(fetch = FetchType.EAGER) // many = many, User = One
//	@JoinColumn(name="userId")
//	private User user;  // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	
//	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE) // 연관관계의 주인이 아니다. FK가 아니다. DB에 컬럼을 만들지 마세요.
//	@JsonIgnoreProperties({"board"}) //json을 무시해준다
//	@OrderBy("id desc")
//	private List<Reply> replys;
	
}