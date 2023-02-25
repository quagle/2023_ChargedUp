package frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;

public class LED extends SubsystemBase{
    private I2C i2c;
    private byte[] dataBuffer;
    
    public LED() {
        i2c = new I2C(I2C.Port.kMXP, 0x42); //USE MXP I2C
        dataBuffer = new byte[1];
    }

    public void clearLED() {
        dataBuffer[0] = 0x00;
        i2c.writeBulk(dataBuffer);
    }

    public void setLED(int strip, int function) { //X marks what strip to use, Y marks function
        dataBuffer[0] = (byte) ((strip*16)&function);
        i2c.writeBulk(dataBuffer);

    }
}
