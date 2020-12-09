node {
	stage ('SCM checkout') {
		git 'https://github.com/vikkyaradhya/GridProject.git'
	}
	stage ('Compile-package') {
		sh 'mvn clean install'
	}
}
