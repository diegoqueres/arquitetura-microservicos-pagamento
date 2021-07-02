package net.diegoqueres.pagamento.entity;

import lombok.*;
import net.diegoqueres.pagamento.data.dto.ProdutoVendaDTO;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "produto_venda")
public class ProdutoVenda implements Serializable {
    private static final long serialVersionUID = 5562431236844042526L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_produto", nullable = false, length=10)
    private Long idProduto;

    @Column(name = "quantidade", nullable = false, length=10)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venda")
    private Venda venda;

    public static ProdutoVenda create(ProdutoVendaDTO produtoVendaDTO) {
        return new ModelMapper().map(produtoVendaDTO, ProdutoVenda.class);
    }
}
