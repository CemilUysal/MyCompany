package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class ProfileFragmentArgs(
  public val editId: Int = -1,
  public val commingFrom: Int = -1
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("editId", this.editId)
    result.putInt("commingFrom", this.commingFrom)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProfileFragmentArgs {
      bundle.setClassLoader(ProfileFragmentArgs::class.java.classLoader)
      val __editId : Int
      if (bundle.containsKey("editId")) {
        __editId = bundle.getInt("editId")
      } else {
        __editId = -1
      }
      val __commingFrom : Int
      if (bundle.containsKey("commingFrom")) {
        __commingFrom = bundle.getInt("commingFrom")
      } else {
        __commingFrom = -1
      }
      return ProfileFragmentArgs(__editId, __commingFrom)
    }
  }
}
