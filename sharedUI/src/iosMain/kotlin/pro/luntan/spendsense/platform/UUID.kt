package pro.luntan.spendsense.platform

import platform.Foundation.NSUUID

actual fun randomUUID() = NSUUID().UUIDString()