package in.himtech.kafka.producer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

/** 

 * @author himanshu
 *
 */
public class ConsumerTest {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "first_appln");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		Consumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		consumer.subscribe(Arrays.asList("first_topic"));
		
		String valCondition = "";
		while(!valCondition.equals("exit")) {
			ConsumerRecords<String, String> conRecords  = consumer.poll(Duration.ofMillis(500));
			
			for(ConsumerRecord<String, String> record : conRecords) {
				valCondition = record.value();
				String data = String.format("Key: %s, Payload: %s, topic: %s, partition: %d, offset: %d", record.key(), record.value(), record.topic(), record.partition(), record.offset());
				System.out.println(data);
			}
		}
		consumer.close();
		
	}

}
