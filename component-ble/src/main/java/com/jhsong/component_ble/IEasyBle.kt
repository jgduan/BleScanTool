package com.jhsong.component_ble

/**
 * ClassName IEasyBle
 * Describe TODO<EasyBle操作接口>
 * Author zihao
 * Date 2022/3/13 17:25
 * Version v1.0
 */
interface IEasyBle {
    fun connect(deviceAddress: String)

    fun disconnect(deviceAddress: String)

    fun scanDevice()
}