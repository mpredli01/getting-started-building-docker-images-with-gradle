package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `buildsrclibs` extension.
*/
@NonNullApi
public class LibrariesForBuildsrclibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AsciidoctorLibraryAccessors laccForAsciidoctorLibraryAccessors = new AsciidoctorLibraryAccessors(owner);
    private final AsciidoctorjLibraryAccessors laccForAsciidoctorjLibraryAccessors = new AsciidoctorjLibraryAccessors(owner);
    private final GradleLibraryAccessors laccForGradleLibraryAccessors = new GradleLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForBuildsrclibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for grgit (org.ajoberstar:grgit)
         * This dependency was declared in catalog buildsrc.libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGrgit() { return create("grgit"); }

        /**
         * Creates a dependency provider for shadow (gradle.plugin.com.github.johnrengelman:shadow)
         * This dependency was declared in catalog buildsrc.libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getShadow() { return create("shadow"); }

    /**
     * Returns the group of libraries at asciidoctor
     */
    public AsciidoctorLibraryAccessors getAsciidoctor() { return laccForAsciidoctorLibraryAccessors; }

    /**
     * Returns the group of libraries at asciidoctorj
     */
    public AsciidoctorjLibraryAccessors getAsciidoctorj() { return laccForAsciidoctorjLibraryAccessors; }

    /**
     * Returns the group of libraries at gradle
     */
    public GradleLibraryAccessors getGradle() { return laccForGradleLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AsciidoctorLibraryAccessors extends SubDependencyFactory {
        private final AsciidoctorJvmLibraryAccessors laccForAsciidoctorJvmLibraryAccessors = new AsciidoctorJvmLibraryAccessors(owner);

        public AsciidoctorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at asciidoctor.jvm
         */
        public AsciidoctorJvmLibraryAccessors getJvm() { return laccForAsciidoctorJvmLibraryAccessors; }

    }

    public static class AsciidoctorJvmLibraryAccessors extends SubDependencyFactory {

        public AsciidoctorJvmLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for plugin (org.asciidoctor:asciidoctor-gradle-jvm)
             * This dependency was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPlugin() { return create("asciidoctor.jvm.plugin"); }

    }

    public static class AsciidoctorjLibraryAccessors extends SubDependencyFactory {
        private final AsciidoctorjTabbedLibraryAccessors laccForAsciidoctorjTabbedLibraryAccessors = new AsciidoctorjTabbedLibraryAccessors(owner);

        public AsciidoctorjLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at asciidoctorj.tabbed
         */
        public AsciidoctorjTabbedLibraryAccessors getTabbed() { return laccForAsciidoctorjTabbedLibraryAccessors; }

    }

    public static class AsciidoctorjTabbedLibraryAccessors extends SubDependencyFactory {
        private final AsciidoctorjTabbedCodeLibraryAccessors laccForAsciidoctorjTabbedCodeLibraryAccessors = new AsciidoctorjTabbedCodeLibraryAccessors(owner);

        public AsciidoctorjTabbedLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at asciidoctorj.tabbed.code
         */
        public AsciidoctorjTabbedCodeLibraryAccessors getCode() { return laccForAsciidoctorjTabbedCodeLibraryAccessors; }

    }

    public static class AsciidoctorjTabbedCodeLibraryAccessors extends SubDependencyFactory {

        public AsciidoctorjTabbedCodeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for extension (com.bmuschko:asciidoctorj-tabbed-code-extension)
             * This dependency was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getExtension() { return create("asciidoctorj.tabbed.code.extension"); }

    }

    public static class GradleLibraryAccessors extends SubDependencyFactory {
        private final GradleGitLibraryAccessors laccForGradleGitLibraryAccessors = new GradleGitLibraryAccessors(owner);

        public GradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at gradle.git
         */
        public GradleGitLibraryAccessors getGit() { return laccForGradleGitLibraryAccessors; }

    }

    public static class GradleGitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public GradleGitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for git (org.ajoberstar:gradle-git)
             * This dependency was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("gradle.git"); }

            /**
             * Creates a dependency provider for publish (org.ajoberstar:gradle-git-publish)
             * This dependency was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getPublish() { return create("gradle.git.publish"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AsciidoctorVersionAccessors vaccForAsciidoctorVersionAccessors = new AsciidoctorVersionAccessors(providers, config);
        private final AsciidoctorjVersionAccessors vaccForAsciidoctorjVersionAccessors = new AsciidoctorjVersionAccessors(providers, config);
        private final GradleVersionAccessors vaccForGradleVersionAccessors = new GradleVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: grgit (1.9.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<String> getGrgit() { return getVersion("grgit"); }

            /**
             * Returns the version associated to this alias: shadow (7.1.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<String> getShadow() { return getVersion("shadow"); }

        /**
         * Returns the group of versions at versions.asciidoctor
         */
        public AsciidoctorVersionAccessors getAsciidoctor() { return vaccForAsciidoctorVersionAccessors; }

        /**
         * Returns the group of versions at versions.asciidoctorj
         */
        public AsciidoctorjVersionAccessors getAsciidoctorj() { return vaccForAsciidoctorjVersionAccessors; }

        /**
         * Returns the group of versions at versions.gradle
         */
        public GradleVersionAccessors getGradle() { return vaccForGradleVersionAccessors; }

    }

    public static class AsciidoctorVersionAccessors extends VersionFactory  {

        private final AsciidoctorJvmVersionAccessors vaccForAsciidoctorJvmVersionAccessors = new AsciidoctorJvmVersionAccessors(providers, config);
        public AsciidoctorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.asciidoctor.jvm
         */
        public AsciidoctorJvmVersionAccessors getJvm() { return vaccForAsciidoctorJvmVersionAccessors; }

    }

    public static class AsciidoctorJvmVersionAccessors extends VersionFactory  {

        public AsciidoctorJvmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: asciidoctor.jvm.plugin (3.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<String> getPlugin() { return getVersion("asciidoctor.jvm.plugin"); }

    }

    public static class AsciidoctorjVersionAccessors extends VersionFactory  {

        private final AsciidoctorjTabbedVersionAccessors vaccForAsciidoctorjTabbedVersionAccessors = new AsciidoctorjTabbedVersionAccessors(providers, config);
        public AsciidoctorjVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.asciidoctorj.tabbed
         */
        public AsciidoctorjTabbedVersionAccessors getTabbed() { return vaccForAsciidoctorjTabbedVersionAccessors; }

    }

    public static class AsciidoctorjTabbedVersionAccessors extends VersionFactory  {

        private final AsciidoctorjTabbedCodeVersionAccessors vaccForAsciidoctorjTabbedCodeVersionAccessors = new AsciidoctorjTabbedCodeVersionAccessors(providers, config);
        public AsciidoctorjTabbedVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.asciidoctorj.tabbed.code
         */
        public AsciidoctorjTabbedCodeVersionAccessors getCode() { return vaccForAsciidoctorjTabbedCodeVersionAccessors; }

    }

    public static class AsciidoctorjTabbedCodeVersionAccessors extends VersionFactory  {

        public AsciidoctorjTabbedCodeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: asciidoctorj.tabbed.code.extension (0.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<String> getExtension() { return getVersion("asciidoctorj.tabbed.code.extension"); }

    }

    public static class GradleVersionAccessors extends VersionFactory  {

        private final GradleGitVersionAccessors vaccForGradleGitVersionAccessors = new GradleGitVersionAccessors(providers, config);
        public GradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.gradle.git
         */
        public GradleGitVersionAccessors getGit() { return vaccForGradleGitVersionAccessors; }

    }

    public static class GradleGitVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public GradleGitVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: gradle.git (1.7.1)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog buildsrc.libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("gradle.git"); }

            /**
             * Returns the version associated to this alias: gradle.git.publish (0.3.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog buildsrc.libs.versions.toml
             */
            public Provider<String> getPublish() { return getVersion("gradle.git.publish"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
