package com.app.mysql.domain.dto;

import com.app.mysql.domain.vo.OnlineVO;
import com.app.mysql.domain.vo.ProductVO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OnlineDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String marketName;

    public OnlineVO toVO() {
        return OnlineVO.builder()
                .id(id)
                .marketName(marketName)
                .build();
    }
}










