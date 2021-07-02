package net.diegoqueres.pagamento.services;

import net.diegoqueres.pagamento.data.dto.VendaDTO;
import net.diegoqueres.pagamento.entity.ProdutoVenda;
import net.diegoqueres.pagamento.entity.Venda;
import net.diegoqueres.pagamento.exception.ResourceNotFoundException;
import net.diegoqueres.pagamento.repository.ProdutoRepository;
import net.diegoqueres.pagamento.repository.ProdutoVendaRepository;
import net.diegoqueres.pagamento.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoVendaRepository produtoVendaRepository;

    public VendaDTO create(VendaDTO vendaDTO) {
        Venda venda = vendaRepository.save(Venda.create(vendaDTO));

        List<ProdutoVenda> produtosSalvos = new ArrayList<>();
        vendaDTO.getProdutos().forEach(p -> {
            ProdutoVenda pv = ProdutoVenda.create(p);
            pv.setVenda(venda);
            produtosSalvos.add(produtoVendaRepository.save(pv));
        });
        venda.setProdutos(produtosSalvos);

        return VendaDTO.create(venda);
    }

    public Page<VendaDTO> findAll(Pageable pageable) {
        var page = vendaRepository.findAll(pageable);
        return page.map(this::convertToVendaDTO);
    }

    private VendaDTO convertToVendaDTO(Venda venda) {
        return VendaDTO.create(venda);
    }

    public VendaDTO findById(Long id) {
        var entity = vendaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return VendaDTO.create(entity);
    }
}
