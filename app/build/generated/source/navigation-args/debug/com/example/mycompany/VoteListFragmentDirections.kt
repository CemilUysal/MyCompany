package com.example.mycompany

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int

public class VoteListFragmentDirections private constructor() {
  private data class ActionVoteListFragmentToProfileFragment(
    public val editId: Int = -1,
    public val commingFrom: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteListFragment_to_profileFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("commingFrom", this.commingFrom)
      return result
    }
  }

  private data class ActionVoteListFragmentToPerformanceFragment(
    public val editId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteListFragment_to_performanceFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      return result
    }
  }

  private data class ActionVoteListFragmentToVoteFragment(
    public val editId: Int = -1,
    public val voteId: Int = -1
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_voteListFragment_to_voteFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("editId", this.editId)
      result.putInt("voteId", this.voteId)
      return result
    }
  }

  public companion object {
    public fun actionVoteListFragmentToProfileFragment(editId: Int = -1, commingFrom: Int = -1):
        NavDirections = ActionVoteListFragmentToProfileFragment(editId, commingFrom)

    public fun actionVoteListFragmentToPerformanceFragment(editId: Int = -1): NavDirections =
        ActionVoteListFragmentToPerformanceFragment(editId)

    public fun actionVoteListFragmentToVoteFragment(editId: Int = -1, voteId: Int = -1):
        NavDirections = ActionVoteListFragmentToVoteFragment(editId, voteId)
  }
}
