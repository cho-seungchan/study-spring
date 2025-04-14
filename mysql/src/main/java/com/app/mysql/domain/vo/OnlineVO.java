package com.app.mysql.domain.vo;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OnlineVO{
    @EqualsAndHashCode.Include
    private Long id;
    private String marketName;

    @Builder
    public OnlineVO(Long id, String marketName) {
        this.id = id;
        this.marketName = marketName;
    }
}
