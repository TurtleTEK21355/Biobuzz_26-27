package org.firstinspires.ftc.libcode.library.internal.pid;

public class PController {

    double target;
    double error;
    double tolerance;
    double proportional;
    double p;


    public PController(double proportional, double target, double tolerance){
        this.p = proportional;
        this.target = target;
        this.tolerance = tolerance;
    }

    public void setTargetPosition(double target) { this.target = target; }
    public double getTargetPosition() { return target; }

    public double calculate(double current){
        error = target - current;
        proportional = error;
        return proportional * p;

    }

    /**
     * tells if the absolute distance from target is greater than the tolerance
     * @param current the current position
     */
    public boolean atTarget(double current){
        double distance = target - current;
        return (Math.abs(distance) <= tolerance);

    }

}
