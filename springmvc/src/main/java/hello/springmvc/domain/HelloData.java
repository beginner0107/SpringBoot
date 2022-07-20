package hello.springmvc.domain;

import lombok.Data;
/*
@Data -> @Setter, @Getter, @ToString
         @EqualsAndHashCode, @RequiredArgsConstructor
         자동 적용
 */
@Data
public class HelloData {
    private String username;
    private int age;
}
