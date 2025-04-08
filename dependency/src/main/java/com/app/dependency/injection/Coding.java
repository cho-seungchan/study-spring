package com.app.dependency.injection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
//spring에게 객체를 bean container에 등록해 달라고 요청해주는 어노테이션
@Component
@Getter
@Setter
@RequiredArgsConstructor
// final 키워드가 붙어 있거나 @NonNull 키워드가 붙어 있는 필드를 대상으로 초기화 생성자를 만들어준다.
public class Coding {
    private final Computer computer;

//    필드주입(생성 후 주입 :: private final Computer computer 선언 시 오류)
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
//    @Autowired
//    private Computer computer;

//    setter 주입 (생성 후 주입 :: private final Computer computer 선언 시 오류)
//    주입된 객체를 불변(immutable) 상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    생성 시점에서는 순환 참조 발생 여부를 알 수 없다.
//    화면으로부터 값을 받을 때에는 spring이 setter 주입을 통해 객체를 넣기 때문에 필수적이다.
//    private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//  생성자 주입(생성과 동시에 주입)
//    private final Computer computer;
//
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
