package ru.sbt.mipt.oop.signalisation;

public class SignalisationActivated implements State {
    public Signalisation signalisation;

    public SignalisationActivated(Signalisation signalisation) {
        this.signalisation = signalisation;
    }

    @Override
    public void activate(String someCode) {
        System.out.println("Signalisation already activated");
    }

    @Override
    public void deactivate(String someCode) {
        if (signalisation.secretCodeChecker(someCode)){
            System.out.println("Vveden verniy cod, dectiviruus'");
            signalisation.setState(new SignalisationDeactivated(signalisation));
        } else {
            System.out.println("Ty yavno poputal");
            AlarmMassageSender.send();
            signalisation.setState(new Alarm(signalisation));
        }
    }

    @Override
    public void toAlarmState(String secretCode) {
        signalisation.setState(new Alarm(signalisation));
    }
}
