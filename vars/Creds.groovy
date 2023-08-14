import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*

def call() {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    // println("Hello world inside scriptn1")
    // def usernameCredentials = [
    //     $class: 'UsernamePasswordMultiBinding',
    //     credentialsId: 'my-secret-username-id',
    //     usernameVariable: 'USERNAME',
    //     passwordVariable: 'PASSWORD'
    // ]
    
    // def passwordCredentials = [
    //     $class: 'StringBinding',
    //     credentialsId: 'my-secret-password-id',
    //     variable: 'PASSWORD'
    // ]
    
    // def domainCredentials = [
    //     $class: 'DomainSpecification',
    //     credentialsId: 'my-secret-domain-id',
    //     domain: [
    //         name: 'my-domain',
    //         specifications: [usernameCredentials, passwordCredentials]
    //     ]
    // ]
    
    // def credentialsProvider = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].domainCredentialsMap
    // println(domainCredentials)
    // println(credentialsProvider)
    // credentialsProvider.get('system').addCredentials('system', domainCredentials)
    

    def source = new BasicSSHUserPrivateKey.DirectEntryPrivateKeySource("key")
    def ck1 = new BasicSSHUserPrivateKey(CredentialsScope.GLOBAL,java.util.UUID.randomUUID().toString(), "username", source, "passphrase", "description")

    SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), ck1)
}
