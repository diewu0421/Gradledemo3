import com.android.build.api.transform.*
import com.android.build.api.transform.Transform
import com.android.build.gradle.internal.pipeline.TransformManager
import java.io.File

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2021/1/13 2:07 PM
 */

class Transform : Transform() {
    override fun getName(): String {
        return "zenglwTransform"
    }

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        return TransformManager.CONTENT_CLASS
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return TransformManager.SCOPE_FULL_PROJECT
    }

    override fun transform(transformInvocation: TransformInvocation) {
        super.transform(transformInvocation)
        val outputProvider = transformInvocation.outputProvider

        transformInvocation.inputs.forEach {
            it.directoryInputs.forEach {dir->
                allFile(dir.file)
            }

            it.jarInputs.forEach {jar->
                println("jarFile ---- ${jar.file.absoluteFile}")
            }
        }
    }

    private fun allFile(dir: File) {
        if (dir.isDirectory) {

            dir.listFiles().forEach {
                if (it.isFile) {
                    if (it.absolutePath.contains("/debug/")) {
                        it.deleteOnExit()
                    }
                    println("file == ${it.absolutePath}")
                } else {
                    allFile(it)
                }
            }
        }

    }

}