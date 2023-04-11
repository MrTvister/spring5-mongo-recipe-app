package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * Created by jt on 6/21/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private String id;
    private String recipeId;
    @NotBlank
    private String description;
    @NonNull
    @Min(1)
    private BigDecimal amount;
    @NonNull
    private UnitOfMeasureCommand uom;
}
