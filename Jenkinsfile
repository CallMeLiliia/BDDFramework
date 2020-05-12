node('master') { 
   
   stage('Checkout') { 
     git 'https://github.com/CallMeLiliia/BDDFramework.git'
   }
   try{
   stage('Build') {
      bat label: '', script: 'mvn verify'
   }
   }catch(Exception e){
       echo "Build failed"
   }
   
   stage('Report') {
       cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
       junit '**/*Cucumber.xml'
   }
   stage('Email'){
       step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: 'kulish.liliia2@gmail.com ', sendToIndividuals: false])
   }
}
