node {
	def app

	stage('Clone repository') {
		checkout scm
	}

	stage('Clean and Build') {
		sh './gradlew clean build deploy -Pliferay.workspace.environment=dev'
	}

	stage('Bundle') {
		sh './gradlew distBundleTar -Pliferay.workspace.environment=dev'
	}

	stage('Theme') {
		dir('modules/themebuckettheme-theme'){
			sh 'npm install'
			sh 'gulp build'
		}
	}
	
}
