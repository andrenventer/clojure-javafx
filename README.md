# Desktop Application

A calculator desktop application for OS X written with Clojure and JavaFX.

## Usage

You need Lein, Maven and Ant

Download and install "jfxrt.jar" into your local Maven repository.

## Build

```
build.sh
```

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

## Install the JavaFX runtime

```
mvn install:install-file  \
 -Dfile=$JFXRTPATH/jfxrt.jar \
 -DgroupId=com.oracle \
 -DartifactId=javafx-runtime \
 -Dpackaging=jar \
 -Dversion=2.2.0
```
