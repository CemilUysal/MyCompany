package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class PerformanceFragmentDirections private constructor() {
  private data class ActionPerformanceFragmentToProfileFragment(
    public val editId: Int = -1,
    public val commingFrom: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_performanceFragment_to_profileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("commingFrom", this.commingFrom)
      return result
    }
  }

  private data class ActionPerformanceFragmentToVoteListFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_performanceFragment_to_voteListFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  public companion object {
    public fun actionPerformanceFragmentToProfileFragment(editId: Int = -1, commingFrom: Int = -1):
        NavDirections = ActionPerformanceFragmentToProfileFragment(editId, commingFrom)

    public fun actionPerformanceFragmentToVoteListFragment(editId: Int = -1): NavDirections =
        ActionPerformanceFragmentToVoteListFragment(editId)
  }
}
