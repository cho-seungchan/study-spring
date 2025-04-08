package com.app.dependency.injection;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Getter
@Setter
public class Food {
    private final Knife knife;
}
