def call(String project_name, String tags){
  sh "docker build -t ${project_name}:${tags} ."
}
