package net.javaguides.springboot;

import net.javaguides.springboot.entity.WikiData;
import net.javaguides.springboot.repository.WikiDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikiDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikiDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId = "myGroup"
    )
    public void consume(String eventMessgae){
        LOGGER.info(String.format("Message Received -> %s",eventMessgae));
        WikiData wikimediaData = new WikiData();
        wikimediaData.setWikiEvent(eventMessgae);
        dataRepository.save(wikimediaData);



    }
}
