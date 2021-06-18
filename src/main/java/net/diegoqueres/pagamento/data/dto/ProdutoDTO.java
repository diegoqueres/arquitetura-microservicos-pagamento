package net.diegoqueres.pagamento.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import net.diegoqueres.pagamento.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id","estoque"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoDTO extends RepresentationModel<ProdutoDTO> implements Serializable {
    private static final long serialVersionUID = 4483872295807264582L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("estoque")
    private Integer estoque;

    public static ProdutoDTO create(Produto produto) {
        return new ModelMapper().map(produto, ProdutoDTO.class);
    }
}
