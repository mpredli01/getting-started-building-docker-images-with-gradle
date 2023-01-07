package org.gradle;

import com.bmuschko.gradle.docker.DockerJavaApplicationPlugin;
import com.bmuschko.gradle.docker.DockerRemoteApiPlugin;
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage;
import org.gradle.api.Project;
import org.gradle.api.model.ObjectFactory;
import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer;
import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer.HostConfig;
import com.bmuschko.gradle.docker.tasks.image.Dockerfile;

import javax.inject.Inject;

public class MainApp {

    private final HostConfig hostConfig = null;

    public static void main(String[] args) {

        // MainApp mainApp = new MainApp();

        System.out.println("*----------------------------------------------------*");
        System.out.println("| Getting Started Building Docker Images with Gradle |");
        System.out.println("*----------------------------------------------------*");

        DockerRemoteApiPlugin dockerRemoteApiPlugin = new DockerRemoteApiPlugin();
        System.out.println(dockerRemoteApiPlugin.getMetaClass());

        DockerJavaApplicationPlugin dockerJavaApplicationPlugin = new DockerJavaApplicationPlugin();
        System.out.println(dockerJavaApplicationPlugin.getMetaClass());

        }
    }
