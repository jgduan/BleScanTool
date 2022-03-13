package com.jhsong.component_ble

import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult

/**
 * ClassName EasyBle
 * Describe TODO<EasyBle>
 * Author zihao
 * Date 2022/3/13 17:24
 * Version v1.0
 */
class EasyBle private constructor(builder: Builder) : IEasyBle {

    companion object {
        fun build(): Builder {// 静态实例化建造者Builder类
            return Builder()
        }
    }

    override fun connect(deviceAddress: String) {
    }

    override fun disconnect(deviceAddress: String) {
    }

    override fun scanDevice() {
        // 开始前需要检查是否开启了蓝牙权限、是否打开了位置信息
        // 这里开始进行BLE设备扫描
        EasyScanner.build()
            .setScanCallback(object : ScanCallback() {
                override fun onScanResult(callbackType: Int, result: ScanResult?) {
                    super.onScanResult(callbackType, result)
                }

                override fun onBatchScanResults(results: MutableList<ScanResult>?) {
                    super.onBatchScanResults(results)
                }

                override fun onScanFailed(errorCode: Int) {
                    super.onScanFailed(errorCode)
                }
            })
            .setScanTime(5000)
            .create()
            .startScan()
    }

    // 建造者类
    class Builder {
        // 创建EasyBle类的实例化
        fun create(): EasyBle = EasyBle(this)
    }
}