#!/bin/bash
# Calculator build script
echo "Building ..."
lein uberjar
mkdir -p dist
ant bundle-Calculator
echo "Done :D"
