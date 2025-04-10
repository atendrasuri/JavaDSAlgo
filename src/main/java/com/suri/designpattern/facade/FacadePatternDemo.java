package com.suri.designpattern.facade;

// Subsystem 1: Amplifier
class Amplifier {
    void turnOn() {
        System.out.println("Amplifier is ON");
    }
    void turnOff() {
        System.out.println("Amplifier is OFF");
    }
}

// Subsystem 2: DVD Player
class DVDPlayer {
    void play() {
        System.out.println("DVD is playing");
    }
    void stop() {
        System.out.println("DVD stopped");
    }
}

// Subsystem 3: Projector
class Projector {
    void turnOn() {
        System.out.println("Projector is ON");
    }
    void turnOff() {
        System.out.println("Projector is OFF");
    }
}

// **Facade**: Simplifies complex interactions
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector proj) {
        this.amplifier = amp;
        this.dvdPlayer = dvd;
        this.projector = proj;
    }

    // Simplified method to start movie
    public void watchMovie() {
        System.out.println("\nStarting movie...");
        amplifier.turnOn();
        projector.turnOn();
        dvdPlayer.play();
    }

    // Simplified method to stop movie
    public void endMovie() {
        System.out.println("\nStopping movie...");
        dvdPlayer.stop();
        projector.turnOff();
        amplifier.turnOff();
    }
}

// Client Code
public class FacadePatternDemo {
    public static void main(String[] args) {
        // Creating subsystem objects
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector proj = new Projector();

        // Using the Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, proj);

        // Client calls only simple methods instead of dealing with subsystems
        homeTheater.watchMovie();
        homeTheater.endMovie();
    }
}
