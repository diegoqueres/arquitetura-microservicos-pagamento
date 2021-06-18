package net.diegoqueres.pagamento.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 5767807106163365196L;

    @Id
    private Long id;

    @Column(name = "estoque", nullable = false, length=10)
    private Integer estoque;

}
