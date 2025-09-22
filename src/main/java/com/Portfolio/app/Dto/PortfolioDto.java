package com.Portfolio.app.Dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDto {

    private Long id;

    @NotBlank
    private String assetname;

    @NotNull
    @Positive
    @Min(value = 1, message = "Quentity minimun 1 honi chahiye")
    @Max(value = 1000, message = "Quentity 1000 se jayeda nhi honi chahiye")
    private Double quantity;

    @NotNull
    @Positive
    private Double price;


    // If We want to show the TimeStamp by user end then We can use it given below Properties.
    /*
    // @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // @Column(nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    //Auto Set
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Auto update
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
        */
}
