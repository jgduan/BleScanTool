package com.jhsong.component_ble

import android.bluetooth.BluetoothAdapter
import android.bluetooth.le.ScanCallback
import com.jhsong.component_ble.util.BleUtils

/**
 * ClassName EasyScanner
 * Describe TODO<Ble扫描类>
 * Author zihao
 * Date 2022/3/13 23:08
 * Version v1.0
 */
class EasyScanner private constructor(builder: Builder) {

    private var mScanCallback: ScanCallback? = null
    private var mScanTime = 3000

    init {
        mScanCallback = builder.scanCallback
        mScanTime = builder.scanTime
    }

    companion object {
        fun build(): Builder {
            return Builder()
        }
    }

    class Builder {
        var scanCallback: ScanCallback? = null
        var scanTime = 3000

        fun setScanTime(scanTime: Int): Builder {
            this@Builder.scanTime = scanTime
            return this
        }

        fun setScanCallback(scanCallback: ScanCallback): Builder {
            this@Builder.scanCallback = scanCallback
            return this
        }

        fun create(): EasyScanner = EasyScanner(this)
    }

    fun startScan() {
        mScanCallback?.run {
            BleUtils.getBluetoothAdapter().bluetoothLeScanner.startScan(
                this
            )
        }
    }

    fun stopScan() {
        mScanCallback?.run {
            BleUtils.getBluetoothAdapter().bluetoothLeScanner.stopScan(
                this
            )
        }
    }
}