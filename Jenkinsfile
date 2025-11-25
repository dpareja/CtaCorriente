pipeline {
    agent any
    
    tools {
        maven 'Maven'
    }
    
    stages {
        stage('Etapa 1: Preparación del Proyecto') {
            steps {
                echo 'Integrando repositorio remoto...'
                git branch: 'main', url: 'https://github.com/<usuario>/CtaCorriente.git'
            }
        }
        
        stage('Etapa 2: Construcción del Proyecto') {
            steps {
                echo 'Compilando el proyecto...'
                sh 'mvn clean compile'
            }
        }
        
        stage('Etapa 3: Ejecución de Pruebas') {
            steps {
                echo 'Ejecutando pruebas...'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
                }
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline ejecutado exitosamente'
        }
        failure {
            echo 'Pipeline falló'
        }
    }
}
