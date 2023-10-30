#!/bin/bash

set -eu

oc tag --source=docker docker.io/library/bash:5.2 openshift/bash:5.2 --reference-policy=local
oc tag --source=docker docker.io/library/docker:git openshift/docker:git --reference-policy=local
oc tag --source=docker docker.io/library/docker:dind openshift/docker:dind --reference-policy=local