#!/bin/bash

if [[ -z ${IS_CI} ]];
then
    echo "Open xcode locally"
    open *.xcworkspace
else
    echo "Ignore opening xcode on CI"
fi