package utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderState {
    GENERATED("generada"),
    PROCESSING("en proceso"),
    CANCELLED("cancelada"),
    SHIPPED("enviada");

    private final String state;
}
