package hello.springmvc.basic.requestMapping;

import lombok.Data;


//@Data 사용시 @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 자동 적용
@Data
public class HelloData {
    private String username;
    private int age;
}
