#!/bin/bash
rabbitmqctl await_startup
rabbitmqctl add_vhost /qwipper
rabbitmqctl set_permissions -p /qwipper ${RABBITMQ_DEFAULT_USER} ".*" ".*" ".*"