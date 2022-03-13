package com.jhsong.blescantool

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.jhsong.component_ble.util.BleUtils
import permissions.dispatcher.PermissionRequest
import permissions.dispatcher.ktx.LocationPermission
import permissions.dispatcher.ktx.constructLocationPermissionRequest

class MainActivity : AppCompatActivity() {
    // constructPermissionsRequest must be invoked every time an activity is created
    private val locationPermission = constructLocationPermissionRequest(
        LocationPermission.COARSE, LocationPermission.FINE,
        onShowRationale = ::onLocationShowRationale,
        onPermissionDenied = ::onLocationDenied,
        onNeverAskAgain = ::onLocationNeverAskAgain
    ) {
        // do something here
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationPermission.launch()
        BleUtils.openBle(this)
    }

    // 用户未授予权限时调用
    private fun onLocationDenied() {
        Toast.makeText(this, "获取位置信息权限失败，会影响蓝牙搜索功能！", Toast.LENGTH_SHORT).show()
    }

    // 解释为什么需要权限
    private fun onLocationShowRationale(request: PermissionRequest) {
        // 继续请求操作
        request.proceed()
    }

    // 用户勾选“不再询问”选项时调用
    private fun onLocationNeverAskAgain() {
        Toast.makeText(
            this, "用户永久拒绝获取位置信息权限，会影响蓝牙搜索功能！", Toast.LENGTH_SHORT
        ).show()
    }

}