package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class EditProfileFragmentArgs(
  public val editId: Int = -1
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("editId", this.editId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): EditProfileFragmentArgs {
      bundle.setClassLoader(EditProfileFragmentArgs::class.java.classLoader)
      val __editId : Int
      if (bundle.containsKey("editId")) {
        __editId = bundle.getInt("editId")
      } else {
        __editId = -1
      }
      return EditProfileFragmentArgs(__editId)
    }
  }
}
