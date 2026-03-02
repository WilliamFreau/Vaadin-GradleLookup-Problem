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


### `package.json` with maven or gradle without `application.properties`

```json
 "dependencies": {
    "@f0rce/lit-ace": "1.11.1",
    "@polymer/polymer": "3.5.2",
    "@vaadin/bundles": "24.9.10",
    "@vaadin/common-frontend": "0.0.19",
    "@vaadin/polymer-legacy-adapter": "24.9.10",
    "@vaadin/react-components": "24.9.10",
    "@vaadin/vaadin-development-mode-detector": "2.0.7",    "@vaadin/vaadin-lumo-styles": "24.9.10",
    "@vaadin/vaadin-material-styles": "24.9.10",
    "@vaadin/vaadin-themable-mixin": "24.9.10",
    "@vaadin/vaadin-usage-statistics": "2.1.3",
    "construct-style-sheets-polyfill": "3.1.0",
    "date-fns": "2.29.3",
    "lit": "3.3.2",
    "react": "18.3.1",
    "react-dom": "18.3.1",
    "react-router": "7.12.0"
  },
```

### `package.json` with gradle and `vaadin.allowed-package` in `application.properties`

```json
  "dependencies": {
    "@polymer/polymer": "3.5.2",
    "@vaadin/bundles": "24.9.10",
    "@vaadin/common-frontend": "0.0.19",
    "@vaadin/polymer-legacy-adapter": "24.9.10",
    "@vaadin/react-components": "24.9.10",
    "@vaadin/vaadin-development-mode-detector": "2.0.7",
    "@vaadin/vaadin-lumo-styles": "24.9.10",
    "@vaadin/vaadin-material-styles": "24.9.10",
    "@vaadin/vaadin-themable-mixin": "24.9.10",
    "@vaadin/vaadin-usage-statistics": "2.1.3",
    "construct-style-sheets-polyfill": "3.1.0",
    "date-fns": "2.29.3",
    "lit": "3.3.2",
    "react": "18.3.1",
    "react-dom": "18.3.1",
    "react-router": "7.12.0"
  },
```

## Reproduce
Test the configuration with this project which is the same project based on Maven and Gradle
Mind to delete `package.json` and `package-lock.json` in order to force the lookup

