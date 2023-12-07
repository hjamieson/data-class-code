package kafkapush;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Publisher implements AutoCloseable{
    private static final Logger LOG = LoggerFactory.getLogger(Publisher.class);
    private KafkaProducer<String, String> kafkaProducer;

    @Override
    public void close() throws Exception {
        // shutdown the kafka publisher
        kafkaProducer.flush();
        kafkaProducer.close();
        LOG.info("closed kafka");
    }

    public void configure(String bootstrap){
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrap);
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducer = new KafkaProducer<>(props);
        LOG.info("kafka producer configured!");
    }

    public void push(String topic, String payload){
        kafkaProducer.send(new ProducerRecord<String,String>(topic, payload));
    }
}
