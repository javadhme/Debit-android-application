package ir.javadhashemi.debit.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import java.util.*

/**
 * CREATED BY Javadroid FOR `WiCalory` PROJECT
 * AT: 2018/Jun/09 16:26
 */
class PermissionUtil {

    private val requestCode: Int by lazy { Random().nextInt(4000) }
    private lateinit var callback: (grantedPermissions: List<String>, deniedPermissions: List<String>) -> Unit

    companion object {
        val galleryPermissions = arrayOf("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")

        val cameraPermissions = arrayOf("android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE")

        val requestArray = arrayOf(
                "android.permission.CAMERA",
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        )
        const val PERMISSION_CAMERA = "android.permission.CAMERA"
        const val PERMISSION_READ_EXTERNAL = "android.permission.READ_EXTERNAL_STORAGE"
        const val PERMISSION_WRITE_EXTERNAL = "android.permission.WRITE_EXTERNAL_STORAGE"
    }

    fun requestPermission(
            activity: Activity,
            vararg permissions: String,
            callback: (grantedPermissions: List<String>, declinedPermissions: List<String>) -> Unit) {

        if (permissions.isEmpty()) return
        this.callback = callback
        if (isAllPermissionsGranted(activity, *permissions)) {
            callback(permissions.toList(), emptyList())
            return
        }
        ActivityCompat.requestPermissions(activity, permissions, requestCode)
    }

    fun requestPermission(
            fragment: Fragment,
            vararg permissions: String,
            callback: (grantedPermissions: List<String>, declinedPermissions: List<String>) -> Unit) {

        if (permissions.isEmpty()) return
        this.callback = callback
        if (isAllPermissionsGranted(fragment.context!!, *permissions)) {
            callback(permissions.toList(), emptyList())
            return
        }
        fragment.requestPermissions(permissions, requestCode)
    }

    fun isAllPermissionsGranted(context: Context, vararg permissions: String): Boolean =
            permissions.all {
                ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
            }

    fun onRequestResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (this.requestCode != requestCode) return

        val granted = permissions.filterIndexed { index, _ -> grantResults[index] == PackageManager.PERMISSION_GRANTED }
        val denied = permissions.filterIndexed { index, _ -> grantResults[index] == PackageManager.PERMISSION_GRANTED }
        callback(granted, denied)
    }

    fun checkMarshMellowPermission(): Boolean = Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1

}