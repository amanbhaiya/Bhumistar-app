package com.digitalamanmedia.bhumistar.core.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.lang.Exception
import java.util.*

object EncodedImages {


    fun encodedString(uri: Uri?, context: Context): String {
        return try {
            val inputStream = uri?.let { context.contentResolver.openInputStream(it) }
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream)
            val bytesOfImage = byteArrayOutputStream.toByteArray()
            Base64.encodeToString(bytesOfImage, Base64.DEFAULT)
        }catch (e:Exception){
            e.localizedMessage?:""
        }
    }
}