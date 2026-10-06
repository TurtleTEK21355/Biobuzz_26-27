package org.firstinspires.ftc.libcode.library.sensor.limit;

public interface ProximitySensor {
    default boolean inProximity(){
        return false;
    }
}