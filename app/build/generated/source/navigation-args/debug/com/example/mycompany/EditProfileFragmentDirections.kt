package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class EditProfileFragmentDirections private constructor() {
  private data class ActionEditProfileFragmentToProfileFragment(
    public val editId: Int = -1,
    public val commingFrom: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_editProfileFragment_to_profileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("commingFrom", this.commingFrom)
      return result
    }
  }

  private data class ActionEditProfileFragmentToPerformanceFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_editProfileFragment_to_performanceFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  private data class ActionEditProfileFragmentToVoteListFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_editProfileFragment_to_voteListFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  public companion object {
    public fun actionEditProfileFragmentToProfileFragment(editId: Int = -1, commingFrom: Int = -1):
        NavDirections = ActionEditProfileFragmentToProfileFragment(editId, commingFrom)

    public fun actionEditProfileFragmentToPerformanceFragment(editId: Int = -1): NavDirections =
        ActionEditProfileFragmentToPerformanceFragment(editId)

    public fun actionEditProfileFragmentToVoteListFragment(editId: Int = -1): NavDirections =
        ActionEditProfileFragmentToVoteListFragment(editId)
  }
}
