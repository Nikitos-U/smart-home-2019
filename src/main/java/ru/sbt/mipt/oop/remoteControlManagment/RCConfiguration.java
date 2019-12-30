package ru.sbt.mipt.oop.remoteControlManagment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.SmartHomeConfiguration;
import ru.sbt.mipt.oop.rc.RemoteControl;
import ru.sbt.mipt.oop.rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.remoteControlManagment.commands.*;

@Configuration
public class RCConfiguration {
    @Bean
    public RemoteControl remoteControl(SignalisationActivationCommand activate,
                                             @Qualifier("AllLightsOn") AllLightsCommand AllLightsOn,
                                             @Qualifier("AllLightsOff") AllLightsCommand AllLightsOff,
                                             CloseHallDoorCommand closeHallDoor,
                                             AlarmActivationCommand alarm,
                                             TurnOnHallLightsCommand hallLightsOn,
                                             RemoteControlRegistry remoteControlRegistry) {
        SmartHomeRC rc = new SmartHomeRC("1");
        rc.addCommand("A", activate);
        rc.addCommand("B", AllLightsOn);
        rc.addCommand("C", AllLightsOff);
        rc.addCommand("D", closeHallDoor);
        rc.addCommand("1", alarm);
        rc.addCommand("2", hallLightsOn);
        remoteControlRegistry.registerRemoteControl(rc, "1");
        return rc;
    }

    @Bean
    public RemoteControlRegistry remoteControlRegistry(){
        return new RemoteControlRegistry();
    }

    @Bean
    public SignalisationActivationCommand activate(SmartHome smartHome) {
        return new SignalisationActivationCommand(smartHome);
    }

    @Bean
    public AllLightsCommand AllLightsOn(SmartHome smartHome) {
        return new AllLightsCommand(smartHome, true);
    }

    @Bean
    public AllLightsCommand AllLightsOff(SmartHome smartHome) {
        return new AllLightsCommand(smartHome, false);
    }

    @Bean
    public CloseHallDoorCommand closeHallDoor(SmartHome smartHome) {
        return new CloseHallDoorCommand(smartHome);
    }

    @Bean
    public AlarmActivationCommand alert(SmartHome smartHome) {
        return new AlarmActivationCommand(smartHome);
    }

    @Bean
    public TurnOnHallLightsCommand hallLightsOn(SmartHome smartHome) {
        return new TurnOnHallLightsCommand(smartHome);
    }
}