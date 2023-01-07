package org.gradle;

import com.bmuschko.gradle.docker.DockerJavaApplication;
import com.bmuschko.gradle.docker.DockerJavaApplicationPlugin;
import com.bmuschko.gradle.docker.DockerRemoteApiPlugin;
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage;
// import org.gradle.api.model.ObjectFactory;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Gradle Docker Plugin");
        DockerRemoteApiPlugin dockerRemoteApiPlugin = new DockerRemoteApiPlugin();
        DockerJavaApplicationPlugin dockerJavaApplicationPlugin = new DockerJavaApplicationPlugin();
        DockerBuildImage dockerBuildImage = new DockerBuildImage();
        }
    }
