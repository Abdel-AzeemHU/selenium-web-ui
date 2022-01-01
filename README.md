# Overview

Automated test scripts for [this website](http://the-internet.herokuapp.com/)

## Allure Report

Upon test run, there will be a `allure-results` directory right in the project root directory

### Generate the report

```shell
allure generate --clean
allure open --port 8000
```

### Allure report installation

```shell
sudo npm install -g allure-commandline
```

## Containerized Tests

### docker

```shell
docker-compose up -d
```

### podman

```shell
podman-compose up -d
```

#### Installation

```shell
sudo apt-get update -y
sudo apt-get install curl wget gnupg2 -y
source /etc/os-release 
sudo sh -c "echo 'deb http://download.opensuse.org/repositories/devel:/kubic:/libcontainers:/stable/xUbuntu_${VERSION_ID}/ /' > /etc/apt/sources.list.d/devel:kubic:libcontainers:stable.list"

wget -nv https://download.opensuse.org/repositories/devel:kubic:libcontainers:stable/xUbuntu_${VERSION_ID}/Release.key -O- | sudo apt-key add -

sudo apt-get update -qq -y
sudo apt-get -qq --yes install podman

pip3 install podman-compose
sudo ln -s ~/.local/bin/podman-compose /usr/bin/podman-compose
```