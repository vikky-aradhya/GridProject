node {
	stage ('SCM checkout') {
		git 'https://github.com/vikkyaradhya/GridProject.git'
	}
	stage ('Compile-package') {
		dir("GridDocker") {
			bat 'mvn clean install'
		}
	}
}
