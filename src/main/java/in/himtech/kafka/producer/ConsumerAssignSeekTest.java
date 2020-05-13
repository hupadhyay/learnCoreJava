package in.himtech.kafka.producer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * In this program we assign a partition to the consumer and offset to read
 * from. The consumer will read from that partition and from that offsets
 * 
 * @author himanshu
 *
 */
public class ConsumerAssignSeekTest {
	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		Consumer<String, String> consumer = new KafkaConsumer<>(properties);
		TopicPartition partition = new TopicPartition("first_topic", 0);
		consumer.assign(Arrays.asList(partition));
		consumer.seek(partition, 1L);
		
		String strExit = "";
		while(!strExit.equals("exit")) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			for(ConsumerRecord<String, String> record : records) {
				strExit = record.value();
				String data = String.format("Key: %s, Payload: %s, topic: %s, partition: %d, offset: %d", record.key(), record.value(), record.topic(), record.partition(), record.offset());
				System.out.println(data);
			}
		}
		consumer.close();
	}
}
