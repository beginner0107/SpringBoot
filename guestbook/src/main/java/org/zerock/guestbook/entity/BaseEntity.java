package org.zerock.guestbook.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 해당 어노테이션이 적용된 클래스는 테이블로 생성되지 않는다.
                  // 실제 테이블은 BaseEntity클래스를 상속한 엔티티의 클래스로 데이터베이스 테이블이 생성
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;

}

// JPA는 JPA만의 고유한 메모리 공간을 이용해서 엔티티 객체들을 관리
// 기존의 MyBatis 기반의 프로그램과 달리 단계가 하나 더 있는 방식