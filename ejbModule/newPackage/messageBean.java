package newPackage;

import javax.ejb.ActivationConfigProperty;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.ejb.ActivationConfigProperty;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: messageBean
 */
@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "queue/testqueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class messageBean implements MessageListener {

	@Inject
	Sender sender;
	
    /**
     * Default constructor. 
     */
    public messageBean() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
    	System.out.println("Hey bean!"); 
    	
    	sender.sendToTopic();
    	// send to topic
    }
    
    

}
