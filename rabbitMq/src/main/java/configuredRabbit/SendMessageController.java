package configuredRabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendMessageController {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public SendMessageController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @PostMapping("/it")
    public String sendMessage(@RequestParam String theMessage){
        System.out.println("tjhtghfghfghfgh");
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME,"sagi.#",theMessage);
        return "We have Sent A message "+ theMessage;

    }
}
