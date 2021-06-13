package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class VoteFragmentArgs(
  public val editId: Int = -1,
  public val voteId: Int = -1
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("editId", this.editId)
    result.putInt("voteId", this.voteId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): VoteFragmentArgs {
      bundle.setClassLoader(VoteFragmentArgs::class.java.classLoader)
      val __editId : Int
      if (bundle.containsKey("editId")) {
        __editId = bundle.getInt("editId")
      } else {
        __editId = -1
      }
      val __voteId : Int
      if (bundle.containsKey("voteId")) {
        __voteId = bundle.getInt("voteId")
      } else {
        __voteId = -1
      }
      return VoteFragmentArgs(__editId, __voteId)
    }
  }
}
