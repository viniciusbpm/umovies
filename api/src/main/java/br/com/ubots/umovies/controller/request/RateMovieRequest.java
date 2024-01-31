package br.com.ubots.umovies.controller.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateMovieRequest {
    @NotNull(message = "You have to add a value")
    @Min(value = 1, message = "The value must be greater than 0")
    @Max(value = 5, message = "The value must be less or equal to 5")
    private int value;
}
