# Problem

## According to the documentation


https://vaadin.com/docs/latest/flow/integrations/spring/configuration#configure-packages-scanning

Using: `vaadin.allowed-packaged` or `vaadin.blocked-packages` is used to decrease lookup time while Vaadin look for all required dependecy

Since Vaadin 24.5 we can add: `src/main/resources/META-INF/VAADIN/package.properties`
In order to add some lookup for the jar content

## Problem

| Build-System | `vaadin.allowed-packaged` in `application.properties` | `vaadin.allowed-packaged` in `package.properties` | Dependency is found                                 |
|--------------|-------------------------------------------------------|---------------------------------------------------|-----------------------------------------------------|
| Maven        | No information                                        | `vaadin.allowed-packaged=de.f0rce`                 | Everything is working                               |
| Gradle       | No information                                        | `vaadin.allowed-packaged=de.f0rce`                 | Everything is working                               |
| Maven        | `vaadin.allowed-packaged=com.example`                 | `vaadin.allowed-packaged=de.f0rce`                 | Everything is working                               |
| Gradle       | `vaadin.allowed-packaged=com.example`                 | `vaadin.allowed-packaged=de.f0rce`                 | **`de.f0rce` Npm package is not present in package.json** |

So Gradle plugin did not lookup correctly the package found

## Reproduce
Test the configuration with this project which is the same project based on Maven and Gradle


