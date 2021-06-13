package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class LoginFragmentDirections private constructor() {
  private data class ActionLoginFragmentToProfileFragment(
    public val editId: Int = -1,
    public val commingFrom: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_loginFragment_to_profileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("commingFrom", this.commingFrom)
      return result
    }
  }

  public companion object {
    public fun actionLoginFragmentToProfileFragment(editId: Int = -1, commingFrom: Int = -1):
        NavDirections = ActionLoginFragmentToProfileFragment(editId, commingFrom)
  }
}
