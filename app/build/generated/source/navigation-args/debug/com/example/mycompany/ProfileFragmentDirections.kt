package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class ProfileFragmentDirections private constructor() {
  private data class ActionProfileFragmentToEditProfileFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_profileFragment_to_editProfileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  private data class ActionProfileFragmentToPerformanceFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_profileFragment_to_performanceFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  private data class ActionProfileFragmentToVoteListFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_profileFragment_to_voteListFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  public companion object {
    public fun actionProfileFragmentToEditProfileFragment(editId: Int = -1): NavDirections =
        ActionProfileFragmentToEditProfileFragment(editId)

    public fun actionProfileFragmentToPerformanceFragment(editId: Int = -1): NavDirections =
        ActionProfileFragmentToPerformanceFragment(editId)

    public fun actionProfileFragmentToVoteListFragment(editId: Int = -1): NavDirections =
        ActionProfileFragmentToVoteListFragment(editId)
  }
}
