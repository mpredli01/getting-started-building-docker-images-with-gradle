package org.gradle;

import com.bmuschko.gradle.docker.DockerJavaApplicationPlugin;
import com.bmuschko.gradle.docker.internal.RegistryAuthLocator;

import com.github.dockerjava.api.model.AuthConfig;

public class MainApp {

    public static void main(String[] args) {
        System.out.println("*----------------------------------------------------*");
        System.out.println("| Getting Started Building Docker Images with Gradle |");
        System.out.println("*----------------------------------------------------*");

        DockerJavaApplicationPlugin dockerJavaApplicationPlugin = new DockerJavaApplicationPlugin();
        RegistryAuthLocator registryAuthLocator = new RegistryAuthLocator();
        AuthConfig authConfig = new AuthConfig();
        System.out.println(authConfig.getAuth());
        System.out.println(registryAuthLocator.lookupAllAuthConfigs().toString());
        }
    }
