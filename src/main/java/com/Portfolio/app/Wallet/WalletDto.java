package com.Portfolio.app.Wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WalletDto {

    private Long walletId;

    @NotNull
    @Positive
    private Double balance;
}
