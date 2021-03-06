import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.1"

project {
    description = "Contains all other projects"

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "coverage.zip!index.html")
            param("title", "Code Coverage")
            param("type", "BuildReportTab")
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }

    subProject(E)
}


object E : Project({
    name = "e"

    vcsRoot(E_Xirgocomon)

    buildType(E_Fdsf)
})

object E_Fdsf : BuildType({
    name = "fdsf"

    artifactRules = "**/*.txt"

    steps {
        script {
            name = "fddd"
            scriptContent = """
                echo foo > foo.txt
                mkdir bar
                echo barfoo > bar/foo.txt
            """.trimIndent()
        }
    }
})

object E_Xirgocomon : GitVcsRoot({
    name = "Xirgocomon"
    url = "ssh://git@bitbucket.xirgotech.com:7999/xdm/xirgocommonlib.git"
    authMethod = uploadedKey {
        userName = "git"
        uploadedKey = "id_rsa"
    }
})
