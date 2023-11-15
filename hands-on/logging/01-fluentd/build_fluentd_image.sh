#!/bin/bash
# 1. Obtain the latest version of the Fluentd container image from Docker Hub
# Use root user to make sure you have enough permission to install fluent-plugin-elasticsearch agent.
podman run -dt --user 0 --name fluentd docker.io/library/fluentd

# 2. Enter the container to install the `fluent-plugin-elasticsearch` agent
podman exec fluentd fluent-gem install fluent-plugin-elasticsearch

# 3. Save the container as a new container image.
podman commit fluentd fluentd-with-es-plugins