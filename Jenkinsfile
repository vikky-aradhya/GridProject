node {
	stage ('SCM checkout') {
		git 'https://github.com/vikkyaradhya/GridProject.git'
	}
	stage ('Compile-package') {
		bat 'cd GridDocker'
		bat 'mvn clean install'
	}
}
