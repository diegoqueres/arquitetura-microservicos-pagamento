package net.diegoqueres.pagamento.entity;

import lombok.*;
import net.diegoqueres.pagamento.data.dto.VendaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "venda")
public class Venda implements Serializable {
    private static final long serialVersionUID = -6574176733192416711L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "valor_total", nullable = false, length=10)
    private Double valorTotal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = {CascadeType.REFRESH})
    private List<ProdutoVenda> produtos;

    public static Venda create(VendaDTO vendaDTO) {
        return new ModelMapper().map(vendaDTO, Venda.class);
    }
}
