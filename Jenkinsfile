pipeline {
    agent any
	environment {
		IMAGE_TAG = "1.1"
		DOCKERHUB_CREDENTIALS = credentials('iamkhaihoang-dockerhub')
		GITHUB_REPO_NAME = "iamkhaihoang/devops16-app"
		IMAGE_NAME = "${GITHUB_REPO_NAME}:${IMAGE_TAG}"
		JENKINS_DEPLOY_MACHINE = "192.168.37.111"
	}
    stages {
        stage("Build Application") {
            steps {
                sh """
                    javac project_app.java
                """
            }
        }
        stage("Build Docker Image of the Application") {
            steps {
                sh """
        		    docker build -t $IMAGE_NAME .
                """
            }
        }			
	stage("Push the Image to DockerHub") {
            steps {
		        sh('echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin')
                sh('docker push $IMAGE_NAME')
            }
        }
	stage("Deploy") {
            steps {
        	sh """	
			ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOY_MACHINE docker rmi -f $IMAGE_NAME
			ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOY_MACHINE docker pull $IMAGE_NAME			
		"""    
            }
        }
    }
	post {
		always {
			sh 'docker logout'
		}
	}
}
