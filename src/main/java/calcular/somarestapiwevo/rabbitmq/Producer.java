package calcular.somarestapiwevo.rabbitmq;

import calcular.somarestapiwevo.models.Calc;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper mapper;    /*Mensagem em JSON*/

    @SneakyThrows
    public void enviar(Calc calc){
        rabbitTemplate.convertAndSend(queue.getName(), mapper.writeValueAsString(calc));
    }
}
