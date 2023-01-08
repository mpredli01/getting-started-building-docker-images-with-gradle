package org.gradle;

import com.bmuschko.gradle.docker.DockerJavaApplicationPlugin;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("*----------------------------------------------------*");
        System.out.println("| Getting Started Building Docker Images with Gradle |");
        System.out.println("*----------------------------------------------------*");

        DockerJavaApplicationPlugin dockerJavaApplicationPlugin = new DockerJavaApplicationPlugin();
        try {
            dockerJavaApplicationPlugin.wait(10000);
            }
        catch(InterruptedException exception) {
            exception.getMessage();
            }
        }
    }
