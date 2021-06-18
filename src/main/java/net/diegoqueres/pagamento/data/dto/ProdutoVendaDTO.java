package net.diegoqueres.pagamento.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import net.diegoqueres.pagamento.entity.ProdutoVenda;
import net.diegoqueres.pagamento.entity.Venda;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@JsonPropertyOrder({"id","idProduto","quantidade"})
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProdutoVendaDTO extends RepresentationModel<ProdutoVendaDTO> implements Serializable {
    private static final long serialVersionUID = 2975322724918401402L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idProduto")
    private Long idProduto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    public static ProdutoVendaDTO create(ProdutoVenda produtoVenda) {
        return new ModelMapper().map(produtoVenda, ProdutoVendaDTO.class);
    }

}
