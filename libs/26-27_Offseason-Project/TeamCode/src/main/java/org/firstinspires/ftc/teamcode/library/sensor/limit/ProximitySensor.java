package org.firstinspires.ftc.teamcode.library.sensor.limit;

public interface ProximitySensor {
    default boolean inProximity(){
        return false;
    }
}