package frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class LED extends SubsystemBase{
    private static final int kDeviceAddress = 4;
    private I2C i2c;

    public LED() {
        i2c = new I2C(I2C.Port.kMXP, kDeviceAddress);
    }

    private void writeByte(int input) {

        byte data = (byte) input;
    
        // Writes bytes over I2C
        i2c.write(0, data);
    }

    public void clearLED() {
        int d1= (1*16); //Strip number times 16 to shift to first 4 bits of byte
        int d2= (2*16);
        int d3= (3*16);
        int d4= (4*16);
        writeByte(d1); 
        writeByte(d2);
        writeByte(d3);
        writeByte(d4); //This is a mess, add a special clear case in Arduino later
    }

    public void setLED(int strip, int function) { //X marks what strip to use, Y marks function
        int data = ((strip*16)|function);
        writeByte(data);
        System.out.println("test");
    }
////////////////////// REMOVE AFTER TESTING //////////////////////
    // @Override
    // public void periodic(){
    //     System.out.println("LEDSubsystem");
    //     clearLED(); //Turn off LED strip at start
        
    //     setLED(1,1); //Set strip 1 to function 1
    // }
}
