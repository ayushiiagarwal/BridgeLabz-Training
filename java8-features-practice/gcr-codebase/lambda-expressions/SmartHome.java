@FunctionalInterface
interface LightAction{
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {
        LightAction motion = () -> System.out.println("Motion Trigger!");

        LightAction night = () -> System.out.println("Night Trigger!");

        LightAction voice = () -> System.out.println("Voice Trigger!");

        motion.activate();
        night.activate();
        voice.activate();
    }
}
