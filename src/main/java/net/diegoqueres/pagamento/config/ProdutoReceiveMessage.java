package net.diegoqueres.pagamento.config;

import net.diegoqueres.pagamento.data.dto.ProdutoDTO;
import net.diegoqueres.pagamento.entity.Produto;
import net.diegoqueres.pagamento.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoReceiveMessage {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RabbitListener(queues = {"${crud.rabbitmq.queue}"})
    public void receive(@Payload ProdutoDTO produtoDTO) {
        Produto produto = Produto.create(produtoDTO);
        produtoRepository.save(produto);
    }
}
