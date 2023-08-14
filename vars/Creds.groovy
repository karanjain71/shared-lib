def call() {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    println("Hello world inside script")
    def usernameCredentials = [
        $class: 'UsernamePasswordMultiBinding',
        credentialsId: 'my-secret-username-id',
        usernameVariable: 'USERNAME',
        passwordVariable: 'PASSWORD'
    ]
    
    def passwordCredentials = [
        $class: 'StringBinding',
        credentialsId: 'my-secret-password-id',
        variable: 'PASSWORD'
    ]
    
    def domainCredentials = [
        $class: 'DomainSpecification',
        credentialsId: 'my-secret-domain-id',
        domain: [
            $class: 'Domain',
            name: 'my-domain',
            specifications: [usernameCredentials, passwordCredentials]
        ]
    ]
    
    def credentialsProvider = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0].domainCredentialsMap
    credentialsProvider.get('system').addCredentials(Domain.global(), domainCredentials)
}