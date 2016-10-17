#!/bin/bash
# Calculator build script
echo "Building ..."
lein uberjar
ant bundle-Calculator
echo "Done :D"
