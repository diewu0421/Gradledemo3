import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import sun.security.jgss.SunProvider
import java.io.File
import java.util.*

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2021/1/13 11:58 AM
 */
class MyPlugin : Plugin<Project>{
    override fun apply(project: Project) {
        println("1111111111111")
//            ?.registerTransform(Transform(), Collections.EMPTY_LIST)

        project.afterEvaluate {
            val appExtension = project.extensions.findByType(AppExtension::class.java)
            println("appExtenstion ${appExtension?.applicationVariants}")
            appExtension?.applicationVariants?.forEach {
                it.name.takeIf { it.contains("debug") }?.let {appName->
                    project.rootProject.childProjects.forEach {name, subProject ->

                        println("name = $name subProjectg = $subProject")
                        subProject.tasks.findByName("compile${appName.capitalize()}Kotlin")?.run {
                            doLast {
                                outputs.files.files.forEach { file->
                                    getAllFile(file)
                                }

                            }
                        }

                    }
                }
            }
        }
    }

    private fun getAllFile(file: File) {
        println("fie = $file")
        if (file.isDirectory) {
            file.listFiles().forEach {
               getAllFile(it)
            }
        } else if (file.name.endsWith(".class")) {
            if (file.absolutePath.substringAfter("debug").contains("/debug/")) {
                println("delete debug")
                file.delete()
            }
        }
    }

}