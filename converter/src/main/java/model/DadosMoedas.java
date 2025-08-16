package model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMoedas(
        @JsonAlias("base_code") String sigla,
        @JsonAlias("conversion_rates") Map<String, Double> valor
) {
}
