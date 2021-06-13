# azurewithcosmos
# How to deploy spirngboot with cosmos db application
# Creating the docker image and pushing into  Azure container registery  
# Deploying the docker image into Azure Kubernates service cluster

# Prerequisites 
  1. Azure subcription you should have
  2. Create the Azure container registery
  3. Create the azure cosmos DB account
  4. Create the AKS service and Kubernates cluster
  
  
# POM changes :

1. We need to deal with the AZURE container reg to push the generated artifact jar, for that we need to add below plugin once you created the project .

<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>docker-maven-plugin</artifactId>
				<version>${plugin.spotify.version}</version>
				<configuration>
					<imageName>${docker.image.prefix}/${project.artifactId}</imageName>
					<imageTags>
						<imageTag>${project.version}</imageTag>
					</imageTags>
					<baseImage>java</baseImage>
					<entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
					<resources>
						<resource>
							<targetPath>/</targetPath>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
					<registryUrl>https://${docker.image.prefix}</registryUrl>
					<serverId>${docker.image.prefix}</serverId>
				</configuration>
			</plugin>
      
 # How to build :
 
 1. mvn clean package 
 2. Add the Azure conatainer reg details in the  maven profile settings.xml under the <servers> tag as below.
      <server>
  <id><your Azure container registery name>.azurecr.io</id>
  <username><azure container reg user></username>
  <password><azure container reg password></password>
  <configuration>
    <email><Your email></email>
  </configuration>
</server>

   3. mvn docker:build docker:push
        This command will create the docker image and will push to your  azure container registery
   4. az account set --subscription <your subcription name>
   5. az aks get-credentials --resource-group <your resource group> --name kubernate-service-clust
   6. kubectl create deployment azurewithcosmos --image=m<your azure container registery name>.azurecr.io/azurewithcosmos:latest
   7. kubectl get pod    This command will show your running pod in running status
   8. kubectl expose deployment azurewithcosmos --type=LoadBalancer --port=8080  —> this command to expose the service to 8080 port 
   9. Kubectl get services —> Now you should able to see your app as service one with load balancing  IPs like cluster and external try to use external IP to test the  service
    
      
      
      
      
      
     
