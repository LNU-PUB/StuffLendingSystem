package com.view;

import com.controller.model.Actions.MemberActions;
import com.model.Member;
import com.model.MemberRepository;
import com.view.model.AbstractView;
import com.view.model.ViewArguments;
import java.util.ResourceBundle;

/**
 * Responsible for displaying information to the user.
 */
public class MemberView extends AbstractView {
  private final int memberIndex;
  private final ViewArguments args;

  /**
   * Creates a new instance of the view.
   *
   * @param args - the view arguments.
   * @param memberIndex - the index of the member to display.
   */
  public MemberView(ViewArguments args, int memberIndex) {
    super(args.getLanguage(), args.getBundleName());
    this.args = args;
    this.memberIndex = memberIndex;
  }


  @Override
  public void displayMenu() {
    // TODO: Dsiplay the Member and available methods.
    displayGreeting();
    System.out.println("- " + texts.getString("title") + " -\n");
    displayMemberDetails();
    
    for (MemberActions actions : MemberActions.values()) {
      if (actions != MemberActions.UNKNOWN) {
        System.out.println(actions.getSelector() + " - " + texts.getString(actions.getName()));
      }
    }
  }


  private void displayMemberDetails() {
    MemberRepository memberRepo = args.getMemberRepo();
    Member member = memberRepo.getMembers().get(memberIndex);

    System.out.println(texts.getString("name") + ": " + member.getName());
    System.out.println(texts.getString("id") + ": " + member.getId());
    System.out.println(texts.getString("email") + ": " + member.getEmail());
    System.out.println(texts.getString("mobile") + ": " + member.getMobile());
    System.out.println(texts.getString("itemsNo") + ": " + member.getNumberOfItems());
    System.out.println(texts.getString("credits") + ": " + member.getCredits());
    System.out.println(texts.getString("memberSince") + ": " + member.getMemberCreationDay());
    System.out.println("\n---\n");
  }
}
