package newPackage;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

public class Sender {

@Resource(mappedName = "java:jboss/DefaultJMSConnectionFactory")
private static ConnectionFactory connectionFactory;
@Resource(mappedName = "java:jboss/exported/jms/topic/testtopic")
private static Destination topic;
//private static Topic topic;


public void sendToTopic() {
   JMSContext jmsContext = connectionFactory.createContext();
   JMSProducer jmsProducer = jmsContext.createProducer();
   String msg1 = "Test!!!";
   
   System.out.println("Sending the following message: " + msg1);
   jmsProducer.send(topic, msg1);
   
}

}