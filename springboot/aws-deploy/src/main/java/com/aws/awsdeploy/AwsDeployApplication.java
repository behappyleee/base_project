package com.aws.awsdeploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsDeployApplication {
	// TODO
	// URL: https://reflectoring.io/aws-deploy-docker-image-via-web-console/
	// AWS Container 까지 구상 함, docker image 배포하여야 함
	// (linux server 에 docker 까지 설치는 함 AWS 학습 하기, EC2 / ECS / Task / Cluster ...)

	public static void main(String[] args) {
		SpringApplication.run(AwsDeployApplication.class, args);
	}

}
