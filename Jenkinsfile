pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'sh "echo toto"'
      }
    }

    stage('test') {
      agent {
        docker {
          image 'node'
        }

      }
      steps {
        sleep 1
      }
    }

  }
}