package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class VoteFragmentDirections private constructor() {
  private data class ActionVoteFragmentToVoteListFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteFragment_to_voteListFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  private data class ActionVoteFragmentToProfileFragment(
    public val editId: Int = -1,
    public val commingFrom: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteFragment_to_profileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("commingFrom", this.commingFrom)
      return result
    }
  }

  private data class ActionVoteFragmentToPerformanceFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteFragment_to_performanceFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  public companion object {
    public fun actionVoteFragmentToVoteListFragment(editId: Int = -1): NavDirections =
        ActionVoteFragmentToVoteListFragment(editId)

    public fun actionVoteFragmentToProfileFragment(editId: Int = -1, commingFrom: Int = -1):
        NavDirections = ActionVoteFragmentToProfileFragment(editId, commingFrom)

    public fun actionVoteFragmentToPerformanceFragment(editId: Int = -1): NavDirections =
        ActionVoteFragmentToPerformanceFragment(editId)
  }
}
