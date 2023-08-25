import com.cloudbees.plugins.credentials.impl.*
import com.cloudbees.plugins.credentials.*
import com.cloudbees.plugins.credentials.domains.*
import com.cloudbees.jenkins.plugins.sshcredentials.impl.*
import com.cloudbees.plugins.credentials.CredentialsScope
import com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl
import com.cloudbees.plugins.credentials.SystemCredentialsProvider
import com.cloudbees.plugins.credentials.domains.Domain

def call() {

    // def source = new BasicSSHUserPrivateKey.DirectEntryPrivateKeySource("key")
    // def ck1 = new BasicSSHUserPrivateKey(CredentialsScope.GLOBAL,'secret_id', "testing2", source, "Classic@idj@", "This is for testing")

    // SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), ck1)
    def credential = new UsernamePasswordCredentialsImpl(
        CredentialsScope.GLOBAL,
        'secret_id1',
        'YourUsername',
        'YourPassword',
        'This is for testing'
    )

    SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), credential)
}




