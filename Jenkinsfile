pipeline {
    agent any
    
    tools {
        maven 'Maven'
    }
    
    stages {
        stage('Etapa 1: Preparación del Proyecto') {
            steps {
                echo 'Integrando repositorio remoto...'
                git branch: 'main', url: 'https://github.com/dpareja/CtaCorriente.git'
            }
        }
        
        stage('Etapa 2: Construcción del Proyecto') {
            steps {
                echo 'Compilando el proyecto...'
                sh 'mvn clean package -DskipTests'
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
        
        stage('Etapa 4: Deploy a JFrog') {
            steps {
                echo 'Subiendo artefacto a JFrog Artifactory...'
                sh 'mvn deploy -DskipTests'
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
