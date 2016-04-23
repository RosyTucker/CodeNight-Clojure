# codenight

![Build Status](https://snap-ci.com/RosyTucker/CodeNight/branch/master/build_image)

CodeNight is an organisation aimed at pairing up experienced and less experienced developers in order to solve problems together ... and have beer. This repository holds the source code for the codenight backend.

## Prerequisites

You will need [Leiningen](https://github.com/technomancy/leiningen) 2.6.1 or above installed, as well as the [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html).
You will also need to install postgres.

## Run

To start a local web server for the application, run:

    lein run

This will start the development server at [http://localhost:3000](http://localhost:3000)

## Database

To set up postgres locally run the following:

    initdb pg
    postgres -D pg &
    

* If these executables aren’t found, try adding `/usr/lib/postgresql/*/bin to your $PATH`.

Then create a local database

    createdb codenight


## Test

    lein test

## License

Copyright © 2016 Rose Tucker, MIT License
