package in.himtech.kafka.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Simple demo of KafkaProducer to produce payload into kafka topic and getting acknowledgement.
 * @author himanshu
 */

public class ProducerWithAcksTest {
	
	public static void main(String[] args) {
		
		//Configure property of kafka producer.
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		//Create kafkaProducer object
		Producer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", "15th March ");
		
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				String acks = String.format("Acknowledge Details: topic=%s, partition=%d, offsets=%d", metadata.topic(), metadata.partition(), metadata.offset() );
				System.out.println(acks);
				
			}
		});
		producer.flush();
		producer.close();
		
	}

}
