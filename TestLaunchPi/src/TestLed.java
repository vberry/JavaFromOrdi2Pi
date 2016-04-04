import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.system.NetworkInfo;
import java.io.IOException;
import java.text.ParseException;


// NE FONCTIONNE PAS POUR L'INSTANT pour allumer une LED connectee au shield Grove : 
// il faut probablement PASSER obligatoirement PAR une librairie Grove
// qui sait comment parler le micro-ctrler équivalent d'Arduino qui pilote ce shield

public class TestLed {

 public static void main(String[] args) throws InterruptedException, IOException, ParseException {

    // display a few of the available system information properties
    System.out.print("\n\n\tRunning on" + NetworkInfo.getHostname());
    for (String ipAddress : NetworkInfo.getIPAddresses())
        System.out.println(" (IP " + ipAddress+")\n");

	  
    System.out.println("<--Pi4J--> GPIO Control Example ... started.");
    
    // create gpio controller
    final GpioController gpio = GpioFactory.getInstance();
    
    // provision gpio pin #01 as an output pin and turn on
    final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.HIGH);

    // set shutdown state for this pin
    pin.setShutdownOptions(true, PinState.LOW);

    System.out.println("--> GPIO state should be: ON");

    Thread.sleep(5000);
    
    // turn off gpio pin #02
    pin.low();
    System.out.println("--> GPIO state should be: OFF");

    Thread.sleep(5000);

    // toggle the current state of gpio pin #02 (should turn on)
    pin.toggle();
    System.out.println("--> GPIO state should be: ON");

    Thread.sleep(5000);

    // toggle the current state of gpio pin #02  (should turn off)
    pin.toggle();
    System.out.println("--> GPIO state should be: OFF");
    
    Thread.sleep(5000);

    // turn on gpio pin #02hs  for 1 second and then off
    System.out.println("--> GPIO state should be: ON for only 1 second");
    pin.pulse(1000, true); // set second argument to 'true' use a blocking call
    
    // stop all GPIO activity/threads by shutting down the GPIO controller
    // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
    gpio.shutdown();
 }
}
