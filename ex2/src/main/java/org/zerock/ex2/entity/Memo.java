package org.zerock.ex2.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 엔티티를 위한 클래스
@Table(name="tbl_memo") // 테이블의 이름
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id // Primary Key(이하 PK)에 해당하는 특정 필드를 @ID로 지정해야만 합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;
}

// 키 생성 전략
/*
- Auto(default) - JPA의 구현체(스프링 부트에서는 Hibernate)가 생성 방식을 결정
- IDENTITY - 사용하는 데이터베이스가 키 생성을 결정 MySQL이나 MariaDB의 경우 auto increment방식 이용
- SEQUENCE - 데이터베이스의 sequence를 이용해서 키를 생성. @SequenceGenerator와 같이 사용
- TABLE - 키 생성 전용 테이블을 생성해서 키 생성, @TableGenerator와 함께 사용
 */
