package hello.springmvc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
@Data -> @Setter, @Getter, @ToString
         @EqualsAndHashCode, @RequiredArgsConstructor
         자동 적용
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HelloData {
    private String username;
    private int age;

}
