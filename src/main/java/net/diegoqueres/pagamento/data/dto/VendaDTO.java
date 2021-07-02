package net.diegoqueres.pagamento.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import net.diegoqueres.pagamento.entity.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonPropertyOrder({"id","data","produtos","valorTotal"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendaDTO extends RepresentationModel<VendaDTO> implements Serializable {
    private static final long serialVersionUID = 7558388829288444146L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("data")
    private Date data;

    @JsonProperty("valorTotal")
    private Double valorTotal;

    @JsonProperty("produtos")
    private List<ProdutoVendaDTO> produtos;

    public static VendaDTO create(Venda venda) {
        return new ModelMapper().map(venda, VendaDTO.class);
    }
}
