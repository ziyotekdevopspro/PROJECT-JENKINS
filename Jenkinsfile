pipeline {
    agent any
	environment {
		IMAGE_TAG = "1.0"
		DOCKERHUB_CREDENTIALS = credentials('iamkhaihoang-dockerhub')
		GITHUB_REPO_NAME = "iamkhaihoang/devops16-app"
		IMAGE_NAME = "${GITHUB_REPO_NAME}:${IMAGE_TAG}"
		JENKINS_DEPLOYED_MACHINE = "192.168.37.111"
	}
    stages {
        stage("Build Application") {
            steps {
                sh """
                    javac project_app.java
                """
            }
        }
        stage("Build Image of the Application") {
            steps {
                sh """
        		    docker build -t $IMAGE_NAME .
                """
            }
        }		
        stage("DockerHub Login") {
            steps {
                sh('echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin')
            }
        }		
	stage("Push") {
            steps {
                sh """
			        docker push $IMAGE_NAME
                """
            }
        }
	stage("Deploy") {
            steps {
        		
				sh(' ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOYED_MACHINE docker system prune -f')
				sh(' ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOYED_MACHINE docker rmi $IMAGE_NAME > /dev/null 2>&1')
				sh(' ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOYED_MACHINE docker pull $IMAGE_NAME')
				sh('#ssh -o StrictHostKeyChecking=no $JENKINS_DEPLOYED_MACHINE docker run -it $IMAGE_NAME')
		    
            }
        }
    }
	post {
		always {
			sh 'docker logout'
		}
	}
}
